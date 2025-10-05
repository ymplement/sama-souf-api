package com.samasouf.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementListResponse {
    private List<AnnouncementSummaryDTO> announcements;
    private Integer totalCount;
    private Integer currentPage;
    private Integer totalPages;
    private Boolean hasNext;
    private Boolean hasPrevious;
}
