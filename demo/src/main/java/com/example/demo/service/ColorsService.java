package com.example.demo.service;

import com.example.demo.dto.ColorsDto;
import com.example.demo.exception.ValidationException;

import java.util.List;

public interface ColorsService {

    ColorsDto saveColor(ColorsDto colorsDto) throws ValidationException;
    List<ColorsDto> findAll();
}

