package com.rev.sp.boot.sp.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(int id) {
        super("Employee with id " + id + " not found.");
    }
}