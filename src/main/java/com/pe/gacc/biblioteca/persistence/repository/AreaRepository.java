package com.pe.gacc.biblioteca.persistence.repository;

import com.pe.gacc.biblioteca.entity.Area;
import com.pe.gacc.biblioteca.persistence.dao.AreaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AreaRepository {

    @Autowired
    private AreaDao areaDao;

    public Page<Area> findByDescriptionContainingAndState(String description, String state, Pageable pageable){
        return areaDao.findByDescriptionContainingAndState(description, state, pageable);
    }

    public Optional<Area> findByIdAndState(Long id, String state){
        return areaDao.findByIdAndState(id,state);
    }

    public Area save(Area area){
        return areaDao.save(area);
    }
}
