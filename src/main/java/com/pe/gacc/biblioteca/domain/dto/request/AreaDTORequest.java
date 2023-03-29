package com.pe.gacc.biblioteca.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AreaDTORequest {

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 10, max = 100)
    private String description;

}
