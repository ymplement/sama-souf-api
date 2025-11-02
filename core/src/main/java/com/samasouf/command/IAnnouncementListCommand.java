package com.samasouf.command;

import com.samasouf.criteria.AnnouncementCriteria;
import com.samasouf.dto.response.AnnouncementListResponse;

public interface IAnnouncementListCommand {
    AnnouncementListResponse execute(AnnouncementCriteria criteria);
}
