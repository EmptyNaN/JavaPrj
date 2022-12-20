package com.example.demo.service;

import com.example.demo.dto.CitiesDto;
import com.example.demo.entity.Cities;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.CitiesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultCitiesService implements CitiesService{

    private final CitiesRepository citiesRepository;
    private final CitiesConverter citiesConverter;

    @Override
    public CitiesDto saveCity(CitiesDto citiesDto) throws ValidationException{
        validateCityDto(citiesDto);
        Cities savedCity = citiesRepository.save(citiesConverter.fromCityDtoToCity(citiesDto));
        return citiesConverter.fromCityToCityDto(savedCity);
    }
    @Override
    public void deleteCity(Integer cityId) {
        citiesRepository.deleteById(cityId);
    }

    @Override
    public List<CitiesDto> findAll(){
        return citiesRepository.findAll()
                .stream()
                .map(citiesConverter::fromCityToCityDto)
                .collect(Collectors.toList());
    }


    private void validateCityDto(CitiesDto citiesDto) throws ValidationException {
        if (isNull(citiesDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(citiesDto.getCity()) || citiesDto.getCity().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
    }
}