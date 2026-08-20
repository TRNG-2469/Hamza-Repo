package com.rev.sp.boot.sp.exceptions;
public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(int id) {
        super("Account with id " + id + " not found.");
    }
}
