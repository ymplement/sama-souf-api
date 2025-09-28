package com.samasouf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypeNotificationDTO {
    private Long typeNotificationId;
    private boolean announcement;
    private boolean price;
    private boolean message;
    private boolean visit;
    private boolean newsletter;
    private Long userId;
}
