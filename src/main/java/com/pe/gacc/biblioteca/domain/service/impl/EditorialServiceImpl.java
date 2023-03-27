package com.pe.gacc.biblioteca.domain.service.impl;

import com.pe.gacc.biblioteca.domain.dto.AuthorDTO;
import com.pe.gacc.biblioteca.domain.dto.EditorialDTO;
import com.pe.gacc.biblioteca.domain.dto.request.EditorialDTORequest;
import com.pe.gacc.biblioteca.domain.service.IEditorialService;
import com.pe.gacc.biblioteca.entity.Author;
import com.pe.gacc.biblioteca.entity.Editorial;
import com.pe.gacc.biblioteca.persistence.repository.EditorialRepository;
import com.pe.gacc.biblioteca.util.constant.BibliotecaConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EditorialServiceImpl implements IEditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    @Override
    public EditorialDTO save(EditorialDTORequest editorialDTORequest) {
        Editorial editorial = new Editorial();
        editorial.setName(editorialDTORequest.getName());
        editorial.setState(BibliotecaConstant.STATE_ACTIVE);

        Editorial newEditorial = editorialRepository.save(editorial);
        return new EditorialDTO(newEditorial.getId(),newEditorial.getName());
    }

    @Override
    public EditorialDTO update(EditorialDTORequest editorialDTORequest, Long id) {
        Optional<Editorial> bean = editorialRepository.findById(id);

        if (bean.isPresent()){
            Editorial updateEditorial = bean.get();
            updateEditorial.setName(editorialDTORequest.getName());

            Editorial saveEditorial = editorialRepository.save(updateEditorial);

            return new EditorialDTO(saveEditorial.getId(), saveEditorial.getName());
        } else  {
            throw new NotFoundException("Product not found with id " + id);
        }
    }

    @Override
    public EditorialDTO findById(Long id) {
        Optional<Editorial> editorial = editorialRepository.findById(id);
        if (editorial.isPresent()){
            EditorialDTO editorialDto = new EditorialDTO();
            editorialDto.setId(editorial.get().getId());
            editorialDto.setName(editorial.get().getName());
            return editorialDto;
        } else  {
            throw new NotFoundException("Product not found with id " + id);
        }
    }

    @Override
    public List<EditorialDTO> findAll() {
        List<Editorial> editorialList = editorialRepository.findAll();
        List<EditorialDTO> editorialDTOs = new ArrayList<EditorialDTO>();
        editorialList.forEach( (bean) -> {
            EditorialDTO editorialDto = new EditorialDTO();
            editorialDto.setId(bean.getId());
            editorialDto.setName(bean.getName());
            editorialDTOs.add(editorialDto);
        });
        return editorialDTOs;
    }

    @Override
    public Page<EditorialDTO> findByNameLike(String name, Pageable pageable) {
        Page<Editorial> editorialPages = editorialRepository.findByNameLikeAndState("%"+name+"%", BibliotecaConstant.STATE_ACTIVE,pageable);
        return editorialPages
                .map(this::convertBeanToDTO);
    }

    private EditorialDTO convertBeanToDTO(Editorial editorial){
        return EditorialDTO.builder()
                .id(editorial.getId())
                .name(editorial.getName())
                .build();
    }
}
