package com.Aga.Agali.services.impl;

import com.Aga.Agali.dto.RecommendationResponseDTO;
import com.Aga.Agali.entity.Property;
import com.Aga.Agali.entity.UserInteraction;
import com.Aga.Agali.repository.IPropertyRepository;
import com.Aga.Agali.repository.IRecommendationRepository;
import com.Aga.Agali.repository.IUserInteractionRepository;
import com.Aga.Agali.services.IRecommendationAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecommendationAIServiceIMPL implements IRecommendationAIService {
    @Autowired
    private IPropertyRepository propertyRepository;

    @Autowired
    private IUserInteractionRepository interactionRepository;

    @Autowired
    private IRecommendationRepository recommendationRepository;

    @Override
    public List<RecommendationResponseDTO> generateRecommendationsForUser(Long userId, int limit) {


        List<UserInteraction> interactions = interactionRepository.findByUserId(userId);
        List<Long> viewedPropertyIds = interactions.stream()
                .map(ui -> ui.getProperty().getId())
                .toList();


        List<Property> allProperties = propertyRepository.findAll();
        List<Property> recommended = allProperties.stream()
                .filter(p -> !viewedPropertyIds.contains(p.getId()))
                .limit(limit)
                .toList();


        List<RecommendationResponseDTO> recommendations = recommended.stream().map(p -> {
            RecommendationResponseDTO dto = new RecommendationResponseDTO();
            dto.setPropertyId(p.getId());
            dto.setUserId(userId);
            dto.setScore(Math.random());
            return dto;
        }).toList();

        return recommendations;
    }
}
