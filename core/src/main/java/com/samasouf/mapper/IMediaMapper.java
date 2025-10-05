package com.samasouf.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.samasouf.dto.MediaDTO;
import com.samasouf.domain.Media;

@Mapper(componentModel = "spring")
public interface IMediaMapper {

    MediaDTO toMediaDTO(Media media);

    // Helper method to extract image URLs from MediaDTO list
    default List<String> extractImageUrls(List<MediaDTO> medias) {
        if (medias == null || medias.isEmpty()) {
            return List.of();
        }
        return medias.stream().filter(media -> media != null && media.getUrl() != null).map(MediaDTO::getUrl)
                .collect(java.util.stream.Collectors.toList());
    }
}
