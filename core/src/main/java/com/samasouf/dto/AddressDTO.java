package com.samasouf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private Long addressId;
    private String completeName;
    private Double postalCode;
    private String street;
    private String city;
    private String region;
    private String country;
}
