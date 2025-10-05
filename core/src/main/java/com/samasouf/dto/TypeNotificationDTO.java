package com.samasouf.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeNotificationDTO {
    private Long typeNotificationId;
    private boolean announcement;
    private boolean price;
    private boolean message;
    private boolean visit;
    private boolean newsletter;
    private UserDTO user;
}
