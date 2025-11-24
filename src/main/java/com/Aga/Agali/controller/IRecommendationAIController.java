package com.Aga.Agali.controller;

import com.Aga.Agali.dto.RecommendationResponseDTO;

import java.util.List;

public interface IRecommendationAIController {
    List<RecommendationResponseDTO> generateRecommendationsForUser(Long userId, int limit);
}
