package com.CoffeeQuest;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    //Private variables
    private Rooms room;
    private ArrayList<Item> inventory;
    private Scanner input = new Scanner(System.in);
    private Commands cmds = new Commands(input);
    //Constructor
    public Player(Rooms room)
    {
        this.room = room;

        System.out.println("Welcome");
        while(true) {
            System.out.println("What do you want to do next?");
            System.out.print("> ");
            cmds.getCommands(input.nextLine());
        }
    }

    //Methods

    //Pick-up an item
    public void pickUp(Item item)
    {
        inventory.add(item);
    }

    //Drop an item
    public void drop(Item item)
    {
        inventory.remove(item);
    }

    //Get inventory
    public ArrayList<Item> getInventory()
    {
        return inventory;
    }

    //Set inventory
    public void setInventory(ArrayList<Item>inventory)
    {
        this.inventory = inventory;
    }

    //Return room player is currently in
    public Rooms GetRoom()
    {
        return room;
    }

    //Set the current room as the player's location
    public void setRoom(Rooms room)
    {
        this.room = room;
    }

    // TO DO: class for using items(to be designed based off of items)

    public void showItems()
    {
        System.out.println("Your inventory:");
        System.out.println();

        //Check to see if there are items in inventory
        if(inventory.size()==0)
        {
            System.out.println("There are no items in your inventory");
        }
        else
        {
            //Loop through entire inventory, listing each item
            for(int x=0; x<inventory.size(); x++)
            {
                System.out.println(inventory.get(x));
            }
        }
        //Print a blank line to create space for user entry
        System.out.println();
    }

}

