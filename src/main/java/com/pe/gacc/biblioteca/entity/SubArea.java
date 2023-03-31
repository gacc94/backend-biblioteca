package com.pe.gacc.biblioteca.entity;

import com.pe.gacc.biblioteca.util.constant.BibliotecaConstant;
import lombok.*;

import javax.persistence.*;

@Data
@ToString
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = BibliotecaConstant.TAB_NAME_SUB_AREA, schema = BibliotecaConstant.SCHEMA_NAME_DBO)
public class SubArea {

    @Id
    @Column(name = "idsubarea")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "state", insertable = false)
    private String state;

    @ManyToOne
    @JoinColumn(name = "idarea")
    private Area area;

}
