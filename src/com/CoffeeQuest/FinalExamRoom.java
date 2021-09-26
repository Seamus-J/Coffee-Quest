package com.CoffeeQuest;

import java.util.List;

public class FinalExamRoom extends Rooms
{
    // Name of the room
    private final String name = "Final Exam Room";

    // A list of items in the room
    private List<?> items;

    // Boolean to keep record of whether the player has completed to room
    private boolean complete = false;

    // Description given to player of the room
    private final String description = "You step inside the room, and find that it is almost completely \nempty nearly pitch black" +
            ". All you see is a desk in the middle \nof the room with a single light bulb hanging over it " +
            "and the \nsilhouette of a man just beyond it. It feels ominous, what could this be? \n'I hope you" +
            " studied.' the man says. \nIs this a test??\n";

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
}
