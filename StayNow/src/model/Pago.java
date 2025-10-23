package model;

import java.time.LocalDateTime;

public class Pago {
    private String idPago;
    private double monto;
    private String metodoPago;
    private LocalDateTime fechaPago;

    public Pago(String idPago, double monto, String metodoPago) {
        this.idPago = idPago;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fechaPago = LocalDateTime.now();
    }

    public void registrarPago() {
        System.out.println("Pago registrado: $" + monto + " - " + metodoPago);
    }

    public String toCSV() {
        return idPago + "," + monto + "," + metodoPago + "," + fechaPago;
    }
    // Getters
    public String getIdPago() { return idPago; }
    public double getMonto() { return monto; }
    public String getMetodoPago() { return metodoPago; }
    public LocalDateTime getFechaPago() { return fechaPago; }
}