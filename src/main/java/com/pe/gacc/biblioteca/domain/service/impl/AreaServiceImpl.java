package com.pe.gacc.biblioteca.domain.service.impl;

import com.pe.gacc.biblioteca.domain.dto.AreaDTO;
import com.pe.gacc.biblioteca.domain.dto.HrefEntityDTO;
import com.pe.gacc.biblioteca.domain.dto.request.AreaDTORequest;
import com.pe.gacc.biblioteca.domain.service.IAreaService;
import com.pe.gacc.biblioteca.entity.Area;
import com.pe.gacc.biblioteca.persistence.repository.AreaRepository;
import com.pe.gacc.biblioteca.util.constant.BibliotecaConstant;
import com.pe.gacc.biblioteca.util.constant.BibliotecaResource;
import com.pe.gacc.biblioteca.util.constant.BibliotecaUtil;
import com.pe.gacc.biblioteca.util.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class AreaServiceImpl implements IAreaService {

    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private BibliotecaUtil bibliotecaUtil;
    @Autowired
    private AreaMapper areaMapper;

    @Override
    public HrefEntityDTO save(AreaDTORequest areaDTORequest) {
        Area area = areaRepository.save(areaMapper.toBean(areaDTORequest));
        return bibliotecaUtil.createHrefFromResource(area.getId(), BibliotecaResource.AREA);
    }

    @Override
    public HrefEntityDTO update(AreaDTORequest areaDTORequest, Long id) {
        Area area = areaRepository.findByIdAndState(id, BibliotecaConstant.STATE_ACTIVE)
                .orElseThrow(()->new EntityNotFoundException( "not Found"));
        area.setDescription(areaDTORequest.getDescription());
        return bibliotecaUtil.createHrefFromResource(areaRepository.save(area).getId(), BibliotecaResource.AREA);
    }

    @Override
    public HrefEntityDTO delete(Long id) {
        Area area = areaRepository.findByIdAndState(id, BibliotecaConstant.STATE_ACTIVE)
                .orElseThrow(()->new EntityNotFoundException( "not Found"));
        area.setState(BibliotecaConstant.STATE_DISABLED);
        return bibliotecaUtil.createHrefFromResource(areaRepository.save(area).getId(), BibliotecaResource.AREA);

    }

    @Override
    public Page<AreaDTO> findByDescription(String description, Pageable pageable) {
        Page<Area> areas = areaRepository.findByDescriptionContainingAndState(description,BibliotecaConstant.STATE_ACTIVE,pageable);
        return areas.map((bean)->areaMapper.toDTO(bean));

    }

    @Override
    public AreaDTO findById(Long id) {
        Area area = areaRepository.findByIdAndState(id, BibliotecaConstant.STATE_ACTIVE)
                .orElseThrow(()-> new EntityNotFoundException("not found"));
        return areaMapper.toDTO(area);
    }
}
