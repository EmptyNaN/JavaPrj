package com.example.demo.service;

import com.example.demo.dto.TypesDto;
import com.example.demo.entity.Types;
import org.springframework.stereotype.Component;

@Component
public class TypesConverter {

    public Types fromTypesDtoToTypes(TypesDto typesDto) {
        Types types = new Types();
        types.setId(typesDto.getId());
        types.setName(typesDto.getName());
        return types;
    }

    public TypesDto fromTypesToTypesDto(Types types) {
        TypesDto typesDto = new TypesDto();
        typesDto.setId(types.getId());
        typesDto.setName(types.getName());
        return typesDto;
    }
}

