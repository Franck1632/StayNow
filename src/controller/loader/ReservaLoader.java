package controller.loader;

import model.Reserva;
import model.Cliente;
import model.Alojamiento;
import model.exceptions.ArchivoNoEncontradoException;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase para cargar y guardar reservas desde/hacia archivos CSV.
 * 
 * @author Franckarlos Barbosa
 * @version 1.0
 */
public class ReservaLoader {

    /**
     * Carga reservas desde un archivo CSV.
     *
     * @param archivo       Ruta del archivo CSV.
     * @param clientes      Lista de clientes para asociar a las reservas.
     * @param alojamientos  Lista de alojamientos para asociar a las reservas.
     * @return Lista de reservas.
     * @throws ArchivoNoEncontradoException Si el archivo no existe.
     */
    public static ArrayList<Reserva> cargarReservas(String archivo, ArrayList<Cliente> clientes, 
                                                    ArrayList<Alojamiento> alojamientos) throws ArchivoNoEncontradoException {
        ArrayList<Reserva> reservas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                if (values.length >= 6) {
                    Reserva reserva = crearReservaDesdeCSV(values, clientes, alojamientos);
                    if (reserva != null) {
                        reservas.add(reserva);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new ArchivoNoEncontradoException(archivo, e);
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
        return reservas;
    }

    /**
     * Crea una reserva a partir de los valores de una línea CSV.
     *
     * @param values        Valores de la línea CSV.
     * @param clientes      Lista de clientes para asociar.
     * @param alojamientos  Lista de alojamientos para asociar.
     * @return Reserva creada o null si hay error o no se encuentra cliente/alojamiento.
     */
    private static Reserva crearReservaDesdeCSV(String[] values, ArrayList<Cliente> clientes, 
                                                ArrayList<Alojamiento> alojamientos) {
        try {
            String idReserva = values[0].trim();
            String idCliente = values[1].trim();
            String codigoAlojamiento = values[2].trim();
            LocalDate fechaEntrada = LocalDate.parse(values[3].trim());
            LocalDate fechaSalida = LocalDate.parse(values[4].trim());
            // Buscar cliente
            Cliente cliente = null;
            for (Cliente c : clientes) {
                if (c.getId().equals(idCliente)) {
                    cliente = c;
                    break;
                }
            }
            // Buscar alojamiento
            Alojamiento alojamiento = null;
            for (Alojamiento a : alojamientos) {
                if (a.getCodigo().equals(codigoAlojamiento)) {
                    alojamiento = a;
                    break;
                }
            }
            if (cliente != null && alojamiento != null) {
                return new Reserva(idReserva, cliente, alojamiento, fechaEntrada, fechaSalida);
            } else {
                System.out.println("No se pudo crear reserva " + idReserva +
                                " - Cliente o alojamiento no encontrado");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error creando reserva desde CSV: " + e.getMessage());
            return null;
        }
    }

    /**
     * Guarda una lista de reservas en un archivo CSV.
     *
     * @param archivo  Ruta del archivo CSV.
     * @param reservas Lista de reservas a guardar.
     */
    public static void guardarReservas(String archivo, ArrayList<Reserva> reservas) {
        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write("IDReserva,IDCliente,CodigoAlojamiento,FechaEntrada,FechaSalida,Total\n");
            for (Reserva reserva : reservas) {
                writer.write(reserva.toCSV() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error guardando reservas: " + e.getMessage());
        }
    }
}
