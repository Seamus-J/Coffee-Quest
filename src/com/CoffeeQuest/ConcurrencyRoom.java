package com.CoffeeQuest;

import java.util.List;

public class ConcurrencyRoom extends Rooms
{
    public ConcurrencyRoom(){

    };

    // Name of the room
    private String name = "Concurrency Room";

    // A list of items in the room
    private List<?> items;

    // Description given to player of the room
    private String description = "The lights are flickering on and off and there is a loud humming noise that" +
            " seems to pulsing on and off. You see two generators that seem to be trying to run at the same" +
            " time, but there doesn't seem to be enough power to keep them both going at once. How can I " +
            "keep these lights?";

    @Override
    /**
     * gets the name of the room
     * @return the name of the room
     */
    public String getName(){
        return this.name;
    }

    @Override
    /**
     * gets the list of items in the room
     * @return the list of items
     */
    public List<?> getItems(){
        return this.items;
    }

    @Override
    /**
     * gets the description of the room
     * @return the description
     */
    public String getDescription(){
        return this.description;
    }
}
