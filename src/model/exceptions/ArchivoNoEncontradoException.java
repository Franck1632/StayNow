package model.exceptions;

/**
 * Excepción que se lanza cuando no se encuentra un archivo
 * especificado en el sistema.
 * 
 * @author Franckarlos Barbosa
 * @version 1.0
 */
public class ArchivoNoEncontradoException extends Exception {

    /**
     * Crea una nueva excepción indicando el archivo no encontrado.
     *
     * @param nombreArchivo Nombre del archivo que no se encontró.
     */
    public ArchivoNoEncontradoException(String nombreArchivo) {
        super("Archivo '" + nombreArchivo + "' no encontrado");
    }

    /**
     * Crea una nueva excepción indicando el archivo no encontrado
     * y la causa original de la excepción.
     *
     * @param nombreArchivo Nombre del archivo que no se encontró.
     * @param causa         Excepción original que provocó este error.
     */
    public ArchivoNoEncontradoException(String nombreArchivo, Throwable causa) {
        super("Archivo '" + nombreArchivo + "' no encontrado", causa);
    }
}
