package Exceptions;

/**
 * @author Julia Merta
 * @version %I%, %G%
 */
public class SchoolSystemException extends Exception {
    public SchoolSystemException() {
        super();
    }

    public SchoolSystemException(String message) {
        super(message);
    }

    public SchoolSystemException(Throwable cause) {
        super(cause);
    }
}
