package com.Aga.Agali.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyCreateDTO {
    private String title;
    private String description;
    private String location;
    private Double price;
    private Integer bedRooms;
    private Integer bathRooms;
    private String type;
}
