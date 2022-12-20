package com.example.demo.service;

import com.example.demo.dto.ColorsDto;
import com.example.demo.entity.Colors;
import org.springframework.stereotype.Component;

@Component
public class ColorsConverter {

    public Colors fromColorDtoToColor(ColorsDto colorsDto) {
        Colors colors = new Colors();
        colors.setId(colorsDto.getId());
        colors.setName(colorsDto.getName());
        return colors;
    }

    public ColorsDto fromColorToColorDto(Colors colors) {
        ColorsDto colorsDto = new ColorsDto();
        colorsDto.setId(colors.getId());
        colorsDto.setName(colors.getName());
        return colorsDto;
    }
}