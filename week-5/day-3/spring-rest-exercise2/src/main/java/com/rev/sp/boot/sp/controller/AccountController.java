package com.rev.sp.boot.sp.controller;

import com.rev.sp.boot.sp.model.Account;
import com.rev.sp.boot.sp.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAccounts(
            @RequestParam(required = false) String customerName,
            @RequestParam(required = false) String branch,
            @RequestParam(required = false) String accountType,
            @RequestParam(required = false) Double minBalance,
            @RequestParam(required = false) Double maxBalance) {
        if (customerName != null) {
            return ResponseEntity.ok(accountService.getAccountsByCustomerName(customerName));
        }
        if (branch != null) {
            return ResponseEntity.ok(accountService.getAccountsByBranch(branch));
        }
        if (accountType != null) {
            return ResponseEntity.ok(accountService.getAccountsByAccountType(accountType));
        }
        if (minBalance != null && maxBalance != null) {
            return ResponseEntity.ok(accountService.getAccountsByBalanceRange(minBalance, maxBalance));
        }
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable int id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.status(201).body(createdAccount);
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable int id, @Valid @RequestBody Account updatedAccount) {
        Account account = accountService.updateAccount(id, updatedAccount);
        return ResponseEntity.ok(account);
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable int id) {
        String result = accountService.deleteAccount(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/accounts/number/{accountNumber}")
    public ResponseEntity<Account> getAccountByAccountNumber(@PathVariable String accountNumber) {
        Account account = accountService.getAccountByAccountNumber(accountNumber);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/accounts/{id}/deposit")
    public ResponseEntity<Account> deposit(@PathVariable int id, @RequestParam double amount) {
        Account account = accountService.deposit(id, amount);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/accounts/{id}/withdraw")
    public ResponseEntity<Account> withdraw(@PathVariable int id, @RequestParam double amount) {
        Account account = accountService.withdraw(id, amount);
        return ResponseEntity.ok(account);
    }

}
