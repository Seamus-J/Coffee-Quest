package com.CoffeeQuest;

public class Flashlight extends Items{
    private final String itemName = "flashlight";
    private final String desc = "This flashlight can be used to give visibility in dark areas.";

    @Override
    String getName() {return itemName;}

    @Override
    String getDescription() {return desc;}

    @Override
    public String toString() {
        return itemName  + ": " + desc;
    }
}
