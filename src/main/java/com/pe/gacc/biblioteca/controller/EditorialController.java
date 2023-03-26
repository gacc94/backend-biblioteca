package com.pe.gacc.biblioteca.controller;

import com.pe.gacc.biblioteca.domain.dto.request.EditorialDTORequest;
import com.pe.gacc.biblioteca.domain.service.IEditorialService;
import com.pe.gacc.biblioteca.util.constant.BibliotecaConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(BibliotecaConstant.CLIENT_FRONTED)
@RequestMapping(BibliotecaConstant.RESOURCE_GENERIC+BibliotecaConstant.RESOURCE_EDITORIALS)
public class EditorialController {

    @Autowired
    private IEditorialService editorialService;

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

}
