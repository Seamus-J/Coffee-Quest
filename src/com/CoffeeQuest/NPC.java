package com.CoffeeQuest;


import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Supplier;
import java.util.ArrayList;

/**
 *
 * Class implements the methods and fields for NPC interaction in the finalexam room. All interactions are work in progress, and are likely to be reworked/restyled.
 *
 * @author James Heminger
 */
//Npc Version 1
public class NPC {
    Scanner scanner = new Scanner(System.in);

    Timer timer = new Timer();

    //randomly selected question numbers
    int q1, q2, q3;
    //total number of incorrect answers given
    int incorrectAnswers = 0;

    //list of possible questions, needs to b expanded with real questions
    List<String> Questions = new ArrayList<>(3);
    //Questions.add("What is one");
    //list of corresponding answers
    List<String> Answers = new ArrayList<>(3);
    LocalDateTime dueDate;
    Supplier<LocalDateTime> s;
    Instant begin;
    // 5.1 example
    Calendar c = Calendar.getInstance(TimeZone.getTimeZone("CT"));

    /**
     * Constructor
     */
    public NPC() {
        //add in questions
        Questions.add("What Does this Output?: \n"+
                "\tstatic List<String> strings = new ArrayList<String>();\n" +
                "\t\tstatic String greet = \"Hello Dungeon.\";\n" +
                "\t\tstatic String halt = \"Who goes there?\";\n" +
                "\t\tstatic String look = \"Where am I?\";\n" +
                "\t\t\n" +
                "\t\tpublic static void main(String[] args)\n" +
                "\t\t{\n" +
                "\t\t\t\t\tstrings.add(look);\n" +
                "\t\t\t\t\tstrings.add(greet);\n" +
                "\t\t\t\t\tstrings.add(halt);\n" +
                "\t\t\t\t\tint i = 3;\n" +
                "\t\t\t\t\twhile( i < 3)\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\tstrings.set(0, strings.get(i-1));\n" +
                "\t\t\t\t\t\tstrings.remove(i-1);\n" +
                "\t\t\t\t\t\ti--;\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t\tSystem.out.println(strings.get(1));\n" +
                "\t\t}\n" +
                "Answers: \n" +
                "A.Hello Dungeon   B.Compile Error  C.Who goes there?  D.Where am I? ");
        Questions.add("Yes or No: Would this code segment work?: \n" +  "\"if(Reply.toLowerCase() == Answers.get(q1)){}\"'");
        Questions.add("Yes or No: Will this code compile?: \n" + "\"int i;  while(i < 10) {i++;}'");
        Questions.add("What Java class might I use if I wanted to display your Exam's dueDate? \n" +
                      "A.LocalDate  B.LocalTime  C.LocalDateTime  D.TemporalUnit");
        Questions.add("What is a correct syntax to output \"Hello World\" in Java?\n" +
                "A.System.out.println(\"Hello World\");  B.echo(\"Hello World\");  C.print(\"Hello World\");  D.Console.WriteLine(\"Hello World\");");
        Questions.add("Java is short for \"JavaScript\"" +
                "True or false");
        Questions.add("Which data type is used to create a variable that should store text?\n" +
                "A.Txt  B.string  C.String  D.myString");

        //add in answers
        Answers.add("a");
        Answers.add("no");
        //should be Reply.toLowerCase().equals(Answers.get(q1)
        Answers.add("no");
        //i isn't initialized
        Answers.add("c");
        Answers.add("a");
        Answers.add("false");
        Answers.add("c");
    }

    /**
     * The GreetPlayer() method is used in the current version of the NPC class as a way of allowing the player to choose if they want to start the quiz when they talk to the npc.
     * It asks the player to respond with yes if they wish to begin the quiz, but does not recognize any other commands/input. This still needs to be tested to see how it works with the commands
     * class.
     */
    //Greet Player
    public void GreetPlayer() throws IncorrectFileNameException {
        //Potential way to set a 'Due Date' for the quiz, this gets the localdatetime and sets the due date a minute after it
        //Supplier<LocalDateTime>
                s = LocalDateTime::now;
        //LocalDateTime + 1
        dueDate = s.get().plusMinutes(2);
        //Formating it into a more readable format
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Silhouetted Man: 'Confused? Didn't you remember you that you had a quiz today? Well, don't worry about it. It's really simple,just three short answers that you can even try to answer a second time if you get them wrong. \n" +
                "You should already know that of course, and also that if you give three incorrect answers between the three questions you will fail the quiz, and that failing the exam traps you in the dungeon forever. \n" +
                "Of course you knew all of that already, after all you did study right? I expect you should also know that the exam due date is " + dueDate.format(formatTime) + ", so you had best get to it.'\n");

        long delay = 120000L;
        timer.schedule(time, delay);
        begin = Instant.now();

        //Determine random questions
        SetupQuestions();

        //start questioning
        AskPlayerQuestion1();

    }

    /**
     * the SetupQuestions() method sets up which questions will be used on the quiz by using random number generation to pick questions and corresponding answers from a list.
     * While loops are used to check if the question has already been picked, and to reset it with another question if so.
     */
    //randomly determines which questions will be asked
    public void SetupQuestions() {
        //new random number generator
        Random rad = new Random();
        //determine first question number
        q1 = rad.nextInt(7);
        q2 = rad.nextInt(7);
        //check if the question was already taken, and loop through if needed
        while (q1 == q2) {
            q2 = rad.nextInt(7);
        }
        q3 = rad.nextInt(7);
        //check if the question was already taken, and loop through if needed
        while (q3 == q1 || q3 == q2) {
            q3 = rad.nextInt(7);
        }


    }

    /**
     * Each AskPlayerQuestion#() method works the same, and I' am considering working them into one combined method in future versions of the NPC class.
     * It prints the first question that was selected in the SetupQuestions() method, and uses a scanner to get the user response. It checks the response to see
     * if it matches, this is not setup to be very forgiving, and some work needs to be put into improving its recognition of answers. It also checks to see if the user chosses to quit
     * the quiz, and calls the quitQuiz() method in that case. Finally, if the answer is wrong it checks the number of previous wrong answers, and gives an approriate response to the number.
     */

    //Ask Player Question1
    public void AskPlayerQuestion1() throws IncorrectFileNameException {
        //prints the first question
        System.out.println("Silhouetted Man: 'Here is the first question. " + Questions.get(q1));
        System.out.println("What is your Answer:");

        //get user response
        String answer1 = scanner.nextLine();
        //if the user response is correct
        if (answer1.equalsIgnoreCase(Answers.get(q1))) {
            System.out.println("Silhouetted Man: 'Good answer, you might actually have a slight chance to escape.'");
            AskPlayerQuestion2();
        }

        //if the user answer incorrectly for the first time
        else if (incorrectAnswers == 0) {
            System.out.println("Silhouetted Man: 'That was your first wrong answer! You should give it another shot.'");
            incorrectAnswers++;
            AskPlayerQuestion1();
        }
        //second incorrect user response
        else if (incorrectAnswers == 1) {
            System.out.println("Silhouetted Man: 'That was another wrong answer! That makes 2 of your limit of 3!' ");
            incorrectAnswers++;
            AskPlayerQuestion1();
        }
        //Third incorrect response results in quiz failure
        else {
            quizFailure();
        }

    }

    /**
     * essentially the same as AskPlayerQuestion1()
     */
    //Ask Player Question2
    public void AskPlayerQuestion2() throws IncorrectFileNameException {
        //prints the second question
        System.out.println("Silhouetted Man: 'On too the second question then.\n" + Questions.get(q2));
        System.out.println("What is your Answer:");

        //get user response
        String answer2 = scanner.nextLine();
        //if the user response is correct
        if (answer2.equalsIgnoreCase(Answers.get(q2))) {
            System.out.println("Silhouetted Man: 'Another good answer. Maybe I will finally get to see what happens when somebody passes this quiz.'");

            AskPlayerQuestion3();
        }
        //if the user answer incorrectly for the first time
        else if (incorrectAnswers == 0) {
            System.out.println("Silhouetted Man: 'That was your first wrong answer! You should give it another shot.'");
            incorrectAnswers++;
            AskPlayerQuestion2();
        }
        //second incorrect user response
        else if (incorrectAnswers == 1) {
            System.out.println("Silhouetted Man: 'That was another wrong answer! That makes 2 of your limit of 3! '");
            incorrectAnswers++;
            AskPlayerQuestion2();
        }
        //Third incorrect response results in quiz failure
        else {
            quizFailure();
        }
    }

    /**
     * essentially the same as AskPlayerQuestion1(), accept that correctly answering in this method also calls the quizPass() method
     */
    //Ask Player Question3
    public void AskPlayerQuestion3() throws IncorrectFileNameException {
        //prints the third question
        System.out.println("Silhouetted Man: 'Here's the final question, I hope your ready for it.\n" + Questions.get(q3) + "'");
        System.out.println("What is your Answer:");

        //get user response
        String answer3 = scanner.nextLine();
        //if the user response is correct
        if (answer3.equalsIgnoreCase(Answers.get(q3))) {
           Instant end = Instant.now();
           long elapsed = 60 - Duration.between(begin, end).toSeconds();
            System.out.println("Silhouetted Man: 'Well this is a first, three correct answers. You have passed the Final Exam, with "+ elapsed + " seconds to go, As such you can now leave the dungeon.'");
            quizPass();
        }
        //if the user answer incorrectly for the first time
        else if (incorrectAnswers == 0) {
            System.out.println("Silhouetted Man: 'That was your first wrong answer! You should give it another shot.'");
            incorrectAnswers++;
            AskPlayerQuestion3();
        }
        //second incorrect user response
        else if (incorrectAnswers == 1) {
            System.out.println("Silhouetted Man: 'That was another wrong answer! That makes 2 of your limit of 3! '");
            incorrectAnswers++;
            AskPlayerQuestion3();
        }
        //Third incorrect response results in quiz failure
        else {
            quizFailure();
        }
    }

    /**
     * This method is called when a third wrong answer is detected, and displays a failure message
     */
    //called when the player answer incorrectly for the third time
    public void quizFailure() {
        System.out.println("Silhouetted Man: 'That's unfortunate. You have just given your third and final wrong answer, and have failed the quiz. \n" +
                "As such you will forever be stuck in this here dungeon, never to escape. Have fun!' ");
        System.out.println("/////GAME OVER/////");
        System.exit(0);

    }


    /**
     * This method will set the FinalExamRoom.setCompletion value to true when called
     */
    //this method is called when the player has successfully completed the quiz
    public void quizPass() throws IncorrectFileNameException {

        Scanner winMessage = null;
        File file = new File("Congrats");

        // 6.1, 6.2, 6.3, 6.4, 6.5, 8.1 examples
        try{
            winMessage = new Scanner(file);
            while (winMessage.hasNext()){
                System.out.println(winMessage.nextLine());
            }
            System.out.println(" Time of completion: " + c.getTime());
        }
         catch (FileNotFoundException e){
            if (Objects.equals(file.getName(), "Congrats")){
                assert winMessage == null : "Scanner is Null";
                throw new IncorrectFileNameException("Incorrect File Name", e);
            }
            e.printStackTrace();
        }finally {
            if (scanner != null){
                scanner.close();
            }
        }

        System.exit(0);
    }

  TimerTask time = new TimerTask() {
      @Override
      public void run() {
          System.out.println("Silhouetted Man: 'That's it, you are out of time! I would say better luck next time, but there won't be a next time.'");
          System.exit(0);
      }
  };



}
