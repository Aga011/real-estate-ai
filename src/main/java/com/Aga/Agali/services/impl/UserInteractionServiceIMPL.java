package com.Aga.Agali.services.impl;

import com.Aga.Agali.dto.UserInteractionCreateDTO;
import com.Aga.Agali.dto.UserInteractionResponseDTO;
import com.Aga.Agali.entity.Property;
import com.Aga.Agali.entity.User;
import com.Aga.Agali.entity.UserInteraction;
import com.Aga.Agali.repository.IPropertyRepository;
import com.Aga.Agali.repository.IUserInteractionRepository;
import com.Aga.Agali.repository.IUserRepository;
import com.Aga.Agali.services.IUserInteractionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
@Service
public class UserInteractionServiceIMPL implements IUserInteractionService {
    @Autowired
    private IUserInteractionRepository userInteractionRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IPropertyRepository propertyRepository;

    @Override
    public UserInteractionResponseDTO create(UserInteractionCreateDTO dto) {
        UserInteraction interaction=new UserInteraction();
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Property property = propertyRepository.findById(dto.getPropertyId())
                .orElseThrow(() -> new RuntimeException("Property not found"));

        interaction.setUser(user);
        interaction.setProperty(property);
        interaction.setCreateAt(LocalDateTime.now());
        interaction.setDurationSeconds(dto.getDurationSeconds());

        UserInteraction userInteraction=userInteractionRepository.save(interaction);
        UserInteractionResponseDTO responseDTO=new UserInteractionResponseDTO();
        BeanUtils.copyProperties(interaction,responseDTO);
        responseDTO.setUserId(userInteraction.getUser().getId());
        responseDTO.setPropertyId(userInteraction.getProperty().getId());
        return responseDTO;
    }

    @Override
    public UserInteractionResponseDTO getById(Long id) {
        UserInteraction interaction = userInteractionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interaction not found"));

        UserInteractionResponseDTO dto = new UserInteractionResponseDTO();
        BeanUtils.copyProperties(interaction, dto);

        dto.setUserId(interaction.getUser().getId());
        dto.setPropertyId(interaction.getProperty().getId());

        return dto;
    }

    @Override
    public List<UserInteractionResponseDTO> getAll() {
        return userInteractionRepository.findAll().stream().map(interaction -> {
            UserInteractionResponseDTO dto = new UserInteractionResponseDTO();
            BeanUtils.copyProperties(interaction, dto);
            dto.setUserId(interaction.getUser().getId());
            dto.setPropertyId(interaction.getProperty().getId());
            return dto;
        }).toList();
    }

    @Override
    public List<UserInteractionResponseDTO> getByUserId(Long userId) {
        List<UserInteraction> list = userInteractionRepository.findByUserId(userId);

        return list.stream().map(interaction -> {
            UserInteractionResponseDTO dto = new UserInteractionResponseDTO();
            BeanUtils.copyProperties(interaction, dto);
            dto.setUserId(interaction.getUser().getId());
            dto.setPropertyId(interaction.getProperty().getId());
            return dto;
        }).toList();
    }

    @Override
    public List<UserInteractionResponseDTO> getByPropertyId(Long propertyId) {
        List<UserInteraction> list = userInteractionRepository.findByPropertyId(propertyId);

        return list.stream().map(interaction -> {
            UserInteractionResponseDTO dto = new UserInteractionResponseDTO();
            BeanUtils.copyProperties(interaction, dto);
            dto.setUserId(interaction.getUser().getId());
            dto.setPropertyId(interaction.getProperty().getId());
            return dto;
        }).toList();
    }

    @Override
    public void delete(Long id) {
        if (!userInteractionRepository.existsById(id)) {
            throw new RuntimeException("Interaction not found");
        }
        userInteractionRepository.deleteById(id);

    }
}
