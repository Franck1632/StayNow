package model;

public class Cabana extends Alojamiento {
    private String zona;
    private int capacidadPersonas;

    public Cabana(String codigo, String nombre, String ubicacion,
                double precioPorNoche, String zona, int capacidadPersonas) {
        super(codigo, nombre, ubicacion, precioPorNoche);
        this.zona = zona;
        this.capacidadPersonas = capacidadPersonas;
    }

    @Override
    public double calcularCostoEstadia(int dias) {
        double costoBase = precioPorNoche * dias;
        // Recargo por zona premium
        if (zona.equalsIgnoreCase("premium")) {
            costoBase *= 1.15; // 15% de recargo
        }
        // Recargo por capacidad
        if (capacidadPersonas > 4) {
            costoBase += 10 * capacidadPersonas; // $10 por persona extra
        }
        return costoBase;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Zona: " + zona);
        System.out.println("Capacidad: " + capacidadPersonas + " personas");
    }

    @Override
    public String toCSV() {
        return "Cabaña," + super.toCSV() + "," + zona + "," + capacidadPersonas;
    }
}