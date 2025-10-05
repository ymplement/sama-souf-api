package com.samasouf.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class AnnouncementSummaryDTO {
    private Long id;
    private String title;
    private String description;
    private String type;
    private String status;
    private Integer views;
    private Integer favorites;
    private Integer messages;
    private LocalDate createdAt;
    private List<String> features;
    private String lastActivity;
    private List<LandSummaryDTO> lands;
}
