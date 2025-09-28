package com.samasouf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

import com.samasouf.domain.common.Language;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FaqDTO {
    private Long faqId;
    private Language lang;
    private String question;
    private String answer;
    private String type;
    private String category;
    private List<String> keywords;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private Long createdById;
    private Long updatedById;
    private boolean isVisible;
    private Integer views;
}
