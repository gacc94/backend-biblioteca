package com.pe.gacc.biblioteca.persistence.dao;

import com.pe.gacc.biblioteca.entity.Author;
import com.pe.gacc.biblioteca.util.constant.BibliotecaConstant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorDao extends JpaRepository<Author, Long> {

    @Query(
            nativeQuery = true,
            value = BibliotecaConstant.SP_SEARCH_AUTHOR,
            countQuery = BibliotecaConstant.SP_SEARCH_AUTHOR_COUNT
    )
    List<Author> findByKeyWordSQL(String key_word, String state);

    @Query(
            nativeQuery = true,
            value = BibliotecaConstant.SP_SAVE_AUTHOR,
            countQuery = BibliotecaConstant.SP_SEARCH_AUTHOR_COUNT
    )
    Author saveSQL(String name, String lastName);
}
