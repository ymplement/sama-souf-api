package com.samasouf.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class LandDTO {
    private Long landId;
    private String title;
    private String description;
    private Double surface;
    private Double price;
    private String type;
    private boolean isCertified;
    private String commodityJson;
    private String status;

    // Nested objects - prevent circular references
    private AnnouncementDTO announcement; // Announcement with owner (no lands list to prevent cycle)
    private LocationDTO location;
    private Set<CommodityDTO> commodities;

    // Collections
    private List<MediaDTO> medias;
    private List<ImmersiveViewDTO> immersiveViews;
    private List<DocumentDTO> documents;
    private List<TransactionLandDTO> transactionLands;
    private List<AppointmentDTO> appointments;
}
