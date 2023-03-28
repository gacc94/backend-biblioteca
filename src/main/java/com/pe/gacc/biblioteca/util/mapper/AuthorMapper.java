package com.pe.gacc.biblioteca.util.mapper;

import com.pe.gacc.biblioteca.domain.dto.AuthorDTO;
import com.pe.gacc.biblioteca.entity.Author;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(builder = @Builder(disableBuilder = true))
public interface AuthorMapper {

    @Mapping(target = "authorName",expression = "java(author.getName().concat(\" \").concat(author.getLastName()))")
    AuthorDTO toDTO(Author author);
}
