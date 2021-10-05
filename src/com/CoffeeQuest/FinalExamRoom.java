package com.CoffeeQuest;

import java.util.List;

public class FinalExamRoom extends Rooms
{
    // Name of the room
    private final String name = "Final Exam Room";

    // A list of items in the room
    private List<Items> finalExamRoomItems;

    // Boolean to keep record of whether the player has completed to room
    private boolean open = false;

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public List<Items> getItems(){
        return this.finalExamRoomItems;
    }

    @Override
    public String getDescription() {
        // Description given to player of the room
        if (this.open) {
            return "\nYou approach a giant set of stairs littered with skulls and bones from the unfortunate souls who were here before.\n" +
                    "There are flaming torches leading the way that light up the massive red door that awaits on top. It almost looks too heavy to open.\n" +
                    "You maneuver around the corpses, its like you can hear the whispers of the dead warning you, 'Save Yourself'\\n\" +\n" +
                    "It frightens you but you have escape some how. You continue until you approach the door. You give it a nudge but it doesn't budge.\n" +
                    "You put all of your force into, letting out a yell. Finally it starts to creak open.You step inside the room, and find that it is almost completely \nempty nearly pitch black" +
                    ". All you see is a desk in the middle \nof the room with a single light bulb hanging over it " +
                    "and the \nsilhouette of a man just beyond it. It feels ominous, what could this be? \n'I hope you" +
                    " studied.' the man says. \nIs this a test??\n";
        } else {
            return "\nYou approach a giant set of stairs littered with skulls and bones from the unfortunate souls who were here before.\n" +
                    "There are flaming torches leading the way that light up the massive red door that awaits on top. It almost looks too heavy to open.\n" +
                    "You maneuver around the corpses, its like you can hear the whispers of the dead warning you, 'Save Yourself'\\n\" +\n" +
                    "It frightens you but you have escape some how. You continue until you approach the door. You give it a nudge but it doesn't budge.\n" +
                    "You put all of your force into, but it seems to be locked. 'Maybe I should check the other rooms first.' You return to the main room\n";
        }
    }

    @Override
    public boolean GetCompletion() {
        return this.open;
    }

    @Override
    void IsCompletion(boolean b) {
        this.open = b;
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

    public List<Items> getFinalExamRoomItems() {
        return finalExamRoomItems;
    }

    public void setFinalExamRoomItems(List<Items> finalExamRoomItems) {
        this.finalExamRoomItems = finalExamRoomItems;
    }
}
