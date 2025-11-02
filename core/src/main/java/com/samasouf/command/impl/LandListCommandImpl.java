package com.samasouf.command.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.samasouf.command.ILandListCommand;
import com.samasouf.criteria.LandCriteria;
import com.samasouf.domain.Land;
import com.samasouf.dto.LandDTO;
import com.samasouf.dto.response.LandListResponse;
import com.samasouf.mapper.ILandMapper;
import com.samasouf.repository.LandRepository;
import com.samasouf.specification.LandSpecification;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Component
public class LandListCommandImpl implements ILandListCommand {

    private final LandRepository landRepository;
    private final ILandMapper landMapper;

    @Override
    public LandListResponse execute(LandCriteria criteria) {
        // Create specification from criteria
        Specification<Land> specification = LandSpecification.createSpecification(criteria);

        // Create pageable object for pagination and sorting
        Pageable pageable = LandSpecification.createPageable(criteria);

        // Fetch lands from database
        Page<Land> landPage = landRepository.findAll(specification, pageable);

        // Convert entities to DTOs
        List<LandDTO> lands = landMapper.toDTOList(landPage.getContent());

        // Calculate pagination info
        int totalCount = (int) landPage.getTotalElements();
        int currentPage = criteria.getPageNumber() != null ? criteria.getPageNumber() : 0;
        int totalPages = landPage.getTotalPages();
        boolean hasNext = landPage.hasNext();
        boolean hasPrevious = landPage.hasPrevious();

        return LandListResponse.builder().lands(lands).totalCount(totalCount).currentPage(currentPage)
                .totalPages(totalPages).hasNext(hasNext).hasPrevious(hasPrevious).build();
    }
}
