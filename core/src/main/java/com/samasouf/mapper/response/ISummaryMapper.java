package com.samasouf.mapper.response;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import com.samasouf.dto.AnnouncementDTO;
import com.samasouf.dto.LandDTO;
import com.samasouf.dto.response.AnnouncementSummaryDTO;
import com.samasouf.dto.response.LandSummaryDTO;
import com.samasouf.mapper.ILocationMapper;
import com.samasouf.mapper.IMediaMapper;

@Mapper(componentModel = "spring", uses = { ILocationMapper.class, IMediaMapper.class })
public interface ISummaryMapper {

        // LandDTO to LandSummaryDTO mapping
        @Mappings({ @Mapping(target = "location", source = "location.fullAddress"),
                        @Mapping(target = "price", source = "price"), @Mapping(target = "surface", source = "surface"),
                        @Mapping(target = "type", source = "type"),
                        @Mapping(target = "images", source = "medias", qualifiedByName = "extractImageUrls") })
        LandSummaryDTO toLandSummaryDTO(LandDTO landDTO);

        // Helper method to extract image URLs from MediaDTO list
        @Named("extractImageUrls")
        default List<String> extractImageUrls(List<com.samasouf.dto.MediaDTO> medias) {
                if (medias == null || medias.isEmpty()) {
                        return List.of();
                }
                return medias.stream().filter(media -> media != null && media.getUrl() != null)
                                .map(com.samasouf.dto.MediaDTO::getUrl).collect(java.util.stream.Collectors.toList());
        }

        // DTO to Summary DTO mappings
        @Mappings({ @Mapping(target = "id", source = "announcementId"), @Mapping(target = "title", source = "title"),
                        @Mapping(target = "description", source = "description"),
                        @Mapping(target = "status", source = "status"), @Mapping(target = "type", source = "type"),
                        @Mapping(target = "lands", source = "lands"), @Mapping(target = "features", ignore = true),
                        @Mapping(target = "views", ignore = true), @Mapping(target = "favorites", ignore = true),
                        @Mapping(target = "messages", ignore = true),
                        @Mapping(target = "lastActivity", ignore = true) })
        AnnouncementSummaryDTO toSummaryDTO(AnnouncementDTO announcementDTO);

        List<AnnouncementSummaryDTO> toSummaryDTOList(List<AnnouncementDTO> announcementDTOs);

        List<LandSummaryDTO> toLandSummaryDTOList(List<LandDTO> landDTOs);
}
