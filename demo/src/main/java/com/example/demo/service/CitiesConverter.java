package com.example.demo.service;

import com.example.demo.dto.CitiesDto;
import com.example.demo.entity.Cities;
import org.springframework.stereotype.Component;

@Component
public class CitiesConverter {

    public Cities fromCityDtoToCity(CitiesDto citiesDto) {
        Cities cities = new Cities();
        cities.setId(citiesDto.getId());
        cities.setCity(citiesDto.getCity());
        return cities;
    }

    public CitiesDto fromCityToCityDto(Cities cities) {
        CitiesDto citiesDto = new CitiesDto();
        citiesDto.setId(cities.getId());
        citiesDto.setCity(cities.getCity());
        return citiesDto;
    }
}