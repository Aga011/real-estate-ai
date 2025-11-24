package com.Aga.Agali.controller;

import com.Aga.Agali.dto.UserInteractionCreateDTO;
import com.Aga.Agali.dto.UserInteractionResponseDTO;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Validated
public interface IUserInteractionController {
    UserInteractionResponseDTO create(@Valid UserInteractionCreateDTO dto);


    UserInteractionResponseDTO getById(Long id);


    List<UserInteractionResponseDTO> getAll();


    List<UserInteractionResponseDTO> getByUserId(Long userId);


    List<UserInteractionResponseDTO> getByPropertyId(Long propertyId);


    void delete(Long id);
}
