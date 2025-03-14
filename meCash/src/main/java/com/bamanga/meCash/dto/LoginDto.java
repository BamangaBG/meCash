package com.bamanga.meCash.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDto
{
    private String user;
    private String password;
}
