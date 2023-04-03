package com.pe.gacc.biblioteca.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "t_contact", schema = "auth")
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcontact")
    private Long id;
    private String name;
    private LocalDate Birthday;
    private String phone;
    private String email;
    private String state;
}
