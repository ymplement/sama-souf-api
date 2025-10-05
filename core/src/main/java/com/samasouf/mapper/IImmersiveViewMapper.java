package com.samasouf.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.samasouf.dto.ImmersiveViewDTO;
import com.samasouf.domain.ImmersiveView;

@Mapper(componentModel = "spring")
public interface IImmersiveViewMapper {
    // ImmersiveView mapping
    @Mapping(target = "land", ignore = true) // Break circular reference
    ImmersiveViewDTO toImmersiveViewDTO(ImmersiveView immersiveView);

}
