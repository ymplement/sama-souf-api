package com.samasouf.criteria;

import java.time.OffsetDateTime;

import com.samasouf.domain.valueObject.AnnouncementStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnnouncementCriteria {

    private String title;
    private String description;
    private String status;
    private String type;
    private AnnouncementStatus announcementTransaction;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;

    // Pagination fields
    private Integer pageNumber;
    private Integer pageSize;
}
