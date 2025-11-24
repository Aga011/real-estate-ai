package com.Aga.Agali.services;

import com.Aga.Agali.dto.RecommendationCreateDTO;
import com.Aga.Agali.dto.RecommendationResponseDTO;

import java.util.List;

public interface IRecommendationService {
    RecommendationResponseDTO save(RecommendationCreateDTO dto);

    RecommendationResponseDTO getById(Long id);

    List<RecommendationResponseDTO>getAll();

    List<RecommendationResponseDTO> getByUserId(Long userId);

    List<RecommendationResponseDTO> getByPropertyId(Long propertyId);

    void delete(Long id);
}
