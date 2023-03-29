package com.pe.gacc.biblioteca.domain.service;

import com.pe.gacc.biblioteca.domain.dto.AreaDTO;
import com.pe.gacc.biblioteca.domain.dto.HrefEntityDTO;
import com.pe.gacc.biblioteca.domain.dto.request.AreaDTORequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAreaService {

    HrefEntityDTO save(AreaDTORequest areaDTORequest);
    HrefEntityDTO update(AreaDTORequest areaDTORequest, Long id);
    HrefEntityDTO delete(Long id);
    Page<AreaDTO> findByDescription(String description, Pageable pageable);
    AreaDTO findById(Long id);
}
