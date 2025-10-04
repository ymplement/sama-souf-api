package com.samasouf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

import com.samasouf.domain.valueObject.AnnouncementStatus;

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
    private AnnouncementStatus announcementTransaction;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private UserDTO ownerId;
    private LandDTO landId;
    private List<AppointmentDTO> appointmentIds;
    private List<TransactionLandDTO> transactionIds;
    private List<DocumentDTO> documentIds;
}
