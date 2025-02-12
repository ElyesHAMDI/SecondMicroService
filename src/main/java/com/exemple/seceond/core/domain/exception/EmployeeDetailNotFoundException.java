package com.exemple.seceond.core.domain.exception;

public class EmployeeDetailNotFoundException extends RuntimeException {
    public EmployeeDetailNotFoundException(Long id) {
        super("Could not find employee " + id);
    }

}


