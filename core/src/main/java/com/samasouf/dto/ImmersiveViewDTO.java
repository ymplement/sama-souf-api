package com.samasouf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImmersiveViewDTO {
    private Long immersiveViewId;
    private String type;
    private String url;
    private boolean vrCompatible;
    private boolean premiumOnly;
    private Long landId;
}
