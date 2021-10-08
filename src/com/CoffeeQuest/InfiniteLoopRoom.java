package com.CoffeeQuest;

import java.util.List;

/** Represents the Infinite loop room.
 * @author Seamus Johnson
 * @since 1.0
 */
public class InfiniteLoopRoom extends Rooms
{
    // A list of items in the room
    private List<Items> infiniteLoopItems;

    // Boolean to tell if the player has used the flashlight to see
    private boolean dark = true;

    // Boolean to keep record of whether the player has completed to room
    private boolean complete = false;

    @Override
    public String getName(){
        // Name of the room
        return "Infinite Loop";
    }

    @Override
    public List<Items> getItems(){
        return this.infiniteLoopItems;
    }

    @Override
    public String getDescription(){
        // Description given to player of the room
        return "\nYou cautiously start to step forwards to the north down a long hallway that never seems to never end \n." +
                "You finally reach a metal door, it looks heavy but you attempt to push it open.\n"+
                "You enter the room, it is pitch black and dead silent. You let out a 'Hello?'\n" +
                "The room immediately starts to echo, and it doesn't fade away.\n" +
                "What is in here? Why won't the echo stop? Is this going to go on forever??     (West Room)\n";
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
     * Sets the rooms list of items
     * @param infiniteLoopItems list of items
     */
    public void setInfiniteLoopItems(List<Items> infiniteLoopItems) {
        this.infiniteLoopItems = infiniteLoopItems;
    }

    /**
     * Tells whether the room is lit up or not
     * @return whether the room is lit up or not
     */
    public boolean GetIsDark(){
        return this.dark;
    }

    /**
     * Sets the status of whether the player had lit up the room or not
     * @param b true if player has used a flashlight
     */
    public void IsDark(boolean b){
        this.dark = b;
    }
}
