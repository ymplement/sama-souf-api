package com.samasouf.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExternalSourceDTO {
    private Long externalSourceId;
    private String name;
    private String siteUrl;
    private String type;
}
