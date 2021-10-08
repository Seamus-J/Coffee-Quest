package com.CoffeeQuest;

public abstract class Items {

    //Name of the Item
    private String name;

    //Description of the item
    private String description;

    // Method to pull the name of the item
    abstract String getName();

    //Method to pull the description of the item
    abstract String getDescription();

    //Method to pull the 'use item' description of the item
    abstract String useItemDescription();
}
