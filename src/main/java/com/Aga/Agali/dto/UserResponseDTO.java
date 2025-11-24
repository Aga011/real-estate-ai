package com.Aga.Agali.dto;

import com.Aga.Agali.entity.Recommendation;
import com.Aga.Agali.entity.UserInteraction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private List<UserInteractionResponseDTO> interactions;
    private List<RecommendationResponseDTO> recommendations;

}
