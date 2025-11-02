package com.samasouf.mapper;

import java.util.Set;

import org.mapstruct.Mapper;

import com.samasouf.domain.Commodity;
import com.samasouf.dto.CommodityDTO;

@Mapper(componentModel = "spring")
public interface ICommodityMapper {
    CommodityDTO toCommodityDTO(Commodity commodity);

    Set<CommodityDTO> toCommodityDTOSet(Set<Commodity> commodities);
}
