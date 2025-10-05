package com.samasouf.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.samasouf.dto.DocumentDTO;
import com.samasouf.domain.Document;

@Mapper(componentModel = "spring")
public interface IDocumentMapper {

    @Mapping(target = "land", ignore = true) // Break circular reference
    DocumentDTO toDocumentDTO(Document document);
}
