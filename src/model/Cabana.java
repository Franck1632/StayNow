package model;

/**
 * Clase que representa una cabaña.
 * Hereda de {@link Alojamiento} e incluye zona y capacidad de personas.
 * 
 * @author Franckarlos Barbosa
 * @version 1.0
 */
public class Cabana extends Alojamiento {

    /** Zona donde se encuentra la cabaña (por ejemplo, "premium") */
    private String zona;

    /** Capacidad máxima de personas en la cabaña */
    private int capacidadPersonas;

    /**
     * Constructor de la clase Cabaña.
     *
     * @param codigo           Código único de la cabaña.
     * @param nombre           Nombre de la cabaña.
     * @param ubicacion        Ubicación de la cabaña.
     * @param precioPorNoche   Precio por noche.
     * @param zona             Zona de la cabaña.
     * @param capacidadPersonas Capacidad máxima de personas.
     */
    public Cabana(String codigo, String nombre, String ubicacion,
                double precioPorNoche, String zona, int capacidadPersonas) {
        super(codigo, nombre, ubicacion, precioPorNoche);
        this.zona = zona;
        this.capacidadPersonas = capacidadPersonas;
    }

    /**
     * Calcula el costo total de la estadía.
     * Aplica recargo por zona premium y por capacidad mayor a 4 personas.
     *
     * @param dias Número de días de la estadía.
     * @return Costo total de la estadía.
     */
    @Override
    public double calcularCostoEstadia(int dias) {
        double costoBase = precioPorNoche * dias;
        if (zona.equalsIgnoreCase("premium")) {
            costoBase *= 1.15; // 15% de recargo
        }
        if (capacidadPersonas > 4) {
            costoBase += 10 * capacidadPersonas; // $10 por persona extra
        }
        return costoBase;
    }

    /**
     * Muestra la información de la cabaña en consola,
     * incluyendo zona y capacidad de personas.
     */
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Zona: " + zona);
        System.out.println("Capacidad: " + capacidadPersonas + " personas");
    }

    /**
     * Devuelve la información de la cabaña en formato CSV.
     *
     * @return String CSV con todos los datos de la cabaña.
     */
    @Override
    public String toCSV() {
        return "Cabaña," + super.toCSV() + "," + zona + "," + capacidadPersonas;
    }
}
