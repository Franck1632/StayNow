package model.exceptions;

/**
 * Excepción que se lanza cuando se proporciona una fecha inválida
 * en el sistema, como fechas de reserva incorrectas o fuera de rango.
 * 
 * @author Franckarlos Barbosa
 * @version 1.0
 */
public class FechaInvalidaException extends Exception {

    /**
     * Crea una nueva excepción con un mensaje específico.
     *
     * @param mensaje Mensaje describiendo la fecha inválida.
     */
    public FechaInvalidaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Crea una nueva excepción con un mensaje específico
     * y una causa original que provocó el error.
     *
     * @param mensaje Mensaje describiendo la fecha inválida.
     * @param causa   Excepción original que provocó este error.
     */
    public FechaInvalidaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
