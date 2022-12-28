package com.nazwisko.imie.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {
    @Test
    void shouldReturnAgeInHours(){
        //given
        Flower flower = new Flower();
        flower.setAgeInDays(5);
        //when
        Integer a = flower.getAgeInHours();
        //then
        assertEquals(120, a);
    }


}