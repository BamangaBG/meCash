package com.bamanga.meCash.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TransactionDto
{
    private Long transactionId;
    private Double amount;
    private String transactionType;
    private LocalDateTime timestamp;
}
