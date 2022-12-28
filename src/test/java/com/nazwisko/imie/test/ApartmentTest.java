package com.nazwisko.imie.test;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentTest {

    Apartment apartment;

    @BeforeAll
    static void beforeAll(){
        System.out.println("before all");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("before each");
        apartment = new Apartment();
    }

    @AfterAll
    static void afterAll(){
        System.out.println("after all");
    }

    @AfterEach
    void afterEach(){
        System.out.println("after each");
    }

    @Test
    void shouldReturnApartmentArea() {
        //given
        System.out.println("shouldReturnApartmentArea");
        Room kitchen = new Room();
        kitchen.setArea(15.0);
        apartment.setKitchen(kitchen);
        Room bedroom = new Room();
        bedroom.setArea(10.0);
        apartment.setBedroom(bedroom);
        Room bathroom = new Room();
        bathroom.setArea(14.0);
        apartment.setBathroom(bathroom);
        //when
        Double area = apartment.apartmentArea();
        //then
        assertEquals(39, area);
    }


    @Test
    void shouldMoveToAnotherRoom(){
        System.out.println("shouldMoveToAnotherRoom");
        Room kitchen = new Room();
        List<Flower> flowersKitchen = new ArrayList<>();
        Flower flower = new Flower();
        flower.setName("Stokrotka");
        flowersKitchen.add(flower);
        Flower flower1 = new Flower();
        flower1.setName("Goździk");
        flowersKitchen.add(flower1);
        kitchen.setFlowers(flowersKitchen);
        apartment.setKitchen(kitchen);

        Room bedroom = new Room();
        List<Flower> flowersBedroom = new ArrayList<>();
        Flower flower2 = new Flower();
        flower2.setName("Kaktus");
        flowersBedroom.add(flower2);
        bedroom.setFlowers(flowersBedroom);
        apartment.setBedroom(bedroom);

        //when
        apartment.moveFlowers(apartment.getBedroom(), apartment.getKitchen());

        //then
        assertEquals(0, apartment.getBedroom().getFlowers().size());
        assertEquals(3, apartment.getKitchen().getFlowers().size());

    }
}