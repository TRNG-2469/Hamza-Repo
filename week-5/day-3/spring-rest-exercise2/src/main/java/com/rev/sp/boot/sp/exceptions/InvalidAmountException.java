package com.rev.sp.boot.sp.exceptions;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(double amount) {
        super("Amount must be greater than 0. Provided: " + amount + ".");
    }
}
