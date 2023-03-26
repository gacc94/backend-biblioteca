package com.pe.gacc.biblioteca.persistence.repository;

import com.pe.gacc.biblioteca.entity.Editorial;
import com.pe.gacc.biblioteca.persistence.dao.EditorialDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EditorialRepository {

    @Autowired
    private EditorialDao editorialDao;

    public Editorial save(Editorial editorial) {
        return editorialDao.save(editorial);
    }

    public Editorial update(Editorial editorial) {
        return editorialDao.save(editorial);
    }

    public Optional<Editorial> findById(Long id) {
        return editorialDao.findById(id);
    }

    public List<Editorial> findAll() {
        return editorialDao.findAll();
    }
}
