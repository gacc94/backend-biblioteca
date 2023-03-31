package com.pe.gacc.biblioteca.persistence.repository;

import com.pe.gacc.biblioteca.entity.SubArea;
import com.pe.gacc.biblioteca.persistence.dao.SubAreaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SubAreaRepository {

    @Autowired
    private SubAreaDao subAreaDao;

    public Optional<SubArea> findByIdAndState(Long id, String state){
        return subAreaDao.findByIdAndState(id,state);
    }

    public Page<SubArea> findByDescriptionContainingAndState(String description, String state, Pageable pageable){
        return subAreaDao.findByDescriptionContainingAndState(description, state, pageable);
    }

    public SubArea save(SubArea subArea){
        return subAreaDao.save(subArea);
    }
}
