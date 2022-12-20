package com.example.demo.controller;

import com.example.demo.dto.TypesDto;
import com.example.demo.exception.ValidationException;
import com.example.demo.service.TypesService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
@AllArgsConstructor
@Log
public class TypesController {
    private final TypesService typesService;

    @PostMapping("/save")
    public TypesDto saveMan(@RequestBody TypesDto typesDto) throws ValidationException {
        log.info("Handling save users: " + typesDto);
        return typesService.saveType(typesDto);
    }

    @GetMapping("/findAll")
    public List<TypesDto> findAllMans() {
        log.info("Handling find all users request");
        return typesService.findAll();
    }

}
