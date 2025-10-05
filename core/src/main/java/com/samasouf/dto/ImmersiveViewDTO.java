package com.samasouf.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImmersiveViewDTO {
    private Long immersiveViewId;
    private String type;
    private String url;
    private boolean vrCompatible;
    private boolean premiumOnly;
    private LandDTO land;
}
