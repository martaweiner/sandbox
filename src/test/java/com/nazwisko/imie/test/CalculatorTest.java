package com.nazwisko.imie.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void shouldAddTwoNumbers() {
        //given
        Calculator calculator = new Calculator();
        //when
        Double sum = calculator.add(2.5, 3.0);
        //then
        assertEquals(5.5, sum);
    }

    @Test
    void shouldReturnNumber(){
        //given
        Calculator calculator = new Calculator();
        //when
        Integer one = calculator.getDigit("jeden");
        Integer nine = calculator.getDigit("dziewiec");
        Integer five = calculator.getDigit("piec");
        //then
        assertEquals(1, one);
        assertEquals(9, nine);
        assertEquals(5, five);

    }
}