package com.example.demo.repository;

import com.example.demo.entity.Colors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorsRepository extends JpaRepository<Colors, String>{
}
