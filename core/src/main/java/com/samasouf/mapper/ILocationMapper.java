package com.samasouf.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.samasouf.domain.Location;
import com.samasouf.dto.LocationDTO;

@Mapper(componentModel = "spring")
public interface ILocationMapper {
    @Mapping(target = "locationId", source = "location_id")
    LocationDTO toLocationDTO(Location location);
}
