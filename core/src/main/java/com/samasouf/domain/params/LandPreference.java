package com.samasouf.domain.params;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import com.samasouf.domain.User;

@Setter
@Getter
@Entity
@Table(name = "land_preference")
public class LandPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "land_preference_id_seq")
    private Long land_preference_id;

    @Column(name = "location")
    private String location;

    @Column(name = "land_type")
    private String landType;

    @Column(name = "min_surface")
    private Double minSurface;

    @Column(name = "max_surface")
    private Double maxSurface;

    @Column(name = "budget_min")
    private Double budgetMin;

    @Column(name = "budget_max")
    private Double budgetMax;

    @Column(name = "is_pushed")
    private boolean isPushed;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

}
