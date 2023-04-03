package com.pe.gacc.biblioteca.persistence.dao;

import com.pe.gacc.biblioteca.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactDao  extends JpaRepository<Contact,Long> {
}
