package com.CoffeeQuest;

import java.util.List;

public class ConcurrencyRoom extends Rooms
{
    // Name of the room
    private final String name = "Concurrency Room";

    // A list of items in the room
    private List<?> items;

    // Description given to player of the room
    private final String description = "The lights are flickering on and off and there is a loud humming noise \nthat" +
            " seems to pulsing on and off. You see two generators that seem \nto be trying to run at the same" +
            " time, but there doesn't seem to be enough power to \nkeep them both going at once. How can I " +
            "keep these lights?\n";

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

    @Override
    /**
     * Event after the player successfully completes the room challenge
     */
    void completeRoomChallenge() {
        // TODO How does the player complete this room's challenge
        //  what will happen when the player completes this room
    }

    @Override
    /**
     * Event after the player fails the room challenge
     */
    void failRoomChallenge() {
        // TODO How does the player fail this challenge
        //  what will happen if the player fails
    }
}
