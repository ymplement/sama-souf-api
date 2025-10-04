package com.samasouf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LandDTO {
    private Long landId;
    private String title;
    private String description;
    private Double surface;
    private Double price;
    private String type;
    private boolean isCertified;
    private String commodityJson;
    private String status;
    private LocationDTO locationId;
    private List<MediaDTO> mediaIds;
    private List<ImmersiveViewDTO> immersiveViewIds;
    private List<ExternalSourceDTO> externalSourceIds;
}
