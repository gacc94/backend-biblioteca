package com.pe.gacc.biblioteca.domain.service;

import com.pe.gacc.biblioteca.domain.dto.EditorialDTO;
import com.pe.gacc.biblioteca.domain.dto.request.EditorialDTORequest;

import java.util.List;

public interface IEditorialService {

    public EditorialDTO save(EditorialDTORequest editorialDTORequest);
    public EditorialDTO update(EditorialDTORequest editorialDTO, Long id);
    public EditorialDTO findById(Long id);
    public List<EditorialDTO> findAll();

}
