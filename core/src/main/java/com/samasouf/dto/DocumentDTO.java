package com.samasouf.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DocumentDTO {
    private Long documentId;
    private String title;
    private String type;
    private String description;
    private boolean verified;
    private LandDTO land;
    private List<FileEntityDTO> fileEntities;
}
