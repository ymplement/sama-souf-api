package com.samasouf.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.samasouf.criteria.AnnouncementCriteria;
import com.samasouf.criteria.LandCriteria;
import com.samasouf.request.AnnouncementRequest;
import com.samasouf.request.LandRequest;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RequestMapper {

    @Mapping(source = "page", target = "pageNumber")
    @Mapping(source = "size", target = "pageSize")
    AnnouncementCriteria toAnnouncementCriteria(AnnouncementRequest request);

    @Mapping(source = "page", target = "pageNumber")
    @Mapping(source = "size", target = "pageSize")
    LandCriteria toLandCriteria(LandRequest request);
}
