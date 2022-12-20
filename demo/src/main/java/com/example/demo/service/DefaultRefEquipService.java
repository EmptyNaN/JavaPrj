package com.example.demo.service;

import com.example.demo.dto.RefEquipDto;
import com.example.demo.entity.RefEquip;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.RefEquipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultRefEquipService implements RefEquipService{

    private final RefEquipRepository refEquipRepository;
    private final RefEquipConverter refEquipConverter;

    @Override
    public RefEquipDto saveRefEquip(RefEquipDto coolantsDto) throws ValidationException{
        validateCountryDto(coolantsDto);
        RefEquip savedRefEquip = refEquipRepository.save(refEquipConverter.fromRefEquipDtoToRefEquip(coolantsDto));
        return refEquipConverter.fromRefEquipToRefEquipDto(savedRefEquip);
    }

    @Override
    public List<RefEquipDto> findAll(){
        return refEquipRepository.findAll()
                .stream()
                .map(refEquipConverter::fromRefEquipToRefEquipDto)
                .collect(Collectors.toList());
    }


    private void validateCountryDto(RefEquipDto refEquipDto) throws ValidationException {
        if (isNull(refEquipDto)) {
            throw new ValidationException("Object is null");
        }
        if (isNull(refEquipDto.getName()) || refEquipDto.getName().isEmpty()) {
            throw new ValidationException("name is empty");
        }
    }
}


