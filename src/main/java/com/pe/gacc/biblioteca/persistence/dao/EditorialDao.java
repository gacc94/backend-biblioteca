package com.pe.gacc.biblioteca.persistence.dao;

import com.pe.gacc.biblioteca.entity.Editorial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface EditorialDao extends JpaRepository<Editorial,Long> {

    Page<Editorial> findByNameLikeAndState(String name, String state, Pageable pageable);
    // =============================================================================================
    // PRIMERA FORMA .- POR NOMBRE DE METODO
    // =============================================================================================
    List<Editorial> findByNameContainingOrderByIdAsc(String name);

    // =============================================================================================
    // SEGUNDA FORMA .- MEDIANTE JPQL
    // =============================================================================================
    @Query("select e from Editorial e where id =?1")
    Editorial findByIdJPQL(Long id);

    // =============================================================================================
    // TERCERA FORMA .- MEDIANTE INSTRUCCION SQL
    // =============================================================================================
    @Query(value = "select count(*)>0 from dbo.t_editorial where ideditorial =?1", nativeQuery = true)
    Boolean existByIdSQL(Long id);

    Optional<Editorial> findByIdAndState(Long id, String state);

}
