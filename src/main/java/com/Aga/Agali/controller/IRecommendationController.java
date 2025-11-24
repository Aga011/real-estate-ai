package com.Aga.Agali.controller;

import com.Aga.Agali.dto.RecommendationCreateDTO;
import com.Aga.Agali.dto.RecommendationResponseDTO;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Validated
public interface IRecommendationController {
    RecommendationResponseDTO save(@Valid RecommendationCreateDTO dto);

    RecommendationResponseDTO getById(Long id);

    List<RecommendationResponseDTO> getAll();

    List<RecommendationResponseDTO> getByUserId(Long userId);

    List<RecommendationResponseDTO> getByPropertyId(Long propertyId);

    void delete(Long id);}
