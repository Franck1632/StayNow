package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private String idReserva;
    private Cliente cliente;
    private Alojamiento alojamiento;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private double totalReserva;

    public Reserva(String idReserva, Cliente cliente, Alojamiento alojamiento,
                    LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.alojamiento = alojamiento;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.totalReserva = calcularTotal();
    }

    public int calcularDias() {
        return (int) ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
    }

    public double calcularTotal() {
        int dias = calcularDias();
        return alojamiento.calcularCostoEstadia(dias);
    }

    public void mostrarInfo() {
        System.out.println("ID Reserva: " + idReserva);
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Alojamiento: " + alojamiento.getNombre());
        System.out.println("Fecha entrada: " + fechaEntrada);
        System.out.println("Fecha salida: " + fechaSalida);
        System.out.println("Días: " + calcularDias());
        System.out.println("Total: $" + totalReserva);
    }

    public String toCSV() {
        return idReserva + "," + cliente.getId() + "," + alojamiento.getCodigo() + "," +
                fechaEntrada + "," + fechaSalida + "," + totalReserva;
    }
    // Getters
    public String getIdReserva() { return idReserva; }
    public Cliente getCliente() { return cliente; }
    public Alojamiento getAlojamiento() { return alojamiento; }
    public LocalDate getFechaEntrada() { return fechaEntrada; }
    public LocalDate getFechaSalida() { return fechaSalida; }
    public double getTotalReserva() { return totalReserva; }
}