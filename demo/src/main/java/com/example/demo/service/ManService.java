package com.example.demo.service;

import com.example.demo.dto.ManDto;
import com.example.demo.exception.ValidationException;

import java.util.List;

public interface ManService {

    ManDto saveMan(ManDto manDto) throws ValidationException;
    List<ManDto> findAll();
}
