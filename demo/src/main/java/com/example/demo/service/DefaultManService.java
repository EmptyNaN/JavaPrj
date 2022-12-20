package com.example.demo.service;

import com.example.demo.dto.ManDto;
import com.example.demo.entity.Man;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.ManRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultManService implements ManService{

    private final ManRepository manRepository;
    private final ManConverter manConverter;

    @Override
    public ManDto saveMan(ManDto coolantsDto) throws ValidationException{
        validateCountryDto(coolantsDto);
        Man savedMan = manRepository.save(manConverter.fromManDtoToMan(coolantsDto));
        return manConverter.fromManToManDto(savedMan);
    }

    @Override
    public List<ManDto> findAll(){
        return manRepository.findAll()
                .stream()
                .map(manConverter::fromManToManDto)
                .collect(Collectors.toList());
    }


    private void validateCountryDto(ManDto ManDto) throws ValidationException {
        if (isNull(ManDto)) {
            throw new ValidationException("Object is null");
        }
        if (isNull(ManDto.getName()) || ManDto.getName().isEmpty()) {
            throw new ValidationException("name is empty");
        }
    }
}


