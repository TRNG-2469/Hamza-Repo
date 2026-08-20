package com.rev.sp.boot.sp.repository;
import com.rev.sp.boot.sp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account getAccountByAccountNumber(String accountNumber);
    List<Account> getAccountsByCustomerNameIgnoreCase(String customerName);
    List<Account> getAccountsByBranchIgnoreCase(String branch);
    List<Account> getAccountsByAccountTypeIgnoreCase(@RequestParam String accountType);
    @Query("SELECT a FROM Account a WHERE a.balance >= :minBalance AND a.balance <= :maxBalance")
    List<Account> getAccountsByBalanceRange(double minBalance, double maxBalance);
}
