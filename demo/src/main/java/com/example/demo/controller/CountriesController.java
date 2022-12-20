package com.example.demo.controller;

import com.example.demo.dto.CountriesDto;
import com.example.demo.exception.ValidationException;
import com.example.demo.service.CountriesService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
@AllArgsConstructor
@Log
public class CountriesController {
    private final CountriesService countriesService;

    @PostMapping("/save")
    public CountriesDto saveCountry(@RequestBody CountriesDto countriesDto) throws ValidationException {
        log.info("Handling save users: " + countriesDto);
        return countriesService.saveCountry(countriesDto);
    }

    @GetMapping("/findAll")
    public List<CountriesDto> findAllCountries() {
        log.info("Handling find all users request");
        return countriesService.findAll();
    }

}
