package com.pe.gacc.biblioteca.util.mapper;

import com.pe.gacc.biblioteca.domain.dto.SubAreaDTO;
import com.pe.gacc.biblioteca.entity.SubArea;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(builder = @Builder(disableBuilder = true))
public interface SubAreaMapper {

    @Mapping(target = "area.description", source = "area.description")
    @Mapping(target = "area.id", source = "area.id")
    SubAreaDTO toDto(SubArea subArea);


}
