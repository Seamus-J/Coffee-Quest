package com.CoffeeQuest;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	Commands cmds = new Commands(input);
	System.out.println("Welcome");
		while(true) {
			System.out.println("What do you want to do next?");
			System.out.print("> ");
			cmds.getCommands(input.nextLine());
		}
    }
}
