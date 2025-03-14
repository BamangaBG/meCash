package com.bamanga.meCash.controller;

import com.bamanga.meCash.dto.AccountDto;
import com.bamanga.meCash.entity.Account;
import com.bamanga.meCash.entity.Transaction;
import com.bamanga.meCash.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController
{
    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody @Valid AccountDto accountDto)
    {
        Account account = accountService.createAccount(accountDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @PostMapping("/{accountId}/deposit")
    public ResponseEntity<Account> deposit(@PathVariable Long accountId, @RequestParam Double amount)
    {
        Account account = accountService.deposit(accountId, amount);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/{accountId}/withdraw")
    public ResponseEntity<Account> withdraw(@PathVariable Long accountId, @RequestParam Double amount)
    {
        Account account = accountService.withdraw(accountId, amount);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/{accountId}/balance")
    public ResponseEntity<Double> getBalance(@PathVariable Long accountId)
    {
        Double balance = accountService.getBalance(accountId);
        return ResponseEntity.ok(balance);
    }

    @GetMapping("/{accountId}/transactions")
    public ResponseEntity<List<Transaction>> getTransactionHistory(@PathVariable Long accountId)
    {
        List<Transaction> transactions = accountService.getTransactionHistory(accountId);
        return ResponseEntity.ok(transactions);
    }

}