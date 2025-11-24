package com.Aga.Agali.services;

import com.Aga.Agali.dto.UserInteractionCreateDTO;
import com.Aga.Agali.dto.UserInteractionResponseDTO;

import java.util.List;

public interface IUserInteractionService {
    UserInteractionResponseDTO create(UserInteractionCreateDTO dto);


    UserInteractionResponseDTO getById(Long id);


    List<UserInteractionResponseDTO> getAll();


    List<UserInteractionResponseDTO> getByUserId(Long userId);


    List<UserInteractionResponseDTO> getByPropertyId(Long propertyId);


    void delete(Long id);
}
