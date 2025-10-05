package com.samasouf.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.samasouf.dto.AnnouncementDTO;
import com.samasouf.domain.Announcement;

@Mapper(componentModel = "spring", uses = { ILandMapper.class, IExternalSourceMapper.class, IUserMapper.class })
public interface IAnnouncementMapper {

    AnnouncementDTO toDTO(Announcement announcement);

    // List mappings
    List<AnnouncementDTO> toDTOList(List<Announcement> announcements);

}
