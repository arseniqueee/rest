package rest.exception;

public class DocsDataNotFoundException extends RuntimeException {

    public DocsDataNotFoundException() {
    }

    public DocsDataNotFoundException(String message) {
        super(message);
    }

    public DocsDataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
