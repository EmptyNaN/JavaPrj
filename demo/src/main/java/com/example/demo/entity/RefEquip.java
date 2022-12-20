package com.example.demo.entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "refrigeration_equipment")
@Data//ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor//ломбок аннотация: конструктор без аргуметов
public class RefEquip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "name")
    private String name;

    @Column (name = "manufacturer")
    private Integer manufacturer;

    @Column (name = "color")
    private Integer color;

    @Column (name = "type")
    private Integer type;

    @Column (name = "distibuter")
    private Integer distibuter;

    @Column (name = "coolant")
    private Integer coolant;

    @Column (name = "power")
    private Integer power;

    @Column (name = "volume")
    private Integer volume;

    @Column (name = "cost")
    private Integer cost;
}
