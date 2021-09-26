package com.CoffeeQuest;

import java.util.Scanner;

public class CoffeeQuest {
    ConcurrencyRoom concurrencyRoom = new ConcurrencyRoom();
    ExceptionRoom exceptionRoom = new ExceptionRoom();
    FinalExamRoom finalExamRoom = new FinalExamRoom();
    InfiniteLoopRoom infiniteLoopRoom = new InfiniteLoopRoom();
    MainRoom mainRoom = new MainRoom();
    Player player = new Player(mainRoom);
}
