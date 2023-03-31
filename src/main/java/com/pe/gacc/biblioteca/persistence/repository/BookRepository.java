package com.pe.gacc.biblioteca.persistence.repository;

import com.pe.gacc.biblioteca.entity.Book;
import com.pe.gacc.biblioteca.persistence.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
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

}
