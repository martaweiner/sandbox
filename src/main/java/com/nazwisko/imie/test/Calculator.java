package com.nazwisko.imie.test;

public class Calculator {
    public Double add(Double a, Double b) {
        return a + b;
    }

    public Integer getDigit(String s) {
        switch (s) {
            case "jeden":
                return 1;
            case "dziewiec":
                return 9;
            case "piec":
                return 5;
        }
        return 0;
    }
}
