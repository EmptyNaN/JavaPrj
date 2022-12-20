package com.example.demo.service;

import com.example.demo.dto.CoolantsDto;
import com.example.demo.entity.Coolants;
import org.springframework.stereotype.Component;

@Component
public class CoolantsConverter {

    public Coolants fromCoolantsDtoToCoolants(CoolantsDto coolantsDto) {
        Coolants coolants = new Coolants();
        coolants.setId(coolantsDto.getId());
        coolants.setName(coolantsDto.getName());
        return coolants;
    }

    public CoolantsDto fromCoolantsToCoolantsDto(Coolants coolants) {
        CoolantsDto coolantsDto = new CoolantsDto();
        coolantsDto.setId(coolants.getId());
        coolantsDto.setName(coolants.getName());
        return coolantsDto;
    }
}
