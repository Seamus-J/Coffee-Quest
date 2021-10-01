package com.CoffeeQuest;

import java.util.List;

public class MainRoom extends Rooms
{
    // Name of the room
    private final String name = "Main Room";

    // A list of items in the room
    private List<?> items;

    // Boolean to keep record of whether the player has completed to room
    private boolean complete = false;

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
     *
     * @param c ConcurrencyRoom
     * @param e ExceptionRoom
     * @param f FinalExamRoom
     * @param i InfiniteLoopRoom
     */
    public void completeRoomChallenge( ConcurrencyRoom c, ExceptionRoom e, FinalExamRoom f, InfiniteLoopRoom i) {

        // If all rooms complete, set main room completion to true and allow player to complete the game
        if (c.getCompletion() == true &&
        e.getCompletion() == true &&
        f.getCompletion() == true &&
        i.getCompletion() == true)
        {
            // Completion set to true
            this.setCompletion(true);

            // TODO Congratulation message on winning
        }
    }

    /**
     * Event after the player fails the room challenge
     */
    public void failRoomChallenge() {
        // TODO How does the player fail this challenge
        //  what will happen if the player fails
    }
}
