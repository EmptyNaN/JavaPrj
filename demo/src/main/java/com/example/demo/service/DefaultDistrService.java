package com.example.demo.service;

import com.example.demo.dto.DistrDto;
import com.example.demo.entity.Distr;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.DistrRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultDistrService implements DistrService{

    private final DistrRepository distrRepository;
    private final DistrConverter distrConverter;

    @Override
    public DistrDto saveDistr(DistrDto distrsDto) throws ValidationException{
        validateCountryDto(distrsDto);
        Distr savedDistr = distrRepository.save(distrConverter.fromDistrDtoToDistr(distrsDto));
        return distrConverter.fromDistrToDistrDto(savedDistr);
    }

    @Override
    public List<DistrDto> findAll(){
        return distrRepository.findAll()
                .stream()
                .map(distrConverter::fromDistrToDistrDto)
                .collect(Collectors.toList());
    }


    private void validateCountryDto(DistrDto distrDto) throws ValidationException {
        if (isNull(distrDto)) {
            throw new ValidationException("Object is null");
        }
        if (isNull(distrDto.getName()) || distrDto.getName().isEmpty()) {
            throw new ValidationException("name is empty");
        }
    }
}


