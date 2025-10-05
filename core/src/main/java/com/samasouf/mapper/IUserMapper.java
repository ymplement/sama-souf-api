package com.samasouf.mapper;

import org.mapstruct.Mapper;

import com.samasouf.domain.User;
import com.samasouf.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface IUserMapper {

    UserDTO toUserDTO(User user);
}
