package model;

public class Hotel extends Alojamiento {
    private int estrellas;
    private boolean servicioDesayuno;

    public Hotel(String codigo, String nombre, String ubicacion, 
                double precioPorNoche, int estrellas, boolean servicioDesayuno) {
        super(codigo, nombre, ubicacion, precioPorNoche);
        this.estrellas = estrellas;
        this.servicioDesayuno = servicioDesayuno;
    }

    @Override
    public double calcularCostoEstadia(int dias) {
        double costoBase = precioPorNoche * dias;
        // Recargo por estrellas (5% por cada estrella arriba de 3)
        if (estrellas > 3) {
            costoBase += costoBase * (estrellas - 3) * 0.05;
        }
        // Recargo por desayuno
        if (servicioDesayuno) {
            costoBase += 20 * dias; // $20 por día por desayuno
        }
        return costoBase;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Estrellas: " + estrellas);
        System.out.println("Servicio desayuno: " + (servicioDesayuno ? "Sí" : "No"));
    }

    @Override
    public String toCSV() {
        return "Hotel," + super.toCSV() + "," + estrellas + "," + servicioDesayuno;
    }
}