package com.example.demo.service;

import com.example.demo.dto.TypesDto;
import com.example.demo.entity.Types;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.TypesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultTypesService implements TypesService{

    private final TypesRepository typesRepository;
    private final TypesConverter typesConverter;

    @Override
    public TypesDto saveType(TypesDto coolantsDto) throws ValidationException{
        validateCountryDto(coolantsDto);
        Types savedType = typesRepository.save(typesConverter.fromTypesDtoToTypes(coolantsDto));
        return typesConverter.fromTypesToTypesDto(savedType);
    }

    @Override
    public List<TypesDto> findAll(){
        return typesRepository.findAll()
                .stream()
                .map(typesConverter::fromTypesToTypesDto)
                .collect(Collectors.toList());
    }


    private void validateCountryDto(TypesDto typesDto) throws ValidationException {
        if (isNull(typesDto)) {
            throw new ValidationException("Object is null");
        }
        if (isNull(typesDto.getName()) || typesDto.getName().isEmpty()) {
            throw new ValidationException("name is empty");
        }
    }
}




