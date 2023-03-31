package com.pe.gacc.biblioteca.domain.dto.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubAreaDTORequest {

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 100)
    private String description;

    @NotNull
    private Long idArea;

}
