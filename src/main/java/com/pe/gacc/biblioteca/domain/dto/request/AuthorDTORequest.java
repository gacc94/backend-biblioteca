package com.pe.gacc.biblioteca.domain.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTORequest implements Serializable {

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 10, max = 60)
    private String name;
    @NotNull
    @NotEmpty
    @NotBlank
    private String lastName;
}
