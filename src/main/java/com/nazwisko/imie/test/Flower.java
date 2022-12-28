package com.nazwisko.imie.test;

import lombok.Data;

@Data
public class Flower {
    private String color;
    private String name;
    private Double length;
    private Integer ageInDays;
    private Double minTemperature;

    public Integer getAgeInHours() {
        return ageInDays * 24;
    }
}
