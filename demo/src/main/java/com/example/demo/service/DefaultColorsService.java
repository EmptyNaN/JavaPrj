package com.example.demo.service;

import com.example.demo.dto.ColorsDto;
import com.example.demo.entity.Colors;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.ColorsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultColorsService implements ColorsService{

    private final ColorsRepository colorsRepository;
    private final ColorsConverter colorsConverter;

    @Override
    public ColorsDto saveColor(ColorsDto colorsDto) throws ValidationException{
        validateColorDto(colorsDto);
        Colors savedColor = colorsRepository.save(colorsConverter.fromColorDtoToColor(colorsDto));
        return colorsConverter.fromColorToColorDto(savedColor);
    }

    @Override
    public List<ColorsDto> findAll(){
        return colorsRepository.findAll()
                .stream()
                .map(colorsConverter::fromColorToColorDto)
                .collect(Collectors.toList());
    }


    private void validateColorDto(ColorsDto colorsDto) throws ValidationException {
        if (isNull(colorsDto)) {
            throw new ValidationException("Object is null");
        }
        if (isNull(colorsDto.getName()) || colorsDto.getName().isEmpty()) {
            throw new ValidationException("name is empty");
        }
    }
}
