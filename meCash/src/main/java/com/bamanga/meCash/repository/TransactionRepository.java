package com.bamanga.meCash.repository;

import com.bamanga.meCash.entity.Account;
import com.bamanga.meCash.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long>
{
    Optional<Transaction> findById(Long id);

    Page<Transaction> findByAccountId(Long accountId, Pageable pageable);

    List<Transaction> findByAccount(Account account);
}
