package com.Aga.Agali.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    @NotBlank(message = "Can't keep it idle!")
    @Size(min = 3,max = 25)
    private String firstName;
    @Column(name = "last_name")
    @NotBlank(message = "Can't keep it idle!")
    @Size(min = 3,max = 25)
    private String lastName;
    @Email(message = "Enter in email format!")
    @Column(name = "email",unique = true)
    private String email;

    private String password;
    @Column(name = "phone_number")

    private String phoneNumber;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createAt;
    @Column(name = "update_at")
    @UpdateTimestamp
    private LocalDateTime updateAt;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<UserInteraction>interactions;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Recommendation>recommendations;























}
