package com.pe.gacc.biblioteca.util.mapper;

import com.pe.gacc.biblioteca.domain.dto.AreaDTO;
import com.pe.gacc.biblioteca.domain.dto.request.AreaDTORequest;
import com.pe.gacc.biblioteca.entity.Area;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(builder = @Builder(disableBuilder = true))
public interface AreaMapper {

//    @Mapping(target = "state", source = "")
//    @Mapping(target = "id", source = "")
    Area toBean(AreaDTORequest areaDTORequest);

    AreaDTO toDTO(Area area);



}
