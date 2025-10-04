package com.samasouf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    private Long appointmentId;
    private OffsetDateTime scheduledDate;
    private OffsetDateTime estimatedDate;
    private String status;
    private String type;
    private String proofOfVisit;
    private String note;
    private UserDTO user;
    private AnnouncementDTO announcement;
}
