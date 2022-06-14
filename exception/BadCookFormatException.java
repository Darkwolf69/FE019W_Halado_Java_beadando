package com.example.FE019W_beadando.exception;

public class BadCookFormatException extends Exception {

    public BadCookFormatException() {
    }

    public BadCookFormatException(String message) {
        super(message);
    }

    public BadCookFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadCookFormatException(Throwable cause) {
        super(cause);
    }

    public BadCookFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
