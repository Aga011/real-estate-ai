package com.Aga.Agali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationCreateDTO {

    private Long userId;
    private Long propertyId;
    private Double score;
}
