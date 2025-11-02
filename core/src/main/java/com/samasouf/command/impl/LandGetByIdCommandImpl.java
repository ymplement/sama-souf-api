package com.samasouf.command.impl;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.samasouf.command.ILandGetByIdCommand;
import com.samasouf.domain.Land;
import com.samasouf.dto.LandDTO;
import com.samasouf.mapper.ILandMapper;
import com.samasouf.repository.LandRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class LandGetByIdCommandImpl implements ILandGetByIdCommand {

    private final LandRepository landRepository;
    private final ILandMapper landMapper;

    @Override
    public Optional<LandDTO> execute(Long id) {
        Optional<Land> land = landRepository.findById(id);
        return land.map(landMapper::toLandDTO);
    }
}
