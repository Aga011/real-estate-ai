package com.Aga.Agali.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String location;
    private Double price;
    @Column(name = "bedrooms")
    private Integer bedRooms;
    @Column(name = "bathrooms")
    private Integer bathRooms;
    private String type;
    @Column(name = "created_at",updatable = false)
    @CreationTimestamp
    private LocalDateTime createAt;
    @Column(name = "update_at")
    @UpdateTimestamp
    private LocalDateTime updateAt;
    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<UserInteraction>interactions;
    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Recommendation>recommendations;




}
