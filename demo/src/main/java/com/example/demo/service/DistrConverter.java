package com.example.demo.service;

import com.example.demo.dto.DistrDto;
import com.example.demo.entity.Distr;
import org.springframework.stereotype.Component;

@Component
public class DistrConverter {

    public Distr fromDistrDtoToDistr(DistrDto distrDto) {
        Distr distr = new Distr();
        distr.setId(distrDto.getId());
        distr.setName(distrDto.getName());
        distr.setCity(distrDto.getCity());
        return distr;
    }

    public DistrDto fromDistrToDistrDto(Distr distr) {
        DistrDto distrDto = new DistrDto();
        distrDto.setId(distr.getId());
        distrDto.setName(distr.getName());
        distrDto.setCity(distr.getCity());
        return distrDto;
    }
}
