package com.CoffeeQuest;

public class Battery extends Items{
    private final String itemName = "Battery";
    private final String desc = "This could power an entire block of houses";

    @Override
    String getName() {return itemName;}

    @Override
    String getDescription() {return desc;}

    @Override
    public String toString() {
        return itemName  + ": " + desc;
    }
}

