package com.nazwisko.imie.test;

import org.junit.jupiter.api.Test;
import sun.nio.ch.FileKey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    @Test
    public void shouldDescribeRoom() throws Exception{
        //given
        Room room = new Room();
        room.setOwner("Marta");
        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new Flower());
        flowerList.add(new Flower());
        flowerList.add(new Flower());
        flowerList.add(new Flower());
        flowerList.add(new Flower());
        room.setFlowers(flowerList);
        //when
        String describe = room.roomDescription();
        //then
        assertEquals("In Marta room theres 5 flowers", describe);
    }

    @Test
    public void shouldThrowFlowers(){
        //given
        Room room = new Room();
        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new Flower());
        flowerList.add(new Flower());
        flowerList.add(new Flower());
        flowerList.add(new Flower());
        flowerList.add(new Flower());
        room.setFlowers(flowerList);
        //when
        room.throwFlowers();
        //then
        List<Flower> flowers = room.getFlowers();
        assertEquals(0, flowers.size());

    }

    @Test
    void shouldFlowerFitInRoom(){
        Room room = new Room();
        room.setArea(3.0);
        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new Flower());
        flowerList.add(new Flower());
        flowerList.add(new Flower());
        flowerList.add(new Flower());
        flowerList.add(new Flower());
        room.setFlowers(flowerList);
        //when
        Boolean a = room.canFitRoom();
        //then
        assertTrue(a);

    }

    @Test
    void shouldNotFlowerInRoom(){
        Room room = new Room();
        room.setArea(1.0);
        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new Flower());
        flowerList.add(new Flower());
        flowerList.add(new Flower());
        flowerList.add(new Flower());
        flowerList.add(new Flower());
        room.setFlowers(flowerList);
        //when
        Boolean a = room.canFitRoom();
        //then
        assertFalse(a);
    }

    @Test
    void shouldThrowException(){
        //given
        Room room = new Room();
        List<Flower> flowers = new ArrayList<>();
        room.setFlowers(flowers);
        //then
        assertThrows(Exception.class, () -> room.roomDescription(), "Room has no owner");
    }

    @Test
    void shouldThrowOldFlowers(){
        Room room = new Room();
        List<Flower> flowers = new ArrayList<>();
        Flower flower = new Flower();
        flower.setAgeInDays(100);
        flowers.add(flower);
        Flower flower2 = new Flower();
        flower2.setAgeInDays(150);
        flowers.add(flower2);
        Flower flower3 = new Flower();
        flower3.setAgeInDays(10);
        flowers.add(flower3);
        room.setFlowers(flowers);
        //when
        room.throwOldFlowers(150);
        //then
        assertEquals(2, room.getFlowers().size());

    }
    @Test
    void shouldThrowOldFlowersThan2Days(){
        Room room = new Room();
        List<Flower> flowers = new ArrayList<>();
        Flower flower = new Flower();
        flower.setAgeInDays(100);
        flowers.add(flower);
        Flower flower2 = new Flower();
        flower2.setAgeInDays(150);
        flowers.add(flower2);
        Flower flower3 = new Flower();
        flower3.setAgeInDays(10);
        flowers.add(flower3);
        room.setFlowers(flowers);
        //when
        room.throwOldFlowers(2);
        //then
        assertEquals(0, room.getFlowers().size());

    }
    @Test
    void shouldSetRoomTemperature()throws Exception{
        Room room = new Room();
        room.setRadiator(new Radiator());
        //when
        room.setTemperature(15.0);
        //then
        assertEquals(15.0, room.getRadiator().getTemperature());
    }

    @Test
    void shouldGetFlowersName(){
        Room room = new Room();
        Flower flower = new Flower();
        flower.setName("Kaktus");
        Flower flower1 = new Flower();
        flower1.setName("Roza");
        Flower flower2 = new Flower();
        flower2.setName("Kwiatek");
        List<Flower> flowers = Arrays.asList(flower, flower1, flower2);
        room.setFlowers(flowers);
        //when
        List<String> a= room.getFlowersNames();
        //then
        assertEquals(Arrays.asList("Kaktus", "Roza", "Kwiatek"), a);
    }

    @Test
    void shouldThrowExceptionOnTemperatureChange(){
        Room room = new Room();
        room.setRadiator(new Radiator());
        Flower flower = new Flower();
        flower.setName("Kaktus");
        flower.setMinTemperature(10.0);
        Flower flower1 = new Flower();
        flower1.setName("Roza");
        flower1.setMinTemperature(15.0);
        Flower flower2 = new Flower();
        flower2.setName("Kwiatek");
        flower2.setMinTemperature(20.0);
        List<Flower> flowers = Arrays.asList(flower, flower1, flower2);
        room.setFlowers(flowers);
        //when
        assertThrows(Exception.class, () -> room.setTemperature(12.0), "Cant change temperature. Roza will die");
    }
}