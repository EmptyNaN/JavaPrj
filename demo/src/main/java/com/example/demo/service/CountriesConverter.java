package com.example.demo.service;

import com.example.demo.dto.CountriesDto;
import com.example.demo.entity.Countries;
import org.springframework.stereotype.Component;

@Component
public class CountriesConverter {

    public Countries fromCountriesDtoToCountries(CountriesDto countriesDto) {
        Countries countries = new Countries();
        countries.setId(countriesDto.getId());
        countries.setName(countriesDto.getName());
        return countries;
    }

    public CountriesDto fromCountriesToCountriesDto(Countries countries) {
        CountriesDto countriesDto = new CountriesDto();
        countriesDto.setId(countries.getId());
        countriesDto.setName(countries.getName());
        return countriesDto;
    }
}
