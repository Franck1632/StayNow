package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Clase que representa una reserva realizada por un cliente en un alojamiento.
 * Contiene información sobre fechas, cliente, alojamiento y total de la reserva.
 * 
 * @author Franckarlos Barbosa
 * @version 1.0
 */
public class Reserva {

    /** Identificador único de la reserva */
    private String idReserva;

    /** Cliente que realiza la reserva */
    private Cliente cliente;

    /** Alojamiento reservado */
    private Alojamiento alojamiento;

    /** Fecha de entrada */
    private LocalDate fechaEntrada;

    /** Fecha de salida */
    private LocalDate fechaSalida;

    /** Total calculado de la reserva */
    private double totalReserva;

    /**
     * Constructor de la clase Reserva.
     *
     * @param idReserva    ID único de la reserva.
     * @param cliente      Cliente que realiza la reserva.
     * @param alojamiento  Alojamiento reservado.
     * @param fechaEntrada Fecha de entrada.
     * @param fechaSalida  Fecha de salida.
     */
    public Reserva(String idReserva, Cliente cliente, Alojamiento alojamiento,
                    LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.alojamiento = alojamiento;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.totalReserva = calcularTotal();
    }

    /**
     * Calcula el número de días de la estadía.
     *
     * @return Número de días entre fecha de entrada y salida.
     */
    public int calcularDias() {
        return (int) ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
    }

    /**
     * Calcula el total de la reserva utilizando el costo del alojamiento.
     *
     * @return Total de la reserva.
     */
    public double calcularTotal() {
        int dias = calcularDias();
        return alojamiento.calcularCostoEstadia(dias);
    }

    /**
     * Muestra la información de la reserva en consola.
     */
    public void mostrarInfo() {
        System.out.println("ID Reserva: " + idReserva);
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Alojamiento: " + alojamiento.getNombre());
        System.out.println("Fecha entrada: " + fechaEntrada);
        System.out.println("Fecha salida: " + fechaSalida);
        System.out.println("Días: " + calcularDias());
        System.out.println("Total: $" + totalReserva);
    }

    /**
     * Devuelve la información de la reserva en formato CSV.
     *
     * @return String CSV con los datos de la reserva.
     */
    public String toCSV() {
        return idReserva + "," + cliente.getId() + "," + alojamiento.getCodigo() + "," +
                fechaEntrada + "," + fechaSalida + "," + totalReserva;
    }

    /** @return ID de la reserva */
    public String getIdReserva() { return idReserva; }

    /** @return Cliente que realizó la reserva */
    public Cliente getCliente() { return cliente; }

    /** @return Alojamiento reservado */
    public Alojamiento getAlojamiento() { return alojamiento; }

    /** @return Fecha de entrada de la reserva */
    public LocalDate getFechaEntrada() { return fechaEntrada; }

    /** @return Fecha de salida de la reserva */
    public LocalDate getFechaSalida() { return fechaSalida; }

    /** @return Total de la reserva */
    public double getTotalReserva() { return totalReserva; }
}
