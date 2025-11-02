package com.samasouf.command;

import java.util.Optional;

import com.samasouf.dto.LandDTO;

public interface ILandGetByIdCommand {
    Optional<LandDTO> execute(Long id);
}
