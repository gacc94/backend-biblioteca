package com.pe.gacc.biblioteca.entity;

import com.pe.gacc.biblioteca.util.constant.BibliotecaConstant;
import lombok.*;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = BibliotecaConstant.TAB_NAME_BOOK, schema = BibliotecaConstant.SCHEMA_NAME_DBO)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbook")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "subtitle")
    private String subtitle;
    @Column(name = "description")
    private String description;
    @Column(name = "numberpage")
    private String numberPage;
    @Column(name = "yearpublication")
    private String yearPublication;
    @Column(name = "state",insertable = false)
    private String state;

    @ManyToOne
    @JoinColumn(name = "ideditorial")
    private Editorial editorial;

    @ManyToOne
    @JoinColumn(name = "idsubarea")
    private SubArea subArea;

}
