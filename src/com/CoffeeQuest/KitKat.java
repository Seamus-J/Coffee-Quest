package com.CoffeeQuest;

public class KitKat extends Items{
    private final String itemName = "KitKat";
    private final String desc = "Give me a BREAK of that KitKat bar";

    @Override
    String getName() {return itemName;}

    @Override
    String getDescription() {return desc;}

    @Override
    public String toString() {
        return itemName  + ": " + desc;
    }
}
