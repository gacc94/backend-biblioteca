package com.pe.gacc.biblioteca.controller;

import com.pe.gacc.biblioteca.domain.dto.*;
import com.pe.gacc.biblioteca.domain.dto.request.AreaDTORequest;
import com.pe.gacc.biblioteca.domain.dto.request.BookDTORequest;
import com.pe.gacc.biblioteca.domain.dto.request.EditorialDTORequest;
import com.pe.gacc.biblioteca.domain.service.IBookService;
import com.pe.gacc.biblioteca.domain.service.IEditorialService;
import com.pe.gacc.biblioteca.util.constant.BibliotecaConstant;
import com.pe.gacc.biblioteca.util.constant.BibliotecaUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@CrossOrigin(BibliotecaConstant.CLIENT_FRONTED)
@RequestMapping(BibliotecaConstant.RESOURCE_GENERIC+BibliotecaConstant.RESOURCE_BOOKS)
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private BibliotecaUtil bibliotecaUtil;

    @GetMapping(BibliotecaConstant.RESOURCE_BOOKS_BOOK+BibliotecaConstant.RESOURCE_GENERIC_ID)
    public ResponseEntity<BookDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(bookService.findById(id), HttpStatus.OK);
    }

//    @GetMapping(BibliotecaConstant.RESOURCE_BOOKS_BOOK)
//    public ResponseEntity<Page<AreaDTO>> findByDescription(@RequestParam String description, PageableDTO pageable){
//        log.info("gacc EditorialController -> {}" + pageable.toString());
//        return new ResponseEntity<Page<AreaDTO>>
//                (bookService.findByDescription(description,bibliotecaUtil.getPageable(pageable)),HttpStatus.OK);
//    }

    @PostMapping(BibliotecaConstant.RESOURCE_BOOKS_BOOK)
    public ResponseEntity<HrefEntityDTO> save(@RequestBody @Valid BookDTORequest dto) {
        return new ResponseEntity<HrefEntityDTO>(this.bookService.save(dto), HttpStatus.CREATED);
    }

    @PutMapping(BibliotecaConstant.RESOURCE_BOOKS_BOOK+BibliotecaConstant.RESOURCE_GENERIC_ID)
    public ResponseEntity<HrefEntityDTO> update(@RequestBody @Valid BookDTORequest bookDTORequest,@PathVariable Long id){
        return new ResponseEntity<HrefEntityDTO>(bookService.update(bookDTORequest, id), HttpStatus.OK);
    }

    @DeleteMapping(BibliotecaConstant.RESOURCE_BOOKS_BOOK + BibliotecaConstant.RESOURCE_GENERIC_ID)
    public ResponseEntity<HrefEntityDTO> delete(@PathVariable Long id) {
        return new ResponseEntity<HrefEntityDTO>(bookService.delete(id), HttpStatus.OK);
    }
}
