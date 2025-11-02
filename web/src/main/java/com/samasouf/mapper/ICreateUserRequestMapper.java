package com.samasouf.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.samasouf.dto.UserDTO;
import com.samasouf.dto.request.CreateUserRequest;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICreateUserRequestMapper {

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "authProvider", ignore = true)
    @Mapping(target = "providerId", ignore = true)
    @Mapping(target = "roles", ignore = true) // Will be handled separately
    @Mapping(target = "securitySettingsId", ignore = true)
    @Mapping(target = "confidentialityId", ignore = true)
    @Mapping(target = "addressId", ignore = true)
    @Mapping(target = "notificationPreferenceId", ignore = true)
    @Mapping(target = "landPreferenceId", ignore = true)
    @Mapping(target = "typeNotificationId", ignore = true)
    UserDTO toUserDTO(CreateUserRequest request);
}
