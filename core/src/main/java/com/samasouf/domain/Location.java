package com.samasouf.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_id_seq")
    private Long location_id;

    @Column(name = "full_address")
    private String fullAddress;

    @Column(name = "postal_code")
    private Double postalCode;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "departement")
    private String departement;

    @Column(name = "region")
    private String region;

    @Column(name = "country")
    private String commune;

    @Column(name = "zone_urbaine")
    private String zoneRurale;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "geohash")
    private String geohash;
}
