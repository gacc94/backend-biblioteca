package com.pe.gacc.biblioteca.persistence.dao;

import com.pe.gacc.biblioteca.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookDao extends JpaRepository<Book, Long> {

    Optional<Book> findByIdAndState(Long id, String state);

}
