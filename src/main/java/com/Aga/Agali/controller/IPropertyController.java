package com.Aga.Agali.controller;

import com.Aga.Agali.dto.PropertyCreateDTO;
import com.Aga.Agali.dto.PropertyResponseDTO;

import java.util.List;

public interface IPropertyController {
    PropertyResponseDTO save(PropertyCreateDTO dto);


    PropertyResponseDTO getById(Long id);


    List<PropertyResponseDTO> getAll();


    PropertyResponseDTO update(Long id, PropertyCreateDTO dto);


    void delete(Long id);
}
