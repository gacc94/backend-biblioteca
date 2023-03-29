package com.pe.gacc.biblioteca.persistence.repository;

import com.pe.gacc.biblioteca.entity.Author;
import com.pe.gacc.biblioteca.persistence.dao.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepository {

    @Autowired
    private AuthorDao authorDao;

    public List<Author> findByKeyWordSQL(String key_word, String state){
        return authorDao.findByKeyWordSQL(key_word, state);
    }

    public Author saveSQL(String name, String lastName){
        return authorDao.saveSQL(name, lastName);
    }

}
