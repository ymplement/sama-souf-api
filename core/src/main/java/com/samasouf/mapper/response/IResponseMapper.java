package com.samasouf.mapper.response;

import java.util.List;

import org.mapstruct.Mapper;

import com.samasouf.dto.response.AnnouncementListResponse;
import com.samasouf.dto.response.AnnouncementSummaryDTO;

@Mapper(componentModel = "spring")
public interface IResponseMapper {

    // Response wrapper - using builder pattern since we have multiple parameters
    default AnnouncementListResponse toListResponse(List<AnnouncementSummaryDTO> summaryList, Integer totalCount,
            Integer currentPage, Integer totalPages, Boolean hasNext, Boolean hasPrevious) {
        return AnnouncementListResponse.builder().announcements(summaryList).totalCount(totalCount)
                .currentPage(currentPage).totalPages(totalPages).hasNext(hasNext).hasPrevious(hasPrevious).build();
    }
}
