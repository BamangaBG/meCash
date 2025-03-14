package com.bamanga.meCash.service;

import com.bamanga.meCash.dto.AccountDto;
import com.bamanga.meCash.dto.TransactionDto;
import com.bamanga.meCash.dto.TransferDto;
import com.bamanga.meCash.dto.UserDto;
import com.bamanga.meCash.entity.Account;
import com.bamanga.meCash.entity.Transaction;
import com.bamanga.meCash.entity.User;
import com.bamanga.meCash.repository.AccountRepository;
import com.bamanga.meCash.repository.TransactionRepository;
import com.bamanga.meCash.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService
{
    private UserRepository userRepository;
    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    public AccountService(UserRepository userRepository, TransactionRepository transactionRepository, AccountRepository accountRepository)
    {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }



    public Account createAccount(AccountDto accountDto)
    {
        User user = userRepository.findById(accountDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not Found"));
        Account account = new Account();
        account.setUser(user);
        account.setBalance(0.0);
        account.setCurrency(accountDto.getCurrency());
        return accountRepository.save(account);
    }

    public Account deposit(Long accountId, Double amount)
    {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found."));
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

    public Account withdraw(Long accountId, Double amount)
    {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found."));
        if (account.getBalance() < amount)
        {
            throw new RuntimeException("Insufficient funds.");
        }
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }

    public Double getBalance(Long accountId)
    {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found."));
        return account.getBalance();
    }

    public List<Transaction> getTransactionHistory(Long accountId)
    {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found."));
        return transactionRepository.findByAccount(account);
    }

}
