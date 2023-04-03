package com.pe.gacc.biblioteca.security;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class AuthCredentials {
    private String email;
    private String password;
}
