package com.codewithmosh.store.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "Email is required.")
    @Email
    private final String email;

    @NotBlank(message = "Password is required.")
    private final String password;
}