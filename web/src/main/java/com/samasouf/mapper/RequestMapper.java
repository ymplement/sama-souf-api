package com.samasouf.mapper;

import org.springframework.stereotype.Component;

import com.samasouf.criteria.AnnouncementCriteria;
import com.samasouf.request.AnnouncementRequest;

@Component
public class RequestMapper {

    public AnnouncementCriteria toAnnouncementCriteria(AnnouncementRequest request) {
        if (request == null) {
            return new AnnouncementCriteria();
        }

        AnnouncementCriteria criteria = new AnnouncementCriteria();
        criteria.setTitle(request.getTitle());
        criteria.setDescription(request.getDescription());
        criteria.setStatus(request.getStatus());
        criteria.setType(request.getType());
        criteria.setAnnouncementTransaction(request.getAnnouncementTransaction());
        criteria.setStartDate(request.getStartDate());
        criteria.setEndDate(request.getEndDate());
        criteria.setPageNumber(request.getPage());
        criteria.setPageSize(request.getSize());

        return criteria;
    }
}
