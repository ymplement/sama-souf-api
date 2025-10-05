package com.samasouf.mapper;

import org.mapstruct.Mapper;

import com.samasouf.domain.Land;
import com.samasouf.dto.LandDTO;

@Mapper(componentModel = "spring")
public interface ILandMapper {

        LandDTO toLandDTO(Land land);
}
