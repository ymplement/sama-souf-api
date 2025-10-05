package com.samasouf.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationPreferenceDTO {
    private Long notificationPreferenceId;
    private boolean email;
    private boolean sms;
    private boolean push;
    private boolean marketing;
    private UserDTO user;
}
