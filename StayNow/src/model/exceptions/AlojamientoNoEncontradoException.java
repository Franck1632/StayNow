package model.exceptions;

/**
 * Excepción que se lanza cuando no se encuentra un alojamiento
 * con el código especificado en el sistema.
 * 
 * @author Franckarlos Barbosa
 * @version 1.0
 */
public class AlojamientoNoEncontradoException extends Exception {

    /**
     * Crea una nueva excepción con un mensaje indicando
     * el código del alojamiento no encontrado.
     *
     * @param codigoAlojamiento Código del alojamiento que no fue encontrado.
     */
    public AlojamientoNoEncontradoException(String codigoAlojamiento) {
        super("Alojamiento con código '" + codigoAlojamiento + "' no encontrado");
    }
}
