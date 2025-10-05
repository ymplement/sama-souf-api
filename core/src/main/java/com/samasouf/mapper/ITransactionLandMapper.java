package com.samasouf.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.samasouf.domain.TransactionLand;
import com.samasouf.dto.TransactionLandDTO;

@Mapper(componentModel = "spring", uses = { IUserMapper.class })
public interface ITransactionLandMapper {

    @Mapping(target = "land", ignore = true) // Break circular reference
    TransactionLandDTO toTransactionLandDTO(TransactionLand transactionLand);
}
