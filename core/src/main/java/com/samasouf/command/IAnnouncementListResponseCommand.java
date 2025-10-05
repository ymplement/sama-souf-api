package com.samasouf.command;

import com.samasouf.criteria.AnnouncementCriteria;
import com.samasouf.dto.response.AnnouncementListResponse;

public interface IAnnouncementListResponseCommand {
    AnnouncementListResponse execute(AnnouncementCriteria criteria);
}
