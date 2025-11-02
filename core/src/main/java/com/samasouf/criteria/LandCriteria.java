package com.samasouf.criteria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LandCriteria {
    private String title;
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
    private Integer pageNumber;
    private Integer pageSize;
}
