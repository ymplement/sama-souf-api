package com.samasouf.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LandRequest {

    @Size(max = 255, message = "Title must not exceed 255 characters")
    private String title;

    @Size(max = 4000, message = "Description must not exceed 4000 characters")
    private String description;

    private Double minSurface;
    private Double maxSurface;
    private Double minPrice;
    private Double maxPrice;
    private String type;
    private Boolean isCertified;
    private String status;
    private Long announcementId;
    private Long locationId;

    // Pagination fields
    @Min(value = 0, message = "Page number must be greater than or equal to 0")
    private Integer page = 0;

    @Min(value = 1, message = "Page size must be greater than 0")
    private Integer size = 10;
}
