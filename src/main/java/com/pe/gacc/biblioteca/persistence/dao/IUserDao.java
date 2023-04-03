package com.pe.gacc.biblioteca.persistence.dao;

import com.pe.gacc.biblioteca.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface IUserDao extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);

}
