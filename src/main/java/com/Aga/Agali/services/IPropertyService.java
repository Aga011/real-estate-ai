package com.Aga.Agali.services;

import com.Aga.Agali.dto.PropertyCreateDTO;
import com.Aga.Agali.dto.PropertyResponseDTO;

import java.util.List;

public interface IPropertyService {
    PropertyResponseDTO save(PropertyCreateDTO dto);


    PropertyResponseDTO getById(Long id);


    List<PropertyResponseDTO> getAll();


    PropertyResponseDTO update(Long id, PropertyCreateDTO dto);


    void delete(Long id);
}
