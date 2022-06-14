package com.example.FE019W_beadando.exception;

public class BadCustomerFormatException extends Exception {

    public BadCustomerFormatException() {
    }

    public BadCustomerFormatException(String message) {
        super(message);
    }

    public BadCustomerFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadCustomerFormatException(Throwable cause) {
        super(cause);
    }

    public BadCustomerFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
