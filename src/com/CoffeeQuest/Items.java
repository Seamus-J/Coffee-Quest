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

    //TODO Depending on how we set up the rooms we can use a comparison to check item vs. room either here
    //or as part of the item itself. We'll figure it out as a group.

    //TODO The other option is to change this from an abstract to just a basic item class with variables to be called into the rooms. I'll have that commented out underneath this.
}

/*public class items {

    public String name;

    public String description;
}*/