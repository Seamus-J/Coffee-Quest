package com.CoffeeQuest;

import java.util.List;

public class ExceptionRoom extends Rooms
{
    // Name of the room
    private String name = "Exception Room";

    // A list of items in the room
    private List<?> items;

    // Description given to player of the room
    private String description = "As you step into the room, you hear a crunch under your feet. " +
            "What was that? You look down only to see bugs crawling all over you feet! 'AHHH' You shake them" +
            "off and try to run out of the door, but the door has locked behind you. 'How do I get out of here?!'" +
            "There has to be a way to fix this bug problem.";

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
