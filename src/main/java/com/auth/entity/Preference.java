package com.auth.entity;

import com.auth.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "preferences")
@Data
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    @Enumerated(EnumType.STRING)
    private Gender preferredGender;

    private Integer minAge;
    private Integer maxAge;

    private Integer distanceKm; // radius

    // getters & setters
}