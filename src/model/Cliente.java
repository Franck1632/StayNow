package model;

/**
 * Clase que representa un cliente del sistema.
 * Contiene información básica como ID, nombre y email.
 * 
 * @author Franckarlos Barbosa
 * @version 1.0
 */
public class Cliente {

    /** Identificador único del cliente */
    private String id;

    /** Nombre completo del cliente */
    private String nombre;

    /** Correo electrónico del cliente */
    private String email;

    /**
     * Constructor de la clase Cliente.
     *
     * @param id     Identificador único del cliente.
     * @param nombre Nombre completo del cliente.
     * @param email  Correo electrónico del cliente.
     */
    public Cliente(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    /**
     * Muestra en consola la información del cliente.
     */
    public void mostrarInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
    }

    /**
     * Devuelve la información del cliente en formato CSV.
     *
     * @return String CSV con los datos del cliente.
     */
    public String toCSV() {
        return id + "," + nombre + "," + email;
    }

    /** @return ID del cliente */
    public String getId() { return id; }

    /** @return Nombre del cliente */
    public String getNombre() { return nombre; }

    /** @return Email del cliente */
    public String getEmail() { return email; }
}
