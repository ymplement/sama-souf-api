package com.samasouf.request;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import com.samasouf.domain.valueObject.AnnouncementStatus;

@Getter
@Setter
public class AnnouncementRequest {

    @Size(max = 100, message = "Title must not exceed 100 characters")
    private String title;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    private String status;
    private String type;
    private AnnouncementStatus announcementTransaction;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;

    // Pagination fields
    @Min(value = 0, message = "Page number must be greater than or equal to 0")
    private Integer page = 0;

    @Min(value = 1, message = "Page size must be greater than 0")
    private Integer size = 10;
}
