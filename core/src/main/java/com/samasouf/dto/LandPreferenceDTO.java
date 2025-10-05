package com.samasouf.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LandPreferenceDTO {
    private Long landPreferenceId;
    private String location;
    private String landType;
    private Double minSurface;
    private Double maxSurface;
    private Double budgetMin;
    private Double budgetMax;
    private boolean isPushed;
    private UserDTO user;
}
