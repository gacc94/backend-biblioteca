package com.pe.gacc.biblioteca.persistence.dao;

import com.pe.gacc.biblioteca.entity.Area;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AreaDao extends JpaRepository<Area,Long> {

    Page<Area> findByDescriptionContainingAndState(String description, String state, Pageable pageable);
    Optional<Area> findByIdAndState(Long id, String state);

}
