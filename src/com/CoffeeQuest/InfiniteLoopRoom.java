package com.CoffeeQuest;

import java.util.List;

public class InfiniteLoopRoom extends Rooms
{
    // Name of the room
    private String name = "Infinite Loop";

    // A list of items in the room
    private List<?> items;

    // Description given to player of the room
    private String description = "You enter the room, it is pitch black and dead silent. You let out a 'Hello?' " +
            "The room immediately starts to echo, and it doesn't fade away. What is in here?" +
            " Is this going to go on forever??";

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
