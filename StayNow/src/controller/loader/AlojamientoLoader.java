package controller.loader;

import model.*;
import model.exceptions.ArchivoNoEncontradoException;
import java.io.*;
import java.util.ArrayList;

/**
 * Clase para cargar y guardar alojamientos desde/hacia archivos CSV.
 * 
 * @author Franckarlos Barbosa
 * @version 1.0
 */
public class AlojamientoLoader {

    /**
     * Carga alojamientos desde un archivo CSV.
     *
     * @param archivo Ruta del archivo CSV.
     * @return Lista de alojamientos.
     * @throws ArchivoNoEncontradoException Si el archivo no existe.
     */
    public static ArrayList<Alojamiento> cargarAlojamientos(String archivo) throws ArchivoNoEncontradoException {
        ArrayList<Alojamiento> alojamientos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                if (values.length >= 5) {
                    Alojamiento alojamiento = crearAlojamientoDesdeCSV(values);
                    if (alojamiento != null) {
                        alojamientos.add(alojamiento);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new ArchivoNoEncontradoException(archivo, e);
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
        return alojamientos;
    }

    /**
     * Crea un alojamiento a partir de los valores de una línea CSV.
     *
     * @param values Valores de la línea CSV.
     * @return Alojamiento creado o null si hay error.
     */
    private static Alojamiento crearAlojamientoDesdeCSV(String[] values) {
        String tipo = values[0].trim();
        String codigo = values[1].trim();
        String nombre = values[2].trim();
        String ubicacion = values[3].trim();
        double precio = Double.parseDouble(values[4].trim());
        try {
            switch(tipo) {
                case "Hotel":
                    int estrellas = Integer.parseInt(values[5].trim());
                    boolean desayuno = Boolean.parseBoolean(values[6].trim());
                    return new Hotel(codigo, nombre, ubicacion, precio, estrellas, desayuno);
                case "Apartamento":
                    int habitaciones = Integer.parseInt(values[5].trim());
                    boolean parqueadero = Boolean.parseBoolean(values[6].trim());
                    return new Apartamento(codigo, nombre, ubicacion, precio, habitaciones, parqueadero);
                case "Cabana":
                    String zona = values[5].trim();
                    int capacidad = Integer.parseInt(values[6].trim());
                    return new Cabana(codigo, nombre, ubicacion, precio, zona, capacidad);
                default:
                    System.out.println("Tipo de alojamiento desconocido: " + tipo);
                    return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error en formato numérico para alojamiento: " + nombre);
            return null;
        }
    }

    /**
     * Guarda una lista de alojamientos en un archivo CSV.
     *
     * @param archivo       Ruta del archivo CSV.
     * @param alojamientos  Lista de alojamientos a guardar.
     */
    public static void guardarAlojamientos(String archivo, ArrayList<Alojamiento> alojamientos) {
        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write("Tipo,Codigo,Nombre,Ubicacion,Precio,Extra1,Extra2,Extra3\n");
            for (Alojamiento alojamiento : alojamientos) {
                writer.write(alojamiento.toCSV() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error guardando alojamientos: " + e.getMessage());
        }
    }
}
