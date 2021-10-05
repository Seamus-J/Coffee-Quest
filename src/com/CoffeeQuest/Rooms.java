package com.CoffeeQuest;

import java.util.List;

public abstract class Rooms
{
    /**
     * gets the name of the room
     * @return the name of the room
     */
    abstract String getName();

    /**
     * gets the list of items in the room
     * @return the list of items
     */
    abstract List<Items> getItems();


    /**
     * gets the description of the room
     * @return the description
     */
    abstract String getDescription();

    /**
     * gets the completion status of a room
     * @return the bool of the completion status of the room
     */
    abstract boolean GetCompletion();

    /**
     * changes the completion status of a room if the players finds the solution
     * @param b bool the completion status will be set to
     */
    abstract void IsCompletion(boolean b);
}
