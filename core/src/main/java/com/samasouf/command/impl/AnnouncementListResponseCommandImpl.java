package com.samasouf.command.impl;

import org.springframework.stereotype.Component;

import com.samasouf.command.IAnnouncementListCommand;
import com.samasouf.command.IAnnouncementListResponseCommand;
import com.samasouf.criteria.AnnouncementCriteria;
import com.samasouf.dto.AnnouncementDTO;
import com.samasouf.dto.response.AnnouncementListResponse;
import com.samasouf.dto.response.AnnouncementSummaryDTO;
import com.samasouf.mapper.response.IResponseMapper;
import com.samasouf.mapper.response.ISummaryMapper;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Component
public class AnnouncementListResponseCommandImpl implements IAnnouncementListResponseCommand {

    private final IAnnouncementListCommand announcementListCommand;
    private final IResponseMapper responseMapper;
    private final ISummaryMapper summaryMapper;

    @Override
    public AnnouncementListResponse execute(AnnouncementCriteria criteria) {
        // Get the list of announcements from the existing command
        List<AnnouncementDTO> announcements = announcementListCommand.execute(criteria);

        // Convert to summary DTOs
        List<AnnouncementSummaryDTO> summaryList = summaryMapper.toSummaryDTOList(announcements);

        // Calculate pagination info (these should be calculated based on actual data
        // and criteria)
        int totalCount = summaryList.size(); // This should come from a count query
        int pageSize = criteria.getPageSize() != null ? criteria.getPageSize() : 10;
        int currentPage = criteria.getPageNumber() != null ? criteria.getPageNumber() : 0;
        int totalPages = (int) Math.ceil((double) totalCount / pageSize);
        boolean hasNext = currentPage < totalPages - 1;
        boolean hasPrevious = currentPage > 0;

        return responseMapper.toListResponse(summaryList, totalCount, currentPage, totalPages, hasNext, hasPrevious);
    }
}
