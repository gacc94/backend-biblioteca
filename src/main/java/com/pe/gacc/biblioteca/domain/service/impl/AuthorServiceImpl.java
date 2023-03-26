package com.pe.gacc.biblioteca.domain.service.impl;

import com.pe.gacc.biblioteca.domain.dto.AuthorDTO;
import com.pe.gacc.biblioteca.domain.dto.request.AuthorDTORequest;
import com.pe.gacc.biblioteca.domain.service.IAuthorService;
import com.pe.gacc.biblioteca.entity.Author;
import com.pe.gacc.biblioteca.persistence.repository.AuthorRepository;
import com.pe.gacc.biblioteca.util.constant.BibliotecaConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<AuthorDTO> findByKeyWordSQL(String key_word) {
        List<Author> list = authorRepository.findByKeyWordSQL(key_word, BibliotecaConstant.STATE_ACTIVE);

        return list.stream()
                .map(this::convertBeanToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDTO saveSQL(AuthorDTORequest authorDTORequest) {
        return convertBeanToDTO(authorRepository.saveSQL(authorDTORequest.getName(), authorDTORequest.getLastName()));
    }

    public AuthorDTO convertBeanToDTO(Author author){
        return AuthorDTO.builder()
                .id(author.getId())
                .authorName(author.getName() + " " + author.getLastName())
                .build();
    }

}
