package com.pe.gacc.biblioteca.util.mapper;

import com.pe.gacc.biblioteca.domain.dto.BookDTO;
import com.pe.gacc.biblioteca.entity.Book;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true))
public interface BookMapper {

    BookDTO toDTO(Book book);
    Book toBean(BookDTO bookDTO);

}
