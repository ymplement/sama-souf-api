package com.samasouf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationPreferenceDTO {
    private Long notificationPreferenceId;
    private boolean email;
    private boolean sms;
    private boolean push;
    private boolean marketing;
    private Long userId;
}
