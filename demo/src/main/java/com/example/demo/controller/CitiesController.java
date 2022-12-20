package com.example.demo.controller;

import com.example.demo.dto.CitiesDto;
import com.example.demo.exception.ValidationException;
import com.example.demo.service.CitiesService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
@Log
public class CitiesController {
    private final CitiesService citiesService;

    @PostMapping("/save")
    public CitiesDto saveCities(@RequestBody CitiesDto citiesDto) throws ValidationException {
        log.info("Handling save cities: " + citiesDto);
        return citiesService.saveCity(citiesDto);
    }

    @GetMapping("/findAll")
    public List<CitiesDto> findAllCities() {
        log.info("Handling find all cities request");
        return citiesService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCities(@PathVariable Integer id) {
        log.info("Handling delete city request: " + id);
        citiesService.deleteCity(id);
        return ResponseEntity.ok().build();
    }
}
