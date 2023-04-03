package com.pe.gacc.biblioteca.controller;

import com.pe.gacc.biblioteca.entity.Contact;
import com.pe.gacc.biblioteca.persistence.dao.IContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contacts")
public class ContactController {

    @Autowired
    private IContactDao contactRepository;

    @GetMapping
    public List<Contact> findAll(){
        return contactRepository.findAll();
    }
}
