package com.Aga.Agali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationResponseDTO {
    private Long id;
    private Long userId;
    private Long propertyId;
    private Double score;
    private LocalDateTime recommendedAt;

}
