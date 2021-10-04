package com.CoffeeQuest;

import java.util.List;

public class InfiniteLoopRoom extends Rooms
{
    // Name of the room
    private final String name = "Infinite Loop";

    // A list of items in the room
    private List<Items> infiniteLoopItems;

    // Boolean to keep record of whether the player has completed to room
    private boolean complete = false;

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
    public List<Items> getItems(){
        return this.infiniteLoopItems;
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
     * gets the completion status of a room
     * @return the bool of the completion status of the room
     */
    public boolean getCompletion() {
        return this.complete;
    }

    @Override
    /**
     * changes the completion status of a room if the players finds the solution
     * @param b bool the completion status will be set to
     */
    void setCompletion(boolean b) {
        this.complete = b;
    }

    /**
     * Event after the player successfully completes the room challenge
     */
    void completeRoomChallenge() {
        // TODO How does the player complete this room's challenge
        //  what will happen when the player completes this room
    }

    /**
     * Event after the player fails the room challenge
     */
    void failRoomChallenge() {
        // TODO How does the player fail this challenge
        //  what will happen if the player fails
    }
    public List<Items> getInfiniteLoopItems() {
        return infiniteLoopItems;
    }

    public void setInfiniteLoopItems(List<Items> infiniteLoopItems) {
        this.infiniteLoopItems = infiniteLoopItems;
    }

}
