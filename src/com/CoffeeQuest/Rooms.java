package com.CoffeeQuest;

import java.util.List;

public abstract class Rooms
{
    // Name of the room
    private String name;

    // A list of items in the room
    private List<?> items;

    // Description given to player of the room
    private String description;

    /**
     * gets the name of the room
     * @return the name of the room
     */
    abstract String getName();

    /**
     * gets the list of items in the room
     * @return the list of items
     */
    abstract List<?> getItems();

    /**
     * gets the description of the room
     * @return the description
     */
    abstract String getDescription();

    /**
     * Event after the player successfully completes the room challenge
     */
    abstract void completeRoomChallenge();

    /**
     * Event after the player fails the room challenge
     */
    abstract void failRoomChallenge();
}
