package com.example.FE019W_beadando.exception;

public class BadPizzaFormatException extends Exception {

    public BadPizzaFormatException() {
    }

    public BadPizzaFormatException(String message) {
        super(message);
    }

    public BadPizzaFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadPizzaFormatException(Throwable cause) {
        super(cause);
    }

    public BadPizzaFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
