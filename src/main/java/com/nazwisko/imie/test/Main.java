package com.nazwisko.imie.test;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)throws Exception {
        String s = "s";

        Flower stokrotka = new Flower();
        stokrotka.setAgeInDays(2);
        stokrotka.setColor("white");
        stokrotka.setLength(15.5);
        stokrotka.setName("stokrotka");

        System.out.println(stokrotka);

        System.out.println(stokrotka.getAgeInHours());

        Calculator calculator = new Calculator();

        Double suma = calculator.add(2.0,3.0);
        System.out.println(suma);

        Room martasRoom = new Room();
        martasRoom.setArea(12.0);
        List<Flower> flowers = new ArrayList<>();
        flowers.add(stokrotka);
        martasRoom.setFlowers(flowers);
        martasRoom.setOwner("Marta");

        System.out.println(martasRoom.roomDescription());
    }
}
