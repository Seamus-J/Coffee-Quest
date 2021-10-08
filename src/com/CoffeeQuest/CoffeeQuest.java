package com.CoffeeQuest;

/** Represents the game Coffee Quest.
 * @author Seamus Johnson
 * @since 1.0
 */
public class CoffeeQuest {
    public static ConcurrencyRoom concurrencyRoom = new ConcurrencyRoom();
    public static  ExceptionRoom exceptionRoom = new ExceptionRoom();
    public static FinalExamRoom finalExamRoom = new FinalExamRoom();
    public static InfiniteLoopRoom infiniteLoopRoom = new InfiniteLoopRoom();
    public static MainRoom mainRoom = new MainRoom();
    public static NPC npc = new NPC();
    Player player = new Player(mainRoom);

    public CoffeeQuest() throws IncorrectFileNameException {
    }
}
