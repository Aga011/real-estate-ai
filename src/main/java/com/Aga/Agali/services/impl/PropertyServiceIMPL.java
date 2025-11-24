package com.Aga.Agali.services.impl;

import com.Aga.Agali.dto.PropertyCreateDTO;
import com.Aga.Agali.dto.PropertyResponseDTO;
import com.Aga.Agali.dto.RecommendationResponseDTO;
import com.Aga.Agali.dto.UserInteractionResponseDTO;
import com.Aga.Agali.entity.Property;
import com.Aga.Agali.entity.Recommendation;
import com.Aga.Agali.repository.IPropertyRepository;
import com.Aga.Agali.services.IPropertyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PropertyServiceIMPL implements IPropertyService {
    @Autowired
    private IPropertyRepository propertyRepository;

    @Override
    public PropertyResponseDTO save(PropertyCreateDTO dto) {
        Property property = new Property();
        BeanUtils.copyProperties(dto, property);
        Property saved = propertyRepository.save(property);
        PropertyResponseDTO dbProperty = new PropertyResponseDTO();
        BeanUtils.copyProperties(saved, dbProperty);
        return dbProperty;
    }

    @Override
    public PropertyResponseDTO getById(Long id) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        PropertyResponseDTO responseDTO = new PropertyResponseDTO();
        BeanUtils.copyProperties(property, responseDTO);
        if (property.getInteractions() != null) {
            responseDTO.setInteractions(
                    property.getInteractions().stream().map(userInteraction -> {
                        UserInteractionResponseDTO iuDTO = new UserInteractionResponseDTO();
                        BeanUtils.copyProperties(userInteraction, iuDTO);
                        return iuDTO;
                    }).toList()
            );

        }
        if (property.getRecommendations() != null) {
            responseDTO.setRecommendations(
                    property.getRecommendations().stream().map(recommendation -> {
                        RecommendationResponseDTO rcDTO = new RecommendationResponseDTO();
                        BeanUtils.copyProperties(recommendation, rcDTO);
                        return rcDTO;
                    }).toList()
            );
        }
        return responseDTO;
    }

    @Override
    public List<PropertyResponseDTO> getAll() {
        List<Property> properties = propertyRepository.findAll();
        List<PropertyResponseDTO> responseList = new ArrayList<>();
        for (Property property : properties) {
            PropertyResponseDTO dto = new PropertyResponseDTO();
            BeanUtils.copyProperties(property, dto);
            responseList.add(dto);
        }
        return responseList;
    }


    @Override
    public PropertyResponseDTO update(Long id, PropertyCreateDTO dto) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));
        if (dto.getTitle() != null) property.setTitle(dto.getTitle());
        if (dto.getDescription() != null) property.setDescription(dto.getDescription());
        if (dto.getPrice() != null) property.setPrice(dto.getPrice());
        if (dto.getType() != null) property.setType(dto.getType());
        Property dbProperty = propertyRepository.save(property);
        PropertyResponseDTO responseDTO = new PropertyResponseDTO();
        BeanUtils.copyProperties(dbProperty, responseDTO);
        return responseDTO;
    }

    @Override
    public void delete(Long id) {
        if (!propertyRepository.existsById(id)) {
            throw new RuntimeException("Property not found");
        }
        propertyRepository.deleteById(id);
    }
}