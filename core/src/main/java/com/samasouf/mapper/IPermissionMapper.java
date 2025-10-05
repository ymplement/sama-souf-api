package com.samasouf.mapper;

import org.mapstruct.Mapper;

import com.samasouf.domain.security.Permission;
import com.samasouf.dto.PermissionDTO;

@Mapper(componentModel = "spring")
public interface IPermissionMapper {

    PermissionDTO toPermissionDTO(Permission permission);
}
