package com.example.demo.dto;
import lombok.Data;

import javax.persistence.Column;

@Data
public class RefEquipDto {

    private Integer id;
    private String name;
    private Integer manufacturer;
    private Integer color;
    private Integer type;
    private Integer distibuter;
    private Integer coolant;
    private Integer power;
    private Integer volume;
    private Integer cost;
}
