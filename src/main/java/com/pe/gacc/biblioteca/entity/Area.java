package com.pe.gacc.biblioteca.entity;

import com.pe.gacc.biblioteca.util.constant.BibliotecaConstant;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@Entity
@Table(name = BibliotecaConstant.TAB_NAME_AREA, schema = BibliotecaConstant.SCHEMA_NAME_DBO)
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Area implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idarea", nullable = false)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "state", insertable = false)
    private String state;

}
