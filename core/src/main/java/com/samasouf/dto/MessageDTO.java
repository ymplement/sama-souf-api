package com.samasouf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
    private Long messageId;
    private UserDTO author;
    private UserDTO recipient;
    private AnnouncementDTO announcement;
    private String content;
    private OffsetDateTime sentAt;
    private LocalDateTime readAt;
    private boolean isRead;
    private boolean authorDeleted;
    private boolean recipientDeleted;
}
