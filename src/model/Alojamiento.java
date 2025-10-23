package model;

/**
 * Clase abstracta que representa un alojamiento genérico.
 * Puede ser un hotel, apartamento o cabaña.
 * Contiene atributos básicos como código, nombre, ubicación y precio por noche.
 * 
 * @author Franckarlos Barbosa
 * @version 1.0
 */
public abstract class Alojamiento {

    /** Código único del alojamiento */
    protected String codigo;

    /** Nombre del alojamiento */
    protected String nombre;

    /** Ubicación geográfica del alojamiento */
    protected String ubicacion;

    /** Precio por noche del alojamiento */
    protected double precioPorNoche;

    /**
     * Constructor de la clase Alojamiento.
     *
     * @param codigo         Código único del alojamiento.
     * @param nombre         Nombre del alojamiento.
     * @param ubicacion      Ubicación del alojamiento.
     * @param precioPorNoche Precio por noche.
     */
    public Alojamiento(String codigo, String nombre, String ubicacion, double precioPorNoche) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.precioPorNoche = precioPorNoche;
    }

    /**
     * Calcula el costo total de la estadía según la cantidad de días.
     *
     * @param dias Número de días de la estadía.
     * @return Costo total de la estadía.
     */
    public abstract double calcularCostoEstadia(int dias);

    /**
     * Muestra en consola la información del alojamiento.
     */
    public void mostrarInfo() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Precio por noche: $" + precioPorNoche);
    }

    /**
     * Devuelve la información del alojamiento en formato CSV.
     *
     * @return String con los datos separados por comas.
     */
    public String toCSV() {
        return codigo + "," + nombre + "," + ubicacion + "," + precioPorNoche;
    }


    /** @return Código del alojamiento */
    public String getCodigo() { return codigo; }

    /** @return Nombre del alojamiento */
    public String getNombre() { return nombre; }

    /** @return Ubicación del alojamiento */
    public String getUbicacion() { return ubicacion; }

    /** @return Precio por noche del alojamiento */
    public double getPrecioPorNoche() { return precioPorNoche; }
}
