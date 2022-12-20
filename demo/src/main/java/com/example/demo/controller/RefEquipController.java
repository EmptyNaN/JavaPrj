package com.example.demo.controller;

import com.example.demo.dto.RefEquipDto;
import com.example.demo.exception.ValidationException;
import com.example.demo.service.RefEquipService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/refEquip")
@AllArgsConstructor
@Log
public class RefEquipController {
    private final RefEquipService refEquipService;

    @PostMapping("/save")
    public RefEquipDto saveMan(@RequestBody RefEquipDto refEquipDto) throws ValidationException {
        log.info("Handling save users: " + refEquipDto);
        return refEquipService.saveRefEquip(refEquipDto);
    }

    @GetMapping("/findAll")
    public List<RefEquipDto> findAllMans() {
        log.info("Handling find all users request");
        return refEquipService.findAll();
    }

}

