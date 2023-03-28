package com.pe.gacc.biblioteca.util.mapper;

import com.pe.gacc.biblioteca.domain.dto.EditorialDTO;
import com.pe.gacc.biblioteca.entity.Editorial;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true))
public interface EditorialMapper {

    EditorialDTO toDTO(Editorial editorial);
}