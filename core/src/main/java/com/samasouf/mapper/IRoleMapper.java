package com.samasouf.mapper;

import org.mapstruct.Mapper;

import com.samasouf.domain.security.Role;
import com.samasouf.dto.RoleDTO;

@Mapper(componentModel = "spring", uses = { IPermissionMapper.class })
public interface IRoleMapper {

    RoleDTO toRoleDTO(Role role);
}
