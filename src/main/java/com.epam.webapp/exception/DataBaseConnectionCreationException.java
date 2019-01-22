package com.epam.webapp.exception;

public class DataBaseConnectionCreationException extends RuntimeException {
    public DataBaseConnectionCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
