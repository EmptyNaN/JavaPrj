package com.example.demo.service;

import com.example.demo.dto.CitiesDto;
import com.example.demo.exception.ValidationException;

import java.util.List;

public interface CitiesService {

    CitiesDto saveCity(CitiesDto citiesDto) throws ValidationException;
    void deleteCity(Integer cityId);
    List<CitiesDto> findAll();
}

