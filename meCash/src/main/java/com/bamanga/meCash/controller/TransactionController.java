package com.bamanga.meCash.controller;

import com.bamanga.meCash.dto.TransactionDto;
import com.bamanga.meCash.dto.TransferDto;
import com.bamanga.meCash.service.AccountService;
import com.bamanga.meCash.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestParam Long fromAccountId,
                                           @RequestParam Long toAccountId,
                                           @RequestParam Double amount)
    {
        transactionService.transfer(fromAccountId, toAccountId, amount);
        return ResponseEntity.ok("Transfer successful!");
    }


}
