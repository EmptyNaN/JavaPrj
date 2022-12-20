package com.example.demo.controller;

import com.example.demo.dto.ManDto;
import com.example.demo.exception.ValidationException;
import com.example.demo.service.ManService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/man")
@AllArgsConstructor
@Log
public class ManController {
    private final ManService manService;

    @PostMapping("/save")
    public ManDto saveMan(@RequestBody ManDto manDto) throws ValidationException {
        log.info("Handling save users: " + manDto);
        return manService.saveMan(manDto);
    }

    @GetMapping("/findAll")
    public List<ManDto> findAllMans() {
        log.info("Handling find all users request");
        return manService.findAll();
    }

}
