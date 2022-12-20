package com.example.demo.repository;

import com.example.demo.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepository extends JpaRepository<Countries, Integer>{
}
