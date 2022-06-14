package com.example.FE019W_beadando.exception;

public class BadCourierFormatException extends Exception {

    public BadCourierFormatException() {
    }

    public BadCourierFormatException(String message) {
        super(message);
    }

    public BadCourierFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadCourierFormatException(Throwable cause) {
        super(cause);
    }

    public BadCourierFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
