package com.nazwisko.imie.test;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {
    private List<Flower> flowers;
    private Double area;
    private String owner;
    private Radiator radiator;

    public void setTemperature(Double temp) throws Exception {
        if (flowers != null) {
            for (int i = 0; i < flowers.size(); i++) {
                if (flowers.get(i).getMinTemperature() < temp) {
                    throw new Exception("Flower " + flowers.get(i).getName() + " will die");
                }
            }
        }
        radiator.setTemperature(temp);
    }

    public List<String> getFlowersNames() {
        List<String> flowersNames = new ArrayList<>();
        for (Flower flower : flowers) {
            String name = flower.getName();
            flowersNames.add(name);
        }
        return flowersNames;
    }

    public String roomDescription() throws Exception {
        if (owner == null || owner.equals("")) {
            throw new Exception("Room has no owner");
        }
        return "In " + owner + " room theres " + flowers.size() + " flowers";
    }

    public void throwOldFlowers(Integer days) {
        List<Flower> flowerList = new ArrayList<>();
        for (Flower flower : flowers) {
            if (flower.getAgeInDays() < days) {
                flowerList.add(flower);
            }
        }
        this.flowers = flowerList;
    }

    public void throwFlowers() {
        flowers.clear();
    }

    public boolean canFitRoom() {
        return area * 2 > flowers.size();
    }

}
