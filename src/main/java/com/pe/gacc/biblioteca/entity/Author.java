package com.pe.gacc.biblioteca.entity;

import com.pe.gacc.biblioteca.util.constant.BibliotecaConstant;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = BibliotecaConstant.TAB_NAME_AUTHOR, schema = BibliotecaConstant.SCHEMA_NAME_DBO)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idauthor")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "state")
    private String state;

}
