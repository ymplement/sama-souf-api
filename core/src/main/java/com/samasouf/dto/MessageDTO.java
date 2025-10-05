package com.samasouf.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter
@Setter
public class MessageDTO {
    private Long messageId;
    private UserDTO author;
    private UserDTO recipient;
    private LandDTO land;
    private String content;
    private OffsetDateTime sentAt;
    private LocalDateTime readAt;
    private boolean isRead;
    private boolean authorDeleted;
    private boolean recipientDeleted;
}
