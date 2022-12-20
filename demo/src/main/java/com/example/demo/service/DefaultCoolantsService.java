package com.example.demo.service;

import com.example.demo.dto.CoolantsDto;
import com.example.demo.entity.Coolants;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.CoolantsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultCoolantsService implements CoolantsService{

    private final CoolantsRepository coolantsRepository;
    private final CoolantsConverter colorsConverter;

    @Override
    public CoolantsDto saveCoolant(CoolantsDto coolantsDto) throws ValidationException{
        validateCoolantDto(coolantsDto);
        Coolants savedCoolant = coolantsRepository.save(colorsConverter.fromCoolantsDtoToCoolants(coolantsDto));
        return colorsConverter.fromCoolantsToCoolantsDto(savedCoolant);
    }

    @Override
    public void deleteCoolant(Integer cityId) {
        coolantsRepository.deleteById(cityId);
    }

    @Override
    public List<CoolantsDto> findAll(){
        return coolantsRepository.findAll()
                .stream()
                .map(colorsConverter::fromCoolantsToCoolantsDto)
                .collect(Collectors.toList());
    }


    private void validateCoolantDto(CoolantsDto coolantsDto) throws ValidationException {
        if (isNull(coolantsDto)) {
            throw new ValidationException("Object is null");
        }
        if (isNull(coolantsDto.getName()) || coolantsDto.getName().isEmpty()) {
            throw new ValidationException("name is empty");
        }
    }
}

