package com.samasouf.service;

import java.util.List;
import java.util.Optional;

import com.samasouf.criteria.LandCriteria;
import com.samasouf.dto.LandDTO;

public interface ILandService {
    List<LandDTO> getAllByCriteria(LandCriteria criteria);

    Optional<LandDTO> getById(Long id);
}
