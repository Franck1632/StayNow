package model;

public abstract class Alojamiento {
    protected String codigo;
    protected String nombre;
    protected String ubicacion;
    protected double precioPorNoche;

    public Alojamiento(String codigo, String nombre, String ubicacion, double precioPorNoche) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.precioPorNoche = precioPorNoche;
    }

    public abstract double calcularCostoEstadia(int dias);

    public void mostrarInfo() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Precio por noche: $" + precioPorNoche);
    }

    public String toCSV() {
        return codigo + "," + nombre + "," + ubicacion + "," + precioPorNoche;
    }
    // Getters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getUbicacion() { return ubicacion; }
    public double getPrecioPorNoche() { return precioPorNoche; }
}