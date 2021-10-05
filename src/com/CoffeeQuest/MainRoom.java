package com.CoffeeQuest;

import java.util.List;

public class MainRoom extends Rooms
{
    // Name of the room
    private final String name = "Main Room";

    // A list of items in the room
    private List<Items> mainRoomItems;

    // Boolean to keep record of whether the player has completed to room
    private boolean complete = false;

    // Description given to player of the room
    private final String description = "The lights are flickering on and off and there is a loud humming noise \nthat" +
            " seems to pulsing on and off. You see two generators that seem \nto be trying to run at the same" +
            " time, but there doesn't seem to be enough power to \nkeep them both going at once. How can I " +
            "keep these lights?\n";

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public List<Items> getItems(){
        return this.mainRoomItems;
    }

    @Override
    public String getDescription(){
        return this.description;
    }

    @Override
    public boolean GetCompletion() {
        return this.complete;
    }

    @Override
    void IsCompletion(boolean b) {
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
        if (c.GetCompletion() &&
                e.GetCompletion() &&
                f.GetCompletion() &&
                i.GetCompletion())
        {
            // Completion set to true
            this.IsCompletion(true);

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

    public List<Items> getMainRoomItems() {
        return mainRoomItems;
    }

    public void setMainRoomItems(List<Items> mainRoomItems) {
        this.mainRoomItems = mainRoomItems;
    }
}
