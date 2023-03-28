package com.pe.gacc.biblioteca.entity;

import com.pe.gacc.biblioteca.util.constant.BibliotecaConstant;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = BibliotecaConstant.TAB_NAME_EDITORIAL, schema = BibliotecaConstant.SCHEMA_NAME_DBO)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Editorial{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ideditorial")
    private Long id;
    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "state", length = 1)
    private String state;
}
