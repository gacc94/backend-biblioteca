package com.pe.gacc.biblioteca.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AuthorDTO implements Serializable {

    private Long id;
    private String authorName;

}
