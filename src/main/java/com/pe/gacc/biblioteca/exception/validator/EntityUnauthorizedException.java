package com.pe.gacc.biblioteca.exception.validator;

public class EntityUnauthorizedException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public EntityUnauthorizedException() {
        super();
    }

    public EntityUnauthorizedException(String message) {
        super(message);
    }

    public EntityUnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityUnauthorizedException(Throwable cause) {
        super(cause);
    }

    protected EntityUnauthorizedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
