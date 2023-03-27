package com.pe.gacc.biblioteca.persistence.dao;

import com.pe.gacc.biblioteca.entity.Editorial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EditorialDao extends JpaRepository<Editorial,Long> {

    Page<Editorial> findByNameLikeAndState(String name, String state, Pageable pageable);

}
