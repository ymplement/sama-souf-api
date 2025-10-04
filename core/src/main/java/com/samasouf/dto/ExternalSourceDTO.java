package com.samasouf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExternalSourceDTO {
    private Long externalSourceId;
    private String name;
    private String siteUrl;
    private String type;
    private LandDTO land;
}
