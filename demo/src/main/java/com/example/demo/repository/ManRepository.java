package com.example.demo.repository;

import com.example.demo.entity.Man;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManRepository extends JpaRepository<Man, Integer>{
}
