package com.bamanga.meCash.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto
{
    public Long userId;
    private Long id;
    private Double balance;
    private String currency;
}
