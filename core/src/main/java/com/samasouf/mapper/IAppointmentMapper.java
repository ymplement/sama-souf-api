package com.samasouf.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.samasouf.domain.Appointment;
import com.samasouf.dto.AppointmentDTO;

@Mapper(componentModel = "spring", uses = { IUserMapper.class })
public interface IAppointmentMapper {

    @Mapping(target = "land", ignore = true) // Break circular reference
    AppointmentDTO toAppointmentDTO(Appointment appointment);
}
