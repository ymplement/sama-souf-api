package com.samasouf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

import com.samasouf.domain.valueObject.AnnouncementStatus;

@Getter
@Setter
public class AnnouncementDTO {
    private Long announcementId;
    private String title;
    private String description;
    private String status;
    private String type;
    private AnnouncementStatus announcementTransaction;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private UserDTO owner;
    private List<LandDTO> lands;
    private ExternalSourceDTO externalSource;
}
