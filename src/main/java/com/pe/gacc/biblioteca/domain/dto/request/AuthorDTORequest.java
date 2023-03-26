package com.pe.gacc.biblioteca.domain.dto.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AuthorDTORequest implements Serializable {

    private String name;
    private String lastName;
}
