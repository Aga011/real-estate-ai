package com.Aga.Agali.controller.impl;

import com.Aga.Agali.controller.IRecommendationAIController;
import com.Aga.Agali.dto.RecommendationResponseDTO;
import com.Aga.Agali.services.IRecommendationAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/ai-recommendations")
public class RecommendationAIControllerIMPL implements IRecommendationAIController {
    @Autowired
    private IRecommendationAIService aiService;
    @Override
    @GetMapping("/user/{userId}")
    public List<RecommendationResponseDTO> generateRecommendationsForUser( @PathVariable Long userId,
                                                                           @RequestParam(defaultValue = "5") int limit) {
        return  aiService.generateRecommendationsForUser(userId, limit);
    }
}
