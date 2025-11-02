package com.samasouf.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.samasouf.domain.Land;
import com.samasouf.dto.LandDTO;

@Mapper(componentModel = "spring", uses = { ILocationMapper.class, IMediaMapper.class, IImmersiveViewMapper.class,
                IDocumentMapper.class, ITransactionLandMapper.class, IAppointmentMapper.class,
                IAnnouncementMapper.class, ICommodityMapper.class })
public interface ILandMapper {

        @Mapping(target = "announcement", ignore = true)
        LandDTO toLandDTO(Land land);

        List<LandDTO> toDTOList(List<Land> lands);
}
