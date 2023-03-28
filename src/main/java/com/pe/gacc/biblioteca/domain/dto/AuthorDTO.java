package com.pe.gacc.biblioteca.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO implements Serializable{

    private Long id;
    private String authorName;
}
