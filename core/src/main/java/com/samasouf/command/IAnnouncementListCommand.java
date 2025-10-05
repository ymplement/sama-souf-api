package com.samasouf.command;

import java.util.List;

import com.samasouf.criteria.AnnouncementCriteria;
import com.samasouf.dto.AnnouncementDTO;

public interface IAnnouncementListCommand {
    List<AnnouncementDTO> execute(AnnouncementCriteria criteria);
}
