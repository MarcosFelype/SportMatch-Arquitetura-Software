package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequestDto{
    @NotBlank(message = "O email é obrigatório.")
    String email;
    @NotBlank(message = "A senha é obrigatória.")
    String senha;
}