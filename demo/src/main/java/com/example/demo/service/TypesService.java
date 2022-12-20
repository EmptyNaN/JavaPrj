package com.example.demo.service;

import com.example.demo.dto.TypesDto;
import com.example.demo.exception.ValidationException;

import java.util.List;

public interface TypesService {

    TypesDto saveType(TypesDto typesDto) throws ValidationException;
    List<TypesDto> findAll();
}
