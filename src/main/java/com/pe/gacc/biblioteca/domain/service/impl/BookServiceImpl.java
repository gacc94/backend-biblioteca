package com.pe.gacc.biblioteca.domain.service.impl;

import com.pe.gacc.biblioteca.domain.dto.BookDTO;
import com.pe.gacc.biblioteca.domain.dto.HrefEntityDTO;
import com.pe.gacc.biblioteca.domain.dto.request.BookDTORequest;
import com.pe.gacc.biblioteca.domain.service.IBookService;
import com.pe.gacc.biblioteca.entity.Book;
import com.pe.gacc.biblioteca.entity.Editorial;
import com.pe.gacc.biblioteca.entity.SubArea;
import com.pe.gacc.biblioteca.exception.validator.EntityNotFoundException;
import com.pe.gacc.biblioteca.persistence.repository.BookRepository;
import com.pe.gacc.biblioteca.persistence.repository.EditorialRepository;
import com.pe.gacc.biblioteca.persistence.repository.SubAreaRepository;
import com.pe.gacc.biblioteca.util.constant.BibliotecaConstant;
import com.pe.gacc.biblioteca.util.constant.BibliotecaResource;
import com.pe.gacc.biblioteca.util.constant.BibliotecaUtil;
import com.pe.gacc.biblioteca.util.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BibliotecaUtil bibliotecaUtil;
    @Autowired
    private EditorialRepository editorialRepository;
    @Autowired
    private SubAreaRepository subAreaRepository;

    @Override
    public HrefEntityDTO save(BookDTORequest dto) {
        Editorial editorial = this.editorialRepository.findByIdAndState(dto.getIdEditorial(), BibliotecaConstant.STATE_ACTIVE)
                .orElseThrow(()-> new EntityNotFoundException("not found editorial"));
        SubArea subArea = this.subAreaRepository.findByIdAndState(dto.getIdEditorial(), BibliotecaConstant.STATE_ACTIVE)
                .orElseThrow(()-> new EntityNotFoundException("not found subarea"));
        Book book = Book.builder()
                .title(dto.getTitle())
                .subtitle(dto.getSubtitle())
                .isbn(dto.getIsbn())
                .description(dto.getDescription())
                .numberPage(dto.getNumberPage())
                .yearPublication(dto.getYearPublication())
                .editorial(editorial)
                .subArea(subArea).build();
        return bibliotecaUtil.createHrefFromResource(this.bookRepository.save(book).getId(), BibliotecaResource.BOOK);
    }

    @Override
    public HrefEntityDTO update(BookDTORequest dto, Long id) {
        Editorial editorial = this.editorialRepository.findByIdAndState(dto.getIdEditorial(), BibliotecaConstant.STATE_ACTIVE)
                .orElseThrow(()-> new EntityNotFoundException("not found editorial"));
        SubArea subArea = this.subAreaRepository.findByIdAndState(dto.getIdSubArea(), BibliotecaConstant.STATE_ACTIVE)
                .orElseThrow(()-> new EntityNotFoundException("not found subarea"));
        Book book = this.bookRepository.findByIdAndState(id, BibliotecaConstant.STATE_ACTIVE)
                .orElseThrow(()-> new EntityNotFoundException("not found book"));
        book.setTitle(dto.getTitle());
        book.setSubtitle(dto.getSubtitle());
        book.setDescription(dto.getDescription());
        book.setNumberPage(dto.getNumberPage());
        book.setYearPublication(dto.getYearPublication());
        book.setEditorial(editorial);
        book.setSubArea(subArea);
        return bibliotecaUtil.createHrefFromResource(this.bookRepository.save(book).getId(), BibliotecaResource.BOOK);
    }

    @Override
    public HrefEntityDTO delete(Long id) {
        Book book = bookRepository.findByIdAndState(id, BibliotecaConstant.STATE_ACTIVE)
                .orElseThrow(()->new EntityNotFoundException("not found book"));
        book.setState(BibliotecaConstant.STATE_DISABLED);
        return bibliotecaUtil.createHrefFromResource(bookRepository.save(book).getId(), BibliotecaResource.BOOK);
    }

    @Override
    public BookDTO findById(Long id) {
        Book book = bookRepository.findByIdAndState(id, BibliotecaConstant.STATE_ACTIVE)
                .orElseThrow(()->new EntityNotFoundException("not found book"));
        return bookMapper.toDTO(book);
    }
}
