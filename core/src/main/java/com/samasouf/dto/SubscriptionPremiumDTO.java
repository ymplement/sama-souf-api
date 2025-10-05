package com.samasouf.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class SubscriptionPremiumDTO {
    private Long subscriptionId;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private String type;
    private String statut;
    private UserDTO user;
}
