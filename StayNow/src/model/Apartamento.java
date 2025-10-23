package model;

public class Apartamento extends Alojamiento {
    private int numHabitaciones;
    private boolean tieneParqueadero;

    public Apartamento(String codigo, String nombre, String ubicacion,
                    double precioPorNoche, int numHabitaciones, boolean tieneParqueadero) {
        super(codigo, nombre, ubicacion, precioPorNoche);
        this.numHabitaciones = numHabitaciones;
        this.tieneParqueadero = tieneParqueadero;
    }

    @Override
    public double calcularCostoEstadia(int dias) {
        double costoBase = precioPorNoche * dias;
        // Descuento por estadías largas en apartamentos
        if (dias > 7) {
            costoBase *= 0.9; // 10% de descuento
        }
        // Recargo por parqueadero
        if (tieneParqueadero) {
            costoBase += 15 * dias; // $15 por día por parqueadero
        }
        return costoBase;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Número de habitaciones: " + numHabitaciones);
        System.out.println("Tiene parqueadero: " + (tieneParqueadero ? "Sí" : "No"));
    }

    @Override
    public String toCSV() {
        return "Apartamento," + super.toCSV() + "," + numHabitaciones + "," + tieneParqueadero;
    }
}