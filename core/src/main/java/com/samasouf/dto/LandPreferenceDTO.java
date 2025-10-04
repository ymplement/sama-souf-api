package com.samasouf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LandPreferenceDTO {
    private Long landPreferenceId;
    private String location;
    private String landType;
    private Double minSurface;
    private Double maxSurface;
    private Double budgetMin;
    private Double budgetMax;
    private boolean isPushed;
    private UserDTO userId;
}
