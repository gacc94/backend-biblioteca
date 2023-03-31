package com.pe.gacc.biblioteca.domain.service.impl;

import com.pe.gacc.biblioteca.domain.dto.HrefEntityDTO;
import com.pe.gacc.biblioteca.domain.dto.SubAreaDTO;
import com.pe.gacc.biblioteca.domain.dto.request.SubAreaDTORequest;
import com.pe.gacc.biblioteca.domain.service.ISubAreaService;
import com.pe.gacc.biblioteca.entity.Area;
import com.pe.gacc.biblioteca.entity.SubArea;
import com.pe.gacc.biblioteca.exception.validator.EntityNotFoundException;
import com.pe.gacc.biblioteca.persistence.repository.AreaRepository;
import com.pe.gacc.biblioteca.persistence.repository.SubAreaRepository;
import com.pe.gacc.biblioteca.util.constant.BibliotecaConstant;
import com.pe.gacc.biblioteca.util.constant.BibliotecaResource;
import com.pe.gacc.biblioteca.util.constant.BibliotecaUtil;
import com.pe.gacc.biblioteca.util.mapper.SubAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SubAreaServiceImpl implements ISubAreaService {

    @Autowired
    private SubAreaRepository subAreaRepository;
    @Autowired
    private BibliotecaUtil bibliotecaUtil;
    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private SubAreaMapper subAreaMapper;

    @Override
    public SubAreaDTO findById(Long id) {
        SubArea subArea = this.subAreaRepository.findByIdAndState(id, BibliotecaConstant.STATE_ACTIVE)
                .orElseThrow(()-> new EntityNotFoundException("not found"));
        return this.subAreaMapper.toDto(subArea);
    }

    @Override
    public HrefEntityDTO save(SubAreaDTORequest dto) {
        Area area = this.areaRepository.findByIdAndState(dto.getIdArea(), BibliotecaConstant.STATE_ACTIVE)
                .orElseThrow(()-> new EntityNotFoundException("not found area"));
        SubArea subArea = SubArea.builder()
                .description(dto.getDescription())
                .area(area).build();
        return this.bibliotecaUtil.createHrefFromResource(this.subAreaRepository.save(subArea).getId(), BibliotecaResource.SUBAREA);
    }

    @Override
    public Page<SubAreaDTO> findByDescription(String description, Pageable pageable) {
        Page<SubArea> subareas = this.subAreaRepository.findByDescriptionContainingAndState(description, BibliotecaConstant.STATE_ACTIVE, pageable);
        return subareas.map((subarea)-> this.subAreaMapper.toDto(subarea));
    }

    @Override
    public HrefEntityDTO update(SubAreaDTORequest dto, Long id) {
        Area area = this.areaRepository.findByIdAndState(dto.getIdArea(), BibliotecaConstant.STATE_ACTIVE)
                .orElseThrow(()-> new EntityNotFoundException("not found area"));
        SubArea subArea = this.subAreaRepository.findByIdAndState(id, BibliotecaConstant.STATE_ACTIVE)
                .orElseThrow(()-> new EntityNotFoundException("not found sub-area"));
        subArea.setDescription(dto.getDescription());
        subArea.setArea(area);
        return this.bibliotecaUtil.createHrefFromResource(this.subAreaRepository.save(subArea).getId(), BibliotecaResource.SUBAREA);
    }

    @Override
    public HrefEntityDTO delete(Long id) {
        SubArea subArea = this.subAreaRepository.findByIdAndState(id, BibliotecaConstant.STATE_ACTIVE)
                .orElseThrow(()-> new EntityNotFoundException("not found sub-area"));
        subArea.setDescription(BibliotecaConstant.STATE_DISABLED);
        return this.bibliotecaUtil.createHrefFromResource(this.subAreaRepository.save(subArea).getId(), BibliotecaResource.SUBAREA);
    }
}
