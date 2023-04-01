package com.pe.gacc.biblioteca.persistence.dao;

import com.pe.gacc.biblioteca.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookDao extends JpaRepository<Book, Long> {

    Optional<Book> findByIdAndState(Long id, String state);

    @Query("SELECT eb " +
            "FROM Book eb " +
            "INNER JOIN eb.editorial ee " +
            "INNER JOIN eb.subArea esa " +
            "INNER JOIN esa.area ea " +
            "WHERE eb.state = ?2 and " +
            "LOWER(CONCAT( eb.title,eb.subtitle,eb.isbn,eb.description, eb.yearPublication,ee.name,esa.description,ea.description)) " +
            "LIKE CONCAT('%',?1,'%') ")
    Page<Book> findByKeyWordJPQL(String key_word,String state, Pageable pageable);

}
