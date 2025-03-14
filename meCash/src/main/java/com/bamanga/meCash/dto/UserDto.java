package com.bamanga.meCash.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto
{
    private Long id;

    @NotBlank
    private String accountHolderName;
    @Email
    private String email;
    @Size(min = 6, max = 16)
    private String password;
}
