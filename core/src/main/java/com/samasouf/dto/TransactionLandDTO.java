package com.samasouf.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class TransactionLandDTO {
    private Long transactionLandId;
    private String type;
    private String status;
    private Double price;
    private Double commission;
    private String paymentStatus;
    private OffsetDateTime paymentDate;
    private String paymentMethod;
    private UserDTO user;
    private LandDTO land;
}
