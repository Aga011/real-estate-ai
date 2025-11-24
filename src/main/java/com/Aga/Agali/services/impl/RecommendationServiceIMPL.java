package com.Aga.Agali.services.impl;

import com.Aga.Agali.dto.RecommendationCreateDTO;
import com.Aga.Agali.dto.RecommendationResponseDTO;
import com.Aga.Agali.entity.Property;
import com.Aga.Agali.entity.Recommendation;
import com.Aga.Agali.entity.User;
import com.Aga.Agali.repository.IPropertyRepository;
import com.Aga.Agali.repository.IRecommendationRepository;
import com.Aga.Agali.repository.IUserRepository;
import com.Aga.Agali.services.IRecommendationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceIMPL implements IRecommendationService {
    @Autowired
    private IRecommendationRepository recommendationRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IPropertyRepository propertyRepository;

    @Override
    public RecommendationResponseDTO save(RecommendationCreateDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Property property = propertyRepository.findById(dto.getPropertyId())
                .orElseThrow(() -> new RuntimeException("Property not found"));

        Recommendation recommendation = new Recommendation();
        BeanUtils.copyProperties(dto, recommendation);


        recommendation.setUser(user);
        recommendation.setProperty(property);

        Recommendation saved = recommendationRepository.save(recommendation);

        RecommendationResponseDTO response = new RecommendationResponseDTO();
        BeanUtils.copyProperties(saved, response);


        response.setUserId(saved.getUser().getId());
        response.setPropertyId(saved.getProperty().getId());

        return response;
    }

    @Override
    public RecommendationResponseDTO getById(Long id) {
        Recommendation recommendation = recommendationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recommendation not found"));

        RecommendationResponseDTO dto = new RecommendationResponseDTO();
        BeanUtils.copyProperties(recommendation, dto);
        dto.setUserId(recommendation.getUser().getId());
        dto.setPropertyId(recommendation.getProperty().getId());

        return dto;
    }

    @Override
    public List<RecommendationResponseDTO> getAll() {
        List<Recommendation> list = recommendationRepository.findAll();
        return list.stream().map(rec -> {
            RecommendationResponseDTO dto = new RecommendationResponseDTO();
            BeanUtils.copyProperties(rec, dto);
            dto.setUserId(rec.getUser().getId());
            dto.setPropertyId(rec.getProperty().getId());
            return dto;
        }).toList();
    }
    @Override
    public List<RecommendationResponseDTO> getByUserId(Long userId) {

        List<Recommendation> list = recommendationRepository.findByUserId(userId);

        return list.stream().map(rec -> {
            RecommendationResponseDTO dto = new RecommendationResponseDTO();
            BeanUtils.copyProperties(rec, dto);
            dto.setUserId(rec.getUser().getId());
            dto.setPropertyId(rec.getProperty().getId());
            return dto;
        }).toList();
    }

    @Override
    public List<RecommendationResponseDTO> getByPropertyId(Long propertyId) {

        List<Recommendation> list = recommendationRepository.findByPropertyId(propertyId);

        return list.stream().map(rec -> {
            RecommendationResponseDTO dto = new RecommendationResponseDTO();
            BeanUtils.copyProperties(rec, dto);
            dto.setUserId(rec.getUser().getId());
            dto.setPropertyId(rec.getProperty().getId());
            return dto;
        }).toList();
    }

    @Override
    public void delete(Long id) {
        if (!recommendationRepository.existsById(id)) {
            throw new RuntimeException("Recommendation not found");
        }
        recommendationRepository.deleteById(id);

    }
}
