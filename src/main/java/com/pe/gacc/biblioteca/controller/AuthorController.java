package com.pe.gacc.biblioteca.controller;

import com.pe.gacc.biblioteca.domain.dto.AuthorDTO;
import com.pe.gacc.biblioteca.domain.dto.request.AuthorDTORequest;
import com.pe.gacc.biblioteca.domain.service.IAuthorService;
import com.pe.gacc.biblioteca.util.constant.BibliotecaConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(BibliotecaConstant.CLIENT_FRONTED)
@RequestMapping(BibliotecaConstant.RESOURCE_GENERIC+BibliotecaConstant.RESOURCE_AUTHORS)
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @GetMapping
    public List<AuthorDTO> findAll(@RequestParam String key_word){
        return authorService.findByKeyWordSQL(key_word);
    }

    @PostMapping
    public AuthorDTO saveSQL(@RequestBody AuthorDTORequest authorDTORequest){
        return authorService.saveSQL(authorDTORequest);
    }
}
