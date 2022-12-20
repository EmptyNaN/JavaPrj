package com.example.demo.service;

import com.example.demo.dto.ManDto;
import com.example.demo.entity.Man;
import org.springframework.stereotype.Component;

@Component
public class ManConverter {

    public Man fromManDtoToMan(ManDto manDto) {
        Man man = new Man();
        man.setId(manDto.getId());
        man.setName(manDto.getName());
        man.setCountry(manDto.getCountry());
        return man;
    }

    public ManDto fromManToManDto(Man man) {
        ManDto manDto = new ManDto();
        manDto.setId(man.getId());
        manDto.setName(man.getName());
        manDto.setCountry(man.getCountry());
        return manDto;
    }
}
