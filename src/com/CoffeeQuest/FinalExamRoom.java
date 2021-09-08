package com.CoffeeQuest;

import java.util.List;

public class FinalExamRoom extends Rooms
{
    // Name of the room
    private final String name = "Final Exam Room";

    // A list of items in the room
    private List<?> items;

    // Description given to player of the room
    private final String description = "You step inside the room, and find that it is almost completely empty nearly pitch black" +
            ". All you see is a desk in the middle of the room with a single light bulb hanging over it " +
            "and the silhouette of a man just beyond it. It feels ominous, what could this be? 'I hope you" +
            " studied.' the man says. Is this a test??";

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
