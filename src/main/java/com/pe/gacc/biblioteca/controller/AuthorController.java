package com.pe.gacc.biblioteca.controller;

import com.pe.gacc.biblioteca.domain.dto.AuthorDTO;
import com.pe.gacc.biblioteca.domain.dto.request.AuthorDTORequest;
import com.pe.gacc.biblioteca.domain.service.IAuthorService;
import com.pe.gacc.biblioteca.util.constant.BibliotecaConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(BibliotecaConstant.CLIENT_FRONTED)
@RequestMapping(BibliotecaConstant.RESOURCE_GENERIC+BibliotecaConstant.RESOURCE_AUTHORS)
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> findAll(@RequestParam String key_word){
        return new ResponseEntity<>
                (authorService.findByKeyWordSQL(key_word), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> saveSQL(@RequestBody @Valid AuthorDTORequest authorDTORequest){
        return new ResponseEntity<>
                (authorService.saveSQL(authorDTORequest),HttpStatus.CREATED);
    }

}
