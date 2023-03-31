package com.pe.gacc.biblioteca.domain.service;

import com.pe.gacc.biblioteca.domain.dto.BookDTO;
import com.pe.gacc.biblioteca.domain.dto.HrefEntityDTO;
import com.pe.gacc.biblioteca.domain.dto.request.BookDTORequest;

public interface IBookService {

    HrefEntityDTO save(BookDTORequest bookDTORequest);
    HrefEntityDTO update(BookDTORequest bookDTORequest, Long id);
    HrefEntityDTO delete(Long id);
    BookDTO findById(Long id);

}
