package com.samasouf.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

import com.samasouf.domain.valueObject.Language;

@Getter
@Setter
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
    private UserDTO createdBy;
    private UserDTO updatedBy;
    private boolean isVisible;
    private Integer views;
}
