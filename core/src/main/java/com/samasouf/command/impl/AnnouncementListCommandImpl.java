package com.samasouf.command.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.samasouf.command.IAnnouncementListCommand;
import com.samasouf.criteria.AnnouncementCriteria;
import com.samasouf.domain.Announcement;
import com.samasouf.dto.AnnouncementDTO;
import com.samasouf.mapper.IAnnouncementMapper;
import com.samasouf.repository.AnnouncementRepository;
import com.samasouf.specification.AnnouncementSpecification;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class AnnouncementListCommandImpl implements IAnnouncementListCommand {

    private final AnnouncementRepository announcementRepository;
    private final IAnnouncementMapper announcementMapper;

    @Override
    public List<AnnouncementDTO> execute(AnnouncementCriteria criteria) {
        // Create specification from criteria
        Specification<Announcement> specification = AnnouncementSpecification.createSpecification(criteria);

        // Create pageable object for pagination and sorting
        Pageable pageable = createPageable(criteria);

        // Fetch announcements from database
        Page<Announcement> announcementPage = announcementRepository.findAll(specification, pageable);

        // Convert entities to DTOs
        return announcementMapper.toDTOList(announcementPage.getContent());
    }

    /**
     * Creates a Pageable object from the criteria
     * 
     * @param criteria the search criteria containing pagination info
     * @return the Pageable object
     */
    private Pageable createPageable(AnnouncementCriteria criteria) {
        int page = criteria.getPageNumber() != null ? criteria.getPageNumber() : 0;
        int size = criteria.getPageSize() != null ? criteria.getPageSize() : 10;

        // Default sorting by creation date (most recent first)
        Sort sort = Sort.by(Sort.Direction.DESC, "startDate");

        return PageRequest.of(page, size, sort);
    }

}
