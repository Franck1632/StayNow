package model;

/**
 * Clase que representa un hotel.
 * Hereda de {@link Alojamiento} e incluye estrellas y servicio de desayuno.
 * 
 * @author Franckarlos Barbosa
 * @version 1.0
 */
public class Hotel extends Alojamiento {

    /** Número de estrellas del hotel */
    private int estrellas;

    /** Indica si el hotel incluye servicio de desayuno */
    private boolean servicioDesayuno;

    /**
     * Constructor de la clase Hotel.
     *
     * @param codigo          Código único del hotel.
     * @param nombre          Nombre del hotel.
     * @param ubicacion       Ubicación del hotel.
     * @param precioPorNoche  Precio por noche.
     * @param estrellas       Número de estrellas.
     * @param servicioDesayuno Indica si incluye desayuno.
     */
    public Hotel(String codigo, String nombre, String ubicacion, 
                double precioPorNoche, int estrellas, boolean servicioDesayuno) {
        super(codigo, nombre, ubicacion, precioPorNoche);
        this.estrellas = estrellas;
        this.servicioDesayuno = servicioDesayuno;
    }

    /**
     * Calcula el costo total de la estadía.
     * Aplica recargo por estrellas superiores a 3 y por desayuno.
     *
     * @param dias Número de días de la estadía.
     * @return Costo total de la estadía.
     */
    @Override
    public double calcularCostoEstadia(int dias) {
        double costoBase = precioPorNoche * dias;
        if (estrellas > 3) {
            costoBase += costoBase * (estrellas - 3) * 0.05;
        }
        if (servicioDesayuno) {
            costoBase += 20 * dias;
        }
        return costoBase;
    }

    /**
     * Muestra la información del hotel en consola,
     * incluyendo estrellas y si tiene servicio de desayuno.
     */
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Estrellas: " + estrellas);
        System.out.println("Servicio desayuno: " + (servicioDesayuno ? "Sí" : "No"));
    }

    /**
     * Devuelve la información del hotel en formato CSV.
     *
     * @return String CSV con todos los datos del hotel.
     */
    @Override
    public String toCSV() {
        return "Hotel," + super.toCSV() + "," + estrellas + "," + servicioDesayuno;
    }
}
