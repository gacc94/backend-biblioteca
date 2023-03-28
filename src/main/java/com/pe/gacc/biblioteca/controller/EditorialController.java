package com.pe.gacc.biblioteca.controller;

import com.pe.gacc.biblioteca.domain.dto.EditorialDTO;
import com.pe.gacc.biblioteca.domain.dto.PageableDTO;
import com.pe.gacc.biblioteca.domain.dto.request.EditorialDTORequest;
import com.pe.gacc.biblioteca.domain.service.IEditorialService;
import com.pe.gacc.biblioteca.util.constant.BibliotecaConstant;
import com.pe.gacc.biblioteca.util.constant.BibliotecaUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(BibliotecaConstant.CLIENT_FRONTED)
@RequestMapping(BibliotecaConstant.RESOURCE_GENERIC+BibliotecaConstant.RESOURCE_EDITORIALS)
public class EditorialController {

    @Autowired
    private IEditorialService editorialService;
    @Autowired
    private BibliotecaUtil bibliotecaUtil;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(editorialService.findAll());
    }

    @GetMapping(BibliotecaConstant.RESOURCE_GENERIC_ID)
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(editorialService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody EditorialDTORequest editorialDTO){
//        Long editorialDTORequest1 = editorialService.save(editorialDTORequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(editorialService.save(editorialDTO));

//        return new ResponseEntity<>
//                (editorialService.save(editorialDTORequest), HttpStatus.CREATED);
    }

    @PutMapping(BibliotecaConstant.RESOURCE_GENERIC_ID)
    public ResponseEntity<?> update(@RequestBody EditorialDTORequest editorialDTORequest,@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(editorialService.update(editorialDTORequest, id));
    }

    @GetMapping(BibliotecaConstant.RESOURCE_EDITORIALS_EDITORIAL)
    public Page<EditorialDTO> findByName(@RequestParam String name, PageableDTO pageable){
        log.info("gacc EditorialController -> {}" + pageable.toString());
        return editorialService.findByNameLike(name, bibliotecaUtil.getPageable(pageable));
    }

}
