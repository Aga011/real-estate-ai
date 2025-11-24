package com.Aga.Agali.controller.impl;

import com.Aga.Agali.controller.IRecommendationController;
import com.Aga.Agali.dto.RecommendationCreateDTO;
import com.Aga.Agali.dto.RecommendationResponseDTO;
import com.Aga.Agali.services.IRecommendationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rest/api/recommendations")
public class RecommendationControllerIMPL implements IRecommendationController {
    @Autowired
    private IRecommendationService recommendationService;

    @Override
    @PostMapping
    public RecommendationResponseDTO save(@RequestBody  RecommendationCreateDTO dto) {
        return recommendationService.save(dto);
    }

    @Override
    @GetMapping("/{id}")
    public RecommendationResponseDTO getById(@PathVariable(name = "id") Long id) {
        return recommendationService.getById(id);
    }

    @Override
    @GetMapping
    public List<RecommendationResponseDTO> getAll() {
        return recommendationService.getAll();
    }

    @Override
    @GetMapping("/user/{userId}")
    public List<RecommendationResponseDTO> getByUserId(@PathVariable(name = "userId") Long userId) {
        return recommendationService.getByUserId(userId);
    }

    @Override
    @GetMapping("/property/{propertyId}")
    public List<RecommendationResponseDTO> getByPropertyId(@PathVariable(name = "propertyId") Long propertyId) {
        return recommendationService.getByPropertyId(propertyId);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete (@PathVariable(name = "id") Long id) {
        recommendationService.delete(id);

    }
}
