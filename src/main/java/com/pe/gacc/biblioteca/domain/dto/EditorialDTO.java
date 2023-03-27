package com.pe.gacc.biblioteca.domain.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class EditorialDTO implements Serializable {

    private Long id;
    private String name;

//    private String state;
}
