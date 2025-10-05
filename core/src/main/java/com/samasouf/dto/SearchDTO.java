package com.samasouf.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class SearchDTO {
    private Long searchId;
    private OffsetDateTime date;
    private AnnouncementDTO announcement;
    private Long userId;
}
