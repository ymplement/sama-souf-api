package com.samasouf.mapper;

import org.mapstruct.Mapper;

import com.samasouf.domain.Appointment;
import com.samasouf.dto.AppointmentDTO;

@Mapper(componentModel = "spring", uses = { IUserMapper.class })
public interface IAppointmentMapper {

    AppointmentDTO toAppointmentDTO(Appointment appointment);
}
