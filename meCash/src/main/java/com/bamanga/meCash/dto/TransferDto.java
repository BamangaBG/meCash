package com.bamanga.meCash.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransferDto
{
    private Double amount;
    private Long toAccountId;
}
