package view;
import controller.Controlador;
import model.exceptions.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class App {
    private static Controlador controlador;
    private static Scanner scanner;
    public static void main(String[] args) {
        controlador = new Controlador();
        scanner = new Scanner(System.in);
        System.out.println("=== SISTEMA DE GESTIÓN STAYNOW ===");
        mostrarMenuPrincipal();
    }

    private static void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar alojamiento");
            System.out.println("3. Crear reserva");
            System.out.println("4. Mostrar reservas");
            System.out.println("5. Registrar pago");
            System.out.println("6. Exportar datos CSV");
            System.out.println("7. Mostrar todos los datos");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch(opcion) {
                case 1: registrarCliente(); break;
                case 2: registrarAlojamiento(); break;
                case 3: crearReserva(); break;
                case 4: controlador.mostrarReservas(); break;
                case 5: registrarPago(); break;
                case 6: controlador.guardarDatosCSV(); break;
                case 7: mostrarTodosDatos(); break;
                case 8:
                    controlador.guardarDatosCSV();
                    System.out.println("¡Hasta pronto! Datos guardados.");
                    break;
                default: System.out.println("Opción no válida");
            }
        } while(opcion != 8);
    }

    private static void registrarCliente() {
        System.out.println("\n=== REGISTRAR CLIENTE ===");
        System.out.print("ID del cliente: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        if (controlador.registrarCliente(id, nombre, email)) {
            System.out.println("Cliente registrado exitosamente!");
        } else {
            System.out.println("Error: El cliente ya existe");
        }
    }

    private static void registrarAlojamiento() {
        System.out.println("\n=== REGISTRAR ALOJAMIENTO ===");
        System.out.println("1. Hotel");
        System.out.println("2. Apartamento");
        System.out.println("3. Cabaña");
        System.out.print("Seleccione tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ubicación: ");
        String ubicacion = scanner.nextLine();
        System.out.print("Precio por noche: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        switch(tipo) {
            case 1: // Hotel
                System.out.print("Estrellas: ");
                int estrellas = scanner.nextInt();
                System.out.print("¿Incluye desayuno? (true/false): ");
                boolean desayuno = scanner.nextBoolean();
                controlador.registrarHotel(codigo, nombre, ubicacion, precio, estrellas, desayuno);
                break;
            case 2: // Apartamento
                System.out.print("Número de habitaciones: ");
                int habitaciones = scanner.nextInt();
                System.out.print("¿Tiene parqueadero? (true/false): ");
                boolean parqueadero = scanner.nextBoolean();
                controlador.registrarApartamento(codigo, nombre, ubicacion, precio, habitaciones, parqueadero);
                break;
            case 3: // Cabaña
                System.out.print("Zona: ");
                String zona = scanner.nextLine();
                System.out.print("Capacidad de personas: ");
                int capacidad = scanner.nextInt();
                controlador.registrarCabana(codigo, nombre, ubicacion, precio, zona, capacidad);
                break;
        }
        System.out.println("Alojamiento registrado exitosamente!");
    }

    private static void crearReserva() {
        System.out.println("\n=== CREAR RESERVA ===");
        try {
            System.out.print("ID de la reserva: ");
            String idReserva = scanner.nextLine();
            System.out.print("ID del cliente: ");
            String idCliente = scanner.nextLine();
            System.out.print("Código del alojamiento: ");
            String codigoAlojamiento = scanner.nextLine();
            System.out.print("Fecha de entrada (YYYY-MM-DD): ");
            LocalDate fechaEntrada = LocalDate.parse(scanner.nextLine());
            System.out.print("Fecha de salida (YYYY-MM-DD): ");
            LocalDate fechaSalida = LocalDate.parse(scanner.nextLine());
            controlador.crearReserva(idReserva, idCliente, codigoAlojamiento, fechaEntrada, fechaSalida);
            System.out.println("Reserva creada exitosamente!");
        } catch (FechaInvalidaException e) {
            System.out.println("Error en fechas: " + e.getMessage());
        } catch (ClienteNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (AlojamientoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("Error: Formato de fecha inválido. Use YYYY-MM-DD");
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
    private static void registrarPago() {
        System.out.println("\n=== REGISTRAR PAGO ===");
        System.out.print("ID del pago: ");
        String idPago = scanner.nextLine();
        System.out.print("Monto: ");
        double monto = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Método de pago: ");
        String metodo = scanner.nextLine();
        if (controlador.registrarPago(idPago, monto, metodo)) {
            System.out.println("Pago registrado exitosamente!");
        }
    }

    private static void mostrarTodosDatos() {
        controlador.mostrarClientes();
        controlador.mostrarAlojamientos();
        controlador.mostrarReservas();
    }
}