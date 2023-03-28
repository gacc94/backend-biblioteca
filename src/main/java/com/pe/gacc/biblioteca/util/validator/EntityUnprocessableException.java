package com.pe.gacc.biblioteca.util.validator;

public class EntityUnprocessableException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public EntityUnprocessableException() {
        super();
    }

    public EntityUnprocessableException(String message) {
        super(message);
    }

    public EntityUnprocessableException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityUnprocessableException(Throwable cause) {
        super(cause);
    }

    protected EntityUnprocessableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
