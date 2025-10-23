package model.exceptions;

public class ArchivoNoEncontradoException extends Exception {
    public ArchivoNoEncontradoException(String nombreArchivo) {
        super("Archivo '" + nombreArchivo + "' no encontrado");
    }

    public ArchivoNoEncontradoException(String nombreArchivo, Throwable causa) {
        super("Archivo '" + nombreArchivo + "' no encontrado", causa);
    }
}