package model;

/**
 * Clase que representa un apartamento.
 * Hereda de {@link Alojamiento} e incluye número de habitaciones y parqueadero.
 * 
 * @author Franckarlos Barbosa
 * @version 1.0
 */
public class Apartamento extends Alojamiento {

    /** Número de habitaciones del apartamento */
    private int numHabitaciones;

    /** Indica si el apartamento tiene parqueadero */
    private boolean tieneParqueadero;

    /**
     * Constructor de la clase Apartamento.
     *
     * @param codigo           Código único del apartamento.
     * @param nombre           Nombre del apartamento.
     * @param ubicacion        Ubicación del apartamento.
     * @param precioPorNoche   Precio por noche.
     * @param numHabitaciones  Número de habitaciones.
     * @param tieneParqueadero Indica si tiene parqueadero.
     */
    public Apartamento(String codigo, String nombre, String ubicacion,
                    double precioPorNoche, int numHabitaciones, boolean tieneParqueadero) {
        super(codigo, nombre, ubicacion, precioPorNoche);
        this.numHabitaciones = numHabitaciones;
        this.tieneParqueadero = tieneParqueadero;
    }

    /**
     * Calcula el costo total de la estadía.
     * Aplica descuento por estadías mayores a 7 días y recargo por parqueadero.
     *
     * @param dias Número de días de la estadía.
     * @return Costo total de la estadía.
     */
    @Override
    public double calcularCostoEstadia(int dias) {
        double costoBase = precioPorNoche * dias;
        if (dias > 7) {
            costoBase *= 0.9; // 10% de descuento
        }
        if (tieneParqueadero) {
            costoBase += 15 * dias; // $15 por día por parqueadero
        }
        return costoBase;
    }

    /**
     * Muestra la información del apartamento en consola,
     * incluyendo número de habitaciones y si tiene parqueadero.
     */
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Número de habitaciones: " + numHabitaciones);
        System.out.println("Tiene parqueadero: " + (tieneParqueadero ? "Sí" : "No"));
    }

    /**
     * Devuelve la información del apartamento en formato CSV.
     *
     * @return String CSV con todos los datos del apartamento.
     */
    @Override
    public String toCSV() {
        return "Apartamento," + super.toCSV() + "," + numHabitaciones + "," + tieneParqueadero;
    }
}
