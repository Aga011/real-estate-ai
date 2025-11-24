package com.Aga.Agali.services;


import com.Aga.Agali.dto.RecommendationResponseDTO;

import java.util.List;

public interface IRecommendationAIService {
    List<RecommendationResponseDTO> generateRecommendationsForUser(Long userId, int limit);
}
