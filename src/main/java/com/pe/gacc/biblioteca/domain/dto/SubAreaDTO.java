package com.pe.gacc.biblioteca.domain.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubAreaDTO {
    private Long id;
    private String description;
    private AreaDTO area;
}