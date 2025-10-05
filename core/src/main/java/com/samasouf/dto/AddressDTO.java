package com.samasouf.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private Long addressId;
    private String completeName;
    private Double postalCode;
    private String street;
    private String city;
    private String region;
    private String country;
}
