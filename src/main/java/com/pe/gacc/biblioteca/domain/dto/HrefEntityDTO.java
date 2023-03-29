package com.pe.gacc.biblioteca.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HrefEntityDTO {

    private Object id;
    private String href;

}
