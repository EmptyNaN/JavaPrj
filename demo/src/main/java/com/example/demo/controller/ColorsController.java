package com.example.demo.controller;

import com.example.demo.dto.ColorsDto;
import com.example.demo.exception.ValidationException;
import com.example.demo.service.ColorsService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colors")
@AllArgsConstructor
@Log
public class ColorsController {
    private final ColorsService colorsService;

    @PostMapping("/save")
    public ColorsDto saveColors(@RequestBody ColorsDto colorsDto) throws ValidationException {
        log.info("Handling save users: " + colorsDto);
        return colorsService.saveColor(colorsDto);
    }

    @GetMapping("/findAll")
    public List<ColorsDto> findAllColors() {
        log.info("Handling find all users request");
        return colorsService.findAll();
    }

}
