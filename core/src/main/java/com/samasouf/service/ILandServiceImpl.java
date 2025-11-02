package com.samasouf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.samasouf.criteria.LandCriteria;
import com.samasouf.domain.Land;
import com.samasouf.dto.LandDTO;
import com.samasouf.mapper.ILandMapper;
import com.samasouf.repository.LandRepository;
import com.samasouf.specification.LandSpecification;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ILandServiceImpl implements ILandService {

    private final LandRepository landRepository;
    private final ILandMapper landMapper;

    @Override
    public List<LandDTO> getAllByCriteria(LandCriteria criteria) {
        // Create specification from criteria
        Specification<Land> specification = LandSpecification.createSpecification(criteria);

        // Create pageable object for pagination and sorting
        Pageable pageable = LandSpecification.createPageable(criteria);

        // Fetch lands from database
        Page<Land> landPage = landRepository.findAll(specification, pageable);

        // Convert entities to DTOs
        return landMapper.toDTOList(landPage.getContent());
    }

    @Override
    public Optional<LandDTO> getById(Long id) {
        return landRepository.findById(id).map(landMapper::toLandDTO);
    }
}
