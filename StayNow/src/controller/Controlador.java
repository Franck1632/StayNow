package controller;
import model.*;
import model.exceptions.*;
import controller.loader.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controlador {
    private ArrayList<Cliente> clientes;
    private ArrayList<Alojamiento> alojamientos;
    private ArrayList<Reserva> reservas;
    private ArrayList<Pago> pagos;

    public Controlador() {
        this.clientes = new ArrayList<>();
        this.alojamientos = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.pagos = new ArrayList<>();
        cargarDatosCSV();
    }
    // Métodos para Clientes
    public boolean registrarCliente(String id, String nombre, String email) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                return false;
            }
        }
        clientes.add(new Cliente(id, nombre, email));
        return true;
    }

    public Cliente buscarCliente(String id) throws ClienteNoEncontradoException {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        throw new ClienteNoEncontradoException(id);
    }

    // Métodos para Alojamientos
    public void registrarHotel(String codigo, String nombre, String ubicacion,
                                double precio, int estrellas, boolean desayuno) {
        alojamientos.add(new Hotel(codigo, nombre, ubicacion, precio, estrellas, desayuno));
    }

    public void registrarApartamento(String codigo, String nombre, String ubicacion,
                                    double precio, int habitaciones, boolean parqueadero) {
        alojamientos.add(new Apartamento(codigo, nombre, ubicacion, precio, habitaciones, parqueadero));
    }

    public void registrarCabana(String codigo, String nombre, String ubicacion,
                                double precio, String zona, int capacidad) {
        alojamientos.add(new Cabana(codigo, nombre, ubicacion, precio, zona, capacidad));
    }

    public boolean registrarPago(String idPago, double monto, String metodo) {
        pagos.add(new Pago(idPago, monto, metodo));
        return true;
    }

    public Alojamiento buscarAlojamiento(String codigo) throws AlojamientoNoEncontradoException {
        for (Alojamiento a : alojamientos) {
            if (a.getCodigo().equals(codigo)) {
                return a;
            }
        }
        throw new AlojamientoNoEncontradoException(codigo);
    }
    // Métodos para Reservas
    public boolean crearReserva(String idReserva, String idCliente, String codigoAlojamiento,
                                LocalDate fechaEntrada, LocalDate fechaSalida)
                                throws FechaInvalidaException, ClienteNoEncontradoException,
                                    AlojamientoNoEncontradoException {
        // Validar fechas
        if (fechaSalida.isBefore(fechaEntrada)) {
            throw new FechaInvalidaException("La fecha de salida no puede ser anterior a la fecha de entrada");
        }
        if (fechaEntrada.isBefore(LocalDate.now())) {
            throw new FechaInvalidaException("La fecha de entrada no puede ser en el pasado");
        }
        Cliente cliente = buscarCliente(idCliente);
        Alojamiento alojamiento = buscarAlojamiento(codigoAlojamiento);
        Reserva reserva = new Reserva(idReserva, cliente, alojamiento, fechaEntrada, fechaSalida);
        reservas.add(reserva);
        return true;
    }
    // Métodos para mostrar información (sin cambios)
    public void mostrarClientes() {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        for (Cliente c : clientes) {
            c.mostrarInfo();
            System.out.println("-------------------");
        }
    }

    public void mostrarAlojamientos() {
        System.out.println("\n=== LISTA DE ALOJAMIENTOS ===");
        for (Alojamiento a : alojamientos) {
            a.mostrarInfo();
            System.out.println("-------------------");
        }
    }

    public void mostrarReservas() {
        System.out.println("\n=== LISTA DE RESERVAS ===");
        for (Reserva r : reservas) {
            r.mostrarInfo();
            System.out.println("-------------------");
        }
    }

    // Métodos para CSV usando Loaders
    public void guardarDatosCSV() {
        ClienteLoader.guardarClientes("resources/clientes.csv", clientes);
        AlojamientoLoader.guardarAlojamientos("resources/alojamientos.csv", alojamientos);
        ReservaLoader.guardarReservas("resources/reservas.csv", reservas);
        System.out.println("Datos guardados en archivos CSV");
    }

    private void cargarDatosCSV() {
        try {
            this.clientes = ClienteLoader.cargarClientes("resources/clientes.csv");
            System.out.println("Clientes cargados: " + clientes.size());
        } catch (ArchivoNoEncontradoException e) {
            System.out.println(e.getMessage() + " - Se creará uno nuevo");
        }
        try {
            this.alojamientos = AlojamientoLoader.cargarAlojamientos("resources/alojamientos.csv");
            System.out.println("Alojamientos cargados: " + alojamientos.size());
        } catch (ArchivoNoEncontradoException e) {
            System.out.println(e.getMessage() + " - Se creará uno nuevo");
        }
        try {
            this.reservas = ReservaLoader.cargarReservas("resources/reservas.csv", clientes, alojamientos);
            System.out.println("Reservas cargadas: " + reservas.size());
        } catch (ArchivoNoEncontradoException e) {
            System.out.println(e.getMessage() + " - Se creará uno nuevo");
        }
    }
    // Getters para las listas
    public ArrayList<Cliente> getClientes() { return clientes; }
    public ArrayList<Alojamiento> getAlojamientos() { return alojamientos; }
    public ArrayList<Reserva> getReservas() { return reservas; }
    public ArrayList<Pago> getPagos() { return pagos; }
}