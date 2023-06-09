package com.pe.gacc.biblioteca.persistence.repository;

import com.pe.gacc.biblioteca.entity.Editorial;
import com.pe.gacc.biblioteca.persistence.dao.EditorialDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Editorial> findByNameLikeAndState(String name, String state, Pageable pageable){
        return editorialDao.findByNameLikeAndState(name,state,pageable);
    }

    public Optional<Editorial> findByIdAndState(Long id, String state){
        return editorialDao.findByIdAndState(id, state);
    }

    public Boolean existByIdSQL(Long id) {
        return editorialDao.existByIdSQL(id);
    }

    public Editorial findByIdJPQL(Long id){
        return editorialDao.findByIdJPQL(id);
    }

    public List<Editorial> findByNameContainingOrderByIdAsc(String name){
        return editorialDao.findByNameContainingOrderByIdAsc(name);
    }
}
