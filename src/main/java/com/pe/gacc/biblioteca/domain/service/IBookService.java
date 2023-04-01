package com.pe.gacc.biblioteca.domain.service;

import com.pe.gacc.biblioteca.domain.dto.BookDTO;
import com.pe.gacc.biblioteca.domain.dto.HrefEntityDTO;
import com.pe.gacc.biblioteca.domain.dto.request.BookDTORequest;
import com.pe.gacc.biblioteca.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {

    HrefEntityDTO save(BookDTORequest bookDTORequest);
    HrefEntityDTO update(BookDTORequest bookDTORequest, Long id);
    HrefEntityDTO delete(Long id);
    BookDTO findById(Long id);
    Page<BookDTO> findByKeyWordJPQL(String key_word, Pageable pageable);
}
