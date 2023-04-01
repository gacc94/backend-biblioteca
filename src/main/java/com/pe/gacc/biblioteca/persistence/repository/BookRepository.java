package com.pe.gacc.biblioteca.persistence.repository;

import com.pe.gacc.biblioteca.entity.Book;
import com.pe.gacc.biblioteca.persistence.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BookRepository {

    @Autowired
    private BookDao bookDao;

    public Optional<Book> findByIdAndState(Long id, String state){
        return bookDao.findByIdAndState(id,state);
    }

    public Book save(Book book) {
        return bookDao.save(book);
    }

    public Page<Book> findByKeyWordJPQL(String key_word, String state, Pageable pageable){
        return bookDao.findByKeyWordJPQL(key_word,state,pageable);
    }
}
