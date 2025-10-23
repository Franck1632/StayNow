package model.exceptions;

/**
 * Excepción que se lanza cuando no se encuentra un cliente
 * con el ID especificado en el sistema.
 * 
 * @author Franckarlos Barbosa
 * @version 1.0
 */
public class ClienteNoEncontradoException extends Exception {

    /**
     * Crea una nueva excepción indicando el ID del cliente no encontrado.
     *
     * @param idCliente ID del cliente que no fue encontrado.
     */
    public ClienteNoEncontradoException(String idCliente) {
        super("Cliente con ID '" + idCliente + "' no encontrado");
    }
}
