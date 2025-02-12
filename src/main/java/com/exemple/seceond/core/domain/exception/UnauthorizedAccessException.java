package com.exemple.seceond.core.domain.exception;

public class UnauthorizedAccessException extends RuntimeException {

    /**
     * Constructs an UnauthorizedAccessException with the specified message.
     *
     * @param message The error message.
     */
    public UnauthorizedAccessException(String message) {
        super(message);
    }
}

