package com.samasouf.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LandSummaryDTO {
    private String location; // fullAddress in LocationDTO
    private Double price; // price in LandDTO
    private Double surface; // surface in LandDTO
    private String type; // type in LandDTO
    private List<String> images; // url in ImageDTO
}
