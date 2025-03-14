package com.bamanga.meCash.service;

import com.bamanga.meCash.entity.Account;
import com.bamanga.meCash.entity.Transaction;
import com.bamanga.meCash.repository.AccountRepository;
import com.bamanga.meCash.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService
{
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public void transfer(Long fromAccountId, Long toAccountId, Double amount)
    {
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new RuntimeException("Sender account not found."));
        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new RuntimeException("Recipient account not found."));

        if (fromAccount.getBalance() < amount)
        {
            throw new RuntimeException("Insufficient funds.");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        // Record the transaction
        Transaction fromTransaction = new Transaction();
        fromTransaction.setUserAccountId(fromAccountId);
        fromTransaction.setAmount(-amount);
        fromTransaction.setTransactionType("TRANSFER_OUT");

        Transaction toTransaction = new Transaction();
        toTransaction.setUserAccountId(fromAccountId);
        toTransaction.setAmount(amount);
        toTransaction.setTransactionType("TRANSFER_IN");

        transactionRepository.save(fromTransaction);
        transactionRepository.save(toTransaction);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }


}

