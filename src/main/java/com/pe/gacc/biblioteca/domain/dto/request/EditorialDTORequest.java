package com.pe.gacc.biblioteca.domain.dto.request;

//import javax.;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditorialDTORequest {
    // LOS ATRIBUTOS NO SEAN NULOS.
    @NotNull

    // LOS ATRIBUTOS NO SEAN BACIOS.
    @NotEmpty

    // LOS ATRIBUTOS NOS SEAN NULAS NI BACIOS.
    @NotBlank

    //VALIDA LA LONGITUD MINIMA Y MAXIMA DE UNA CADENA
    @Size(min = 10,max = 100)
    private String name;
}
