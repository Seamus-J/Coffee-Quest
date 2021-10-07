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
    private final String description = "\nYou look around, dazed and confused. The room is damp and dim.\n" +
            "'Where am I?' You take a look around and see 4 different pathways around you each in a different direction.\n" +
            "One to the north, one to the east, one to the south, and one to the west.\n" +
            "'I have to get out of here, where should I go first?'\n";

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
