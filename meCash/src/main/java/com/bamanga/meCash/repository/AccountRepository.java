package com.bamanga.meCash.repository;

import com.bamanga.meCash.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long>
{
    Optional<Account> findById(Long id);
}
