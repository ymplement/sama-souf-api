package com.samasouf.mapper;

import org.mapstruct.Mapper;

import com.samasouf.dto.DocumentDTO;
import com.samasouf.domain.Document;

@Mapper(componentModel = "spring")
public interface IDocumentMapper {

    DocumentDTO toDocumentDTO(Document document);
}
