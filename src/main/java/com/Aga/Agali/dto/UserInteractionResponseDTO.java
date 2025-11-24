package com.Aga.Agali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInteractionResponseDTO {
    private Long id;
    private LocalDateTime vieweAt;
    private LocalDateTime createAt;
    private Integer durationSeconds;
    private Long userId;
    private Long propertyId;
}
