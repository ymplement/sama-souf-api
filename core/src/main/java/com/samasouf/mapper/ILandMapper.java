package com.samasouf.mapper;

import org.mapstruct.Mapper;

import com.samasouf.domain.Land;
import com.samasouf.dto.LandDTO;

@Mapper(componentModel = "spring", uses = { ILocationMapper.class, IMediaMapper.class, IImmersiveViewMapper.class,
                IDocumentMapper.class, ITransactionLandMapper.class, IAppointmentMapper.class })
public interface ILandMapper {

        LandDTO toLandDTO(Land land);
}
