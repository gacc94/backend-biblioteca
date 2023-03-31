package com.pe.gacc.biblioteca.domain.service;

import com.pe.gacc.biblioteca.domain.dto.HrefEntityDTO;
import com.pe.gacc.biblioteca.domain.dto.SubAreaDTO;
import com.pe.gacc.biblioteca.domain.dto.request.SubAreaDTORequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISubAreaService {

    SubAreaDTO findById(Long id);
    HrefEntityDTO save(SubAreaDTORequest dto);
    HrefEntityDTO update(SubAreaDTORequest dto,Long id);
    HrefEntityDTO delete(Long id);
    Page<SubAreaDTO> findByDescription(String description, Pageable pageable);

}
