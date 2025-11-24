package com.Aga.Agali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInteractionCreateDTO {
    private Integer durationSeconds;
    private Long userId;
    private Long propertyId;
    }
