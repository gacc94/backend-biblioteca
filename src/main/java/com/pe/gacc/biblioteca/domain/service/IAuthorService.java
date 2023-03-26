package com.pe.gacc.biblioteca.domain.service;

import com.pe.gacc.biblioteca.domain.dto.AuthorDTO;
import com.pe.gacc.biblioteca.domain.dto.request.AuthorDTORequest;
import lombok.Builder;
import lombok.Data;

import java.util.List;

public interface IAuthorService {

    List<AuthorDTO> findByKeyWordSQL(String key_word);
    AuthorDTO saveSQL(AuthorDTORequest authorDTORequest);
}
