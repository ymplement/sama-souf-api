package com.samasouf.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class RoleDTO {
    private Long roleId;
    private String name;
    private String description;
    private Set<PermissionDTO> permissions;
}
