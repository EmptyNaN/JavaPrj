package com.example.demo.service;

import com.example.demo.dto.CountriesDto;
import com.example.demo.exception.ValidationException;

import java.util.List;

public interface CountriesService {

    CountriesDto saveCountry(CountriesDto countriesDto) throws ValidationException;
    List<CountriesDto> findAll();
}
