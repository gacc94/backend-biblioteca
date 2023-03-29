package com.pe.gacc.biblioteca.controller;

import com.pe.gacc.biblioteca.domain.dto.AreaDTO;
import com.pe.gacc.biblioteca.domain.dto.HrefEntityDTO;
import com.pe.gacc.biblioteca.domain.dto.PageableDTO;
import com.pe.gacc.biblioteca.domain.dto.request.AreaDTORequest;
import com.pe.gacc.biblioteca.domain.service.IAreaService;
import com.pe.gacc.biblioteca.util.constant.BibliotecaConstant;
import com.pe.gacc.biblioteca.util.constant.BibliotecaUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Slf4j
@RestController
@CrossOrigin(BibliotecaConstant.CLIENT_FRONTED)
@RequestMapping(BibliotecaConstant.RESOURCE_GENERIC+BibliotecaConstant.RESOURCE_AREAS)
public class AreaController {

    @Autowired
    private IAreaService areaService;
    @Autowired
    private BibliotecaUtil bibliotecaUtil;

    @GetMapping(BibliotecaConstant.RESOURCE_AREAS_AREA+BibliotecaConstant.RESOURCE_GENERIC_ID)
    public ResponseEntity<AreaDTO> findById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(areaService.findById(id));
    }

    @GetMapping(BibliotecaConstant.RESOURCE_AREAS_AREA)
    public ResponseEntity<Page<AreaDTO>> findByDescription(@RequestParam String description, PageableDTO pageable){
        log.info("gacc EditorialController -> {}" + pageable.toString());
        return new ResponseEntity<Page<AreaDTO>>
                (areaService.findByDescription(description,bibliotecaUtil.getPageable(pageable)),HttpStatus.OK);
    }

    @PostMapping(BibliotecaConstant.RESOURCE_AREAS_AREA)
    public ResponseEntity<HrefEntityDTO> save(@RequestBody @Valid AreaDTORequest areaDTORequest){
        return new ResponseEntity<HrefEntityDTO>(areaService.save(areaDTORequest), HttpStatus.CREATED);
    }

    @PutMapping(BibliotecaConstant.RESOURCE_AREAS_AREA+BibliotecaConstant.RESOURCE_GENERIC_ID)
    public ResponseEntity<HrefEntityDTO> update(@RequestBody @Valid AreaDTORequest areaDTORequest){
        return new ResponseEntity<HrefEntityDTO>(areaService.save(areaDTORequest), HttpStatus.OK);
    }

    @DeleteMapping(BibliotecaConstant.RESOURCE_AREAS_AREA + BibliotecaConstant.RESOURCE_GENERIC_ID)
    public ResponseEntity<HrefEntityDTO> delete(@PathVariable Long id) {
        return new ResponseEntity<HrefEntityDTO>(this.areaService.delete(id), HttpStatus.OK);
    }
}
