package com.samasouf.mapper;

import org.mapstruct.Mapper;

import com.samasouf.domain.TransactionLand;
import com.samasouf.dto.TransactionLandDTO;

@Mapper(componentModel = "spring", uses = { IUserMapper.class })
public interface ITransactionLandMapper {

    TransactionLandDTO toTransactionLandDTO(TransactionLand transactionLand);
}
