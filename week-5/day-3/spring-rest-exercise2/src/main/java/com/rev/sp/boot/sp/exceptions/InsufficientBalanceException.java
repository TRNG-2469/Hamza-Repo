package com.rev.sp.boot.sp.exceptions;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(double balance, double amount) {
        super("Insufficient balance. Available: " + balance + ", requested: " + amount + ".");
    }
}
