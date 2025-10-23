package model.exceptions;

public class AlojamientoNoEncontradoException extends Exception {
    public AlojamientoNoEncontradoException(String codigoAlojamiento) {
        super("Alojamiento con código '" + codigoAlojamiento + "' no encontrado");
    }
}