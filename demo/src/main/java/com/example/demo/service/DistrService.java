package com.example.demo.service;

import com.example.demo.dto.DistrDto;
import com.example.demo.exception.ValidationException;

import java.util.List;

public interface DistrService {

    DistrDto saveDistr(DistrDto distrDto) throws ValidationException;
    List<DistrDto> findAll();
}
