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
public class SubscriptionPremiumDTO {
    private Long subscriptionId;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private String type;
    private String statut;
    private Long userId;
}
