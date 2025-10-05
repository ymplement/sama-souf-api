package com.samasouf.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MediaDTO {
    private Long mediaId;
    private String name;
    private String type;
    private String url;
    private LandDTO land;
}
