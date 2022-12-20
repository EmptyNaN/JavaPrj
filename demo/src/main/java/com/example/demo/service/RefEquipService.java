package com.example.demo.service;

import com.example.demo.dto.RefEquipDto;
import com.example.demo.exception.ValidationException;

import java.util.List;

public interface RefEquipService {

    RefEquipDto saveRefEquip(RefEquipDto refEquipDto) throws ValidationException;
    List<RefEquipDto> findAll();
}