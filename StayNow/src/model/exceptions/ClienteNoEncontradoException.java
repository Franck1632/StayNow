package model.exceptions;

public class ClienteNoEncontradoException extends Exception {
    public ClienteNoEncontradoException(String idCliente) {
        super("Cliente con ID '" + idCliente + "' no encontrado");
    }
}