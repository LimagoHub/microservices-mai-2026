package com.example.demo.domain.service;



public class AlreadyExistException extends RuntimeException {

    public AlreadyExistException() {
    }

    public AlreadyExistException(final String message) {
        super(message);
    }

    public AlreadyExistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public AlreadyExistException(final Throwable cause) {
        super(cause);
    }

    public AlreadyExistException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
