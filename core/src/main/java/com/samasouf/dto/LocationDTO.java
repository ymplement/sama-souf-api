package com.samasouf.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDTO {
    private Long locationId;
    private String fullAddress;
    private Double postalCode;
    private String street;
    private String city;
    private String departement;
    private String region;
    private String commune;
    private String zoneRurale;
    private Double latitude;
    private Double longitude;
    private String geohash;
}
