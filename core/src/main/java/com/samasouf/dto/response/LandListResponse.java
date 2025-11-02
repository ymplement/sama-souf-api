package com.samasouf.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.samasouf.dto.LandDTO;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LandListResponse {
    private List<LandDTO> lands;
    private Integer totalCount;
    private Integer currentPage;
    private Integer totalPages;
    private Boolean hasNext;
    private Boolean hasPrevious;
}
