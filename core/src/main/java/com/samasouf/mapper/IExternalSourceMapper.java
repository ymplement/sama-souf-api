package com.samasouf.mapper;

import org.mapstruct.Mapper;

import com.samasouf.dto.ExternalSourceDTO;
import com.samasouf.domain.ExternalSource;

@Mapper(componentModel = "spring")
public interface IExternalSourceMapper {

    ExternalSourceDTO toExternalSourceDTO(ExternalSource externalSource);
}
