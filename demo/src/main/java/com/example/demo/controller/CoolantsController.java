package com.example.demo.controller;

import com.example.demo.dto.CoolantsDto;
import com.example.demo.exception.ValidationException;
import com.example.demo.service.CoolantsService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coolants")
@AllArgsConstructor
@Log
public class CoolantsController {
    private final CoolantsService colorsService;

    @PostMapping("/save")
    public CoolantsDto saveCoolant(@RequestBody CoolantsDto coolantsDto) throws ValidationException {
        log.info("Handling save users: " + coolantsDto);
        return colorsService.saveCoolant(coolantsDto);
    }

    @GetMapping("/findAll")
    public List<CoolantsDto> findAllCoolants() {
        log.info("Handling find all users request");
        return colorsService.findAll();
    }

}