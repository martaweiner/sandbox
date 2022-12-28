package com.nazwisko.imie.test;

import lombok.Data;

import java.util.List;

@Data
public class Apartment {
    private Room kitchen;
    private Room bathroom;
    private Room bedroom;

    public Double apartmentArea(){
        return kitchen.getArea()+ bathroom.getArea()+ bedroom.getArea();
    }

    public void moveFlowers(Room from, Room to){
        List<Flower> fromRoomFlowers = from.getFlowers();
        List<Flower> toRoomFlowers = to.getFlowers();
        toRoomFlowers.addAll(fromRoomFlowers);
        fromRoomFlowers.clear();
    }
}
