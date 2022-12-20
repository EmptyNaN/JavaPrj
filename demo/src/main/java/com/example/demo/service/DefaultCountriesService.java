package com.example.demo.service;

import com.example.demo.dto.CountriesDto;
import com.example.demo.entity.Countries;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.CountriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultCountriesService implements CountriesService{

    private final CountriesRepository countriesRepository;
    private final CountriesConverter countriesConverter;

    @Override
    public CountriesDto saveCountry(CountriesDto coolantsDto) throws ValidationException{
        validateCountryDto(coolantsDto);
        Countries savedCountry = countriesRepository.save(countriesConverter.fromCountriesDtoToCountries(coolantsDto));
        return countriesConverter.fromCountriesToCountriesDto(savedCountry);
    }

    @Override
    public List<CountriesDto> findAll(){
        return countriesRepository.findAll()
                .stream()
                .map(countriesConverter::fromCountriesToCountriesDto)
                .collect(Collectors.toList());
    }


    private void validateCountryDto(CountriesDto countriesDto) throws ValidationException {
        if (isNull(countriesDto)) {
            throw new ValidationException("Object is null");
        }
        if (isNull(countriesDto.getName()) || countriesDto.getName().isEmpty()) {
            throw new ValidationException("name is empty");
        }
    }
}

