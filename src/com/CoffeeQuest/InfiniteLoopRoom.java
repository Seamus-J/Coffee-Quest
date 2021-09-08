package com.CoffeeQuest;

import java.util.List;

public class InfiniteLoopRoom extends Rooms
{
    // Name of the room
    private final String name = "Infinite Loop";

    // A list of items in the room
    private List<?> items;

    // Description given to player of the room
    private final String description = "You enter the room, it is pitch black and dead silent. You let out a 'Hello?' " +
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
