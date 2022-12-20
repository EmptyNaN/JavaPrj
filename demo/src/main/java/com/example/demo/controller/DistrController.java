package com.example.demo.controller;

import com.example.demo.dto.DistrDto;
import com.example.demo.exception.ValidationException;
import com.example.demo.service.DistrService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/distr")
@AllArgsConstructor
@Log
public class DistrController {
    private final DistrService distrService;

    @PostMapping("/save")
    public DistrDto saveDistr(@RequestBody DistrDto distrsDto) throws ValidationException {
        log.info("Handling save users: " + distrsDto);
        return distrService.saveDistr(distrsDto);
    }

    @GetMapping("/findAll")
    public List<DistrDto> findAllDistrs() {
        log.info("Handling find all users request");
        return distrService.findAll();
    }

}

