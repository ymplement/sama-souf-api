package com.samasouf.dto.response;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.samasouf.dto.RoleDTO;
import com.samasouf.dto.UserDTO;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfoResponse {
    private UserDTO user;
    private Set<RoleDTO> roles;
    private Set<String> permissions;
}
