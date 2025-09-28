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
public class TransactionLandDTO {
    private Long transactionLandId;
    private String type;
    private String status;
    private Double price;
    private Double commission;
    private String paymentStatus;
    private OffsetDateTime paymentDate;
    private String paymentMethod;
    private Long userId;
    private Long announcementId;
}
