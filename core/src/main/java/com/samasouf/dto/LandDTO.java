package com.samasouf.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    private LocationDTO location;
    private List<MediaDTO> medias;
    private List<ImmersiveViewDTO> immersiveViews;
    private List<ExternalSourceDTO> externalSources;
    private List<DocumentDTO> documents;
    private List<TransactionLandDTO> transactionLands;
    private List<AppointmentDTO> appointments;
}
