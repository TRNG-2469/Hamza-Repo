package com.rev.sp.boot.sp.service;

import com.rev.sp.boot.sp.exceptions.AccountNotFoundException;
import com.rev.sp.boot.sp.exceptions.InsufficientBalanceException;
import com.rev.sp.boot.sp.exceptions.InvalidAmountException;
import com.rev.sp.boot.sp.model.Account;
import com.rev.sp.boot.sp.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(@PathVariable int id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    public Account createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(@PathVariable int id, @RequestBody Account updatedAccount) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
        existingAccount.setAccountNumber(updatedAccount.getAccountNumber());
        existingAccount.setCustomerName(updatedAccount.getCustomerName());
        existingAccount.setCustomerEmail(updatedAccount.getCustomerEmail());
        existingAccount.setAccountType(updatedAccount.getAccountType());
        existingAccount.setBranch(updatedAccount.getBranch());
        existingAccount.setBalance(updatedAccount.getBalance());
        return accountRepository.save(existingAccount);
    }

    public String deleteAccount(@PathVariable int id) {
        if (!accountRepository.existsById(id)) {
            throw new AccountNotFoundException(id);
        }
        accountRepository.deleteById(id);
        return "Account deleted successfully";
    }

    public Account getAccountByAccountNumber(@PathVariable String accountNumber) {
        return accountRepository.getAccountByAccountNumber(accountNumber);
    }

    public List<Account> getAccountsByCustomerName(@RequestParam String customerName) {
        return accountRepository.getAccountsByCustomerNameIgnoreCase(customerName);
    }

    public List<Account> getAccountsByBranch(@RequestParam String branch) {
        return accountRepository.getAccountsByBranchIgnoreCase(branch);
    }

    public List<Account> getAccountsByAccountType(@RequestParam String accountType) {
        return accountRepository.getAccountsByAccountTypeIgnoreCase(accountType);
    }

    public List<Account> getAccountsByBalanceRange(@RequestParam double minBalance, @RequestParam double maxBalance) {
        return accountRepository.getAccountsByBalanceRange(minBalance, maxBalance);
    }

    public Account deposit(@PathVariable int id, @RequestParam double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException(amount);
        }
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

    public Account withdraw(@PathVariable int id, @RequestParam double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException(amount);
        }
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
        if (account.getBalance() < amount) {
            throw new InsufficientBalanceException(account.getBalance(), amount);
        }
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }

}
