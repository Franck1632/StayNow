package model;

import java.time.LocalDateTime;

/**
 * Clase que representa un pago realizado por un cliente.
 * Contiene información como ID, monto, método de pago y fecha.
 * 
 * @author Franckarlos Barbosa
 * @version 1.0
 */
public class Pago {

    /** Identificador único del pago */
    private String idPago;

    /** Monto del pago */
    private double monto;

    /** Método de pago utilizado (ej. tarjeta, efectivo) */
    private String metodoPago;

    /** Fecha y hora en que se realizó el pago */
    private LocalDateTime fechaPago;

    /**
     * Constructor de la clase Pago.
     * La fecha se asigna automáticamente al momento de la creación.
     *
     * @param idPago     Identificador único del pago.
     * @param monto      Monto del pago.
     * @param metodoPago Método de pago utilizado.
     */
    public Pago(String idPago, double monto, String metodoPago) {
        this.idPago = idPago;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fechaPago = LocalDateTime.now();
    }

    /**
     * Registra el pago mostrando un mensaje en consola.
     */
    public void registrarPago() {
        System.out.println("Pago registrado: $" + monto + " - " + metodoPago);
    }

    /**
     * Devuelve la información del pago en formato CSV.
     *
     * @return String CSV con los datos del pago.
     */
    public String toCSV() {
        return idPago + "," + monto + "," + metodoPago + "," + fechaPago;
    }

    /** @return ID del pago */
    public String getIdPago() { return idPago; }

    /** @return Monto del pago */
    public double getMonto() { return monto; }

    /** @return Método de pago */
    public String getMetodoPago() { return metodoPago; }

    /** @return Fecha y hora del pago */
    public LocalDateTime getFechaPago() { return fechaPago; }
}
