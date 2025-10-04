package com.samasouf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileEntityDTO {
    private Long fileEntityId;
    private String type;
    private String url;
    private String name;
    private String mimeType;
    private String size;
    private boolean verified;
    private DocumentDTO documentId;
}
