package com.pe.gacc.biblioteca.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_editorial", schema = "dbo")
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
