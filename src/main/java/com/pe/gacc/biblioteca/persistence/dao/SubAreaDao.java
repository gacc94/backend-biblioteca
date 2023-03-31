package com.pe.gacc.biblioteca.persistence.dao;

import com.pe.gacc.biblioteca.entity.SubArea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubAreaDao extends JpaRepository<SubArea, Long> {

    Optional<SubArea> findByIdAndState(Long id, String state);
    Page<SubArea> findByDescriptionContainingAndState(String description, String state, Pageable pageable);

}
