package com.samasouf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

import com.samasouf.domain.common.AnnouncementTransaction;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementDTO {
    private Long announcementId;
    private String title;
    private String description;
    private String status;
    private String type;
    private AnnouncementTransaction announcementTransaction;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private Long ownerId;
    private Long landId;
    private List<Long> appointmentIds;
    private List<Long> transactionIds;
    private List<Long> documentIds;
}
