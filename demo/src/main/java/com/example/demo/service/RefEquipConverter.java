package com.example.demo.service;

import com.example.demo.dto.RefEquipDto;
import com.example.demo.entity.RefEquip;
import org.springframework.stereotype.Component;

@Component
public class RefEquipConverter {

    public RefEquip fromRefEquipDtoToRefEquip(RefEquipDto refEquipDto) {
        RefEquip refEquip = new RefEquip();
        refEquip.setId(refEquipDto.getId());
        refEquip.setName(refEquipDto.getName());
        refEquip.setCoolant(refEquipDto.getCoolant());
        refEquip.setColor(refEquipDto.getColor());
        refEquip.setCost(refEquipDto.getCost());
        refEquip.setDistibuter(refEquipDto.getDistibuter());
        refEquip.setManufacturer(refEquipDto.getManufacturer());
        refEquip.setPower(refEquipDto.getPower());
        refEquip.setType(refEquipDto.getType());
        refEquip.setVolume(refEquipDto.getVolume());

        return refEquip;
    }

    public RefEquipDto fromRefEquipToRefEquipDto(RefEquip refEquip) {
        RefEquipDto refEquipDto = new RefEquipDto();
        refEquipDto.setId(refEquip.getId());
        refEquipDto.setName(refEquip.getName());
        refEquipDto.setCoolant(refEquip.getCoolant());
        refEquipDto.setColor(refEquip.getColor());
        refEquipDto.setCost(refEquip.getCost());
        refEquipDto.setDistibuter(refEquip.getDistibuter());
        refEquipDto.setManufacturer(refEquip.getManufacturer());
        refEquipDto.setPower(refEquip.getPower());
        refEquipDto.setType(refEquip.getType());
        refEquipDto.setVolume(refEquip.getVolume());
        return refEquipDto;
    }
}

