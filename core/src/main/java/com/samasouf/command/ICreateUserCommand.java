package com.samasouf.command;

import com.samasouf.dto.UserDTO;

public interface ICreateUserCommand {
    UserDTO execute(UserDTO userDTO);
}
