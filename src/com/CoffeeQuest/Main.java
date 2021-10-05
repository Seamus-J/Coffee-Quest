package com.CoffeeQuest;

import java.util.Scanner;

public class Main {
    public static CoffeeQuest cfq = new CoffeeQuest();

    public static void main(String[] args)
	{
        // Intro
        System.out.println("\n\nWelcome to Coffee Quest! The text-based adventure game that leads you through trials and tribulations\n" +
                "that you have to overcome in order to escape the perilous dungeons of the Java Master.\n");

        // Start game option
        //cfq.player.start();

        // Take player input
        cfq.player.input();
    }
}
