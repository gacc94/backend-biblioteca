package com.pe.gacc.biblioteca.domain.service;

import com.pe.gacc.biblioteca.domain.dto.EditorialDTO;
import com.pe.gacc.biblioteca.domain.dto.request.EditorialDTORequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEditorialService {

    EditorialDTO save(EditorialDTORequest editorialDTORequest);
    EditorialDTO update(EditorialDTORequest editorialDTO, Long id);
    EditorialDTO findById(Long id);
    List<EditorialDTO> findAll();

    Page<EditorialDTO> findByNameLike(String name, Pageable pageable);
}
