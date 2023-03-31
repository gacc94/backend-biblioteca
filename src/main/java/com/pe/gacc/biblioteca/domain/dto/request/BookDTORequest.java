package com.pe.gacc.biblioteca.domain.dto.request;

import com.pe.gacc.biblioteca.domain.dto.EditorialDTO;
import com.pe.gacc.biblioteca.domain.dto.SubAreaDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTORequest {

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String subtitle;
    private String isbn;
    private String description;
    private String numberPage;
    private String yearPublication;

    @NotNull
    private Long idEditorial;

    @NotNull
    private Long idSubArea;

}
