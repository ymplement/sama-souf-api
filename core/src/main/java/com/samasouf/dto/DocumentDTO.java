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
public class DocumentDTO {
    private Long documentId;
    private String title;
    private String type;
    private String description;
    private boolean verified;
    private Long announcementId;
    private List<Long> fileIds;
}
