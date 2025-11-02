package com.samasouf.service;

import java.util.List;

import com.samasouf.criteria.AnnouncementCriteria;
import com.samasouf.dto.AnnouncementDTO;

public interface IAnnouncementService {
    List<AnnouncementDTO> getAllByCriteria(AnnouncementCriteria criteria);
}
