package controller.loader;

import model.Cliente;
import model.exceptions.ArchivoNoEncontradoException;
import java.io.*;
import java.util.ArrayList;

/**
 * Clase para cargar y guardar clientes desde/hacia archivos CSV.
 * 
 * @author Franckarlos Barbosa
 * @version 1.0
 */
public class ClienteLoader {

    /**
     * Carga clientes desde un archivo CSV.
     *
     * @param archivo Ruta del archivo CSV.
     * @return Lista de clientes.
     * @throws ArchivoNoEncontradoException Si el archivo no existe.
     */
    public static ArrayList<Cliente> cargarClientes(String archivo) throws ArchivoNoEncontradoException {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                if (values.length >= 3) {
                    String id = values[0].trim();
                    String nombre = values[1].trim();
                    String email = values[2].trim();
                    clientes.add(new Cliente(id, nombre, email));
                }
            }
        } catch (FileNotFoundException e) {
            throw new ArchivoNoEncontradoException(archivo, e);
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
        return clientes;
    }

    /**
     * Guarda una lista de clientes en un archivo CSV.
     *
     * @param archivo  Ruta del archivo CSV.
     * @param clientes Lista de clientes a guardar.
     */
    public static void guardarClientes(String archivo, ArrayList<Cliente> clientes) {
        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write("ID,Nombre,Email\n");
            for (Cliente cliente : clientes) {
                writer.write(cliente.toCSV() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error guardando clientes: " + e.getMessage());
        }
    }
}
