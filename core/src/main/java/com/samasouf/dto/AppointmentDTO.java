package com.samasouf.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class AppointmentDTO {
    private Long appointmentId;
    private OffsetDateTime scheduledDate;
    private OffsetDateTime estimatedDate;
    private String status;
    private String type;
    private String proofOfVisit;
    private String note;
    private UserDTO user;
    private LandDTO land;
}
