package com.Aga.Agali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String location;
    private Double price;
    private Integer bedRooms;
    private Integer bathRooms;
    private String type;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    List<UserInteractionResponseDTO> interactions;
    List<RecommendationResponseDTO>recommendations;
}
