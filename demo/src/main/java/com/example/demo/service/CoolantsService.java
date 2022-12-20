package com.example.demo.service;

import com.example.demo.dto.CoolantsDto;
import com.example.demo.exception.ValidationException;

import java.util.List;

public interface CoolantsService {

    CoolantsDto saveCoolant(CoolantsDto coolantsDto) throws ValidationException;
    void deleteCoolant(Integer coolantId);
    List<CoolantsDto> findAll();
}
