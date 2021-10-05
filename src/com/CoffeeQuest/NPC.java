package com.CoffeeQuest;


import java.io.Console;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Supplier;

/**
 *
 * Class implements the methods and fields for NPC interaction in the finalexam room. All interactions are work in progress, and are likely to be reworked/restyled.
 *
 * @author James Heminger
 */
//Npc Version 1
public class NPC
{
    Scanner scanner = new Scanner(System.in);
    FinalExamRoom examRoom = new FinalExamRoom();

    //list of possible questions, needs to b expanded with real questions
    List<String> Questions = new ArrayList<>();
    //list of corresponding answers
    List<String> Answers = new ArrayList<>();
    //randomly selected question numbers
    int q1, q2, q3;
    //total number of incorrect answers given
    int incorrectAnswers = 0;
    //checks if this is the first attempt, effects dialog
    int firstAttempt = 0;



 /*
 Should be added to main method in main class //////////////////////////////////////////////////// example idea
     //add in questions
     Questions.add("What is one");
     Questions.add("What is two");
     Questions.add("What is three");
     Questions.add("What is four");
    //add in answers
     Answers.add("1");
     Answers.add("2");
     Answers.add("3");
     Answers.add("4");
 */


    /**
     *
     * The GreetPlayer() method is used in the current version of the NPC class as a way of allowing the player to choose if they want to start the quiz when they talk to the npc.
     * It asks the player to respond with yes if they wish to begin the quiz, but does not recognize any other commands/input. This still needs to be tested to see how it works with the commands
     * class.
     */
     //Greet Player
     public void GreetPlayer()
     {
         //greet player
         if (firstAttempt == 0) {
             System.out.println("Silhouetted Man: 'Confused? Didn't you remember you that you had a quiz today? Well, don't worry about it. It's really just three short answers that you can even try to answer a second time if you get them wrong." +
                     "You should already know that if you give three incorrect answers between the three questions you will fail the quiz, and that if you want to leave the dungeon you must pass this quiz." +
                     "Of course you knew all of that already, after all you did study right? If you are ready to begin, then telling me a simple yes shall suffice. If there is anything else you need to do before" +
                     "starting this quiz I suggest you go do it now.'");

             firstAttempt = 1;
         } else {
             System.out.println("Silhouetted Man: 'Ah, good you back? Are you prepared to start the quiz now? If so, say yes.;");
         }

         //get user response
         String reply1 = scanner.nextLine();

         //check what the user responded with, a yes starts the quiz
         if (reply1.toLowerCase() == "yes") {
             //Determine random questions
             SetupQuestions();


             //Potential way to set a 'Due Date' for the quiz, this gets the localdatetime and sets the due date a minute after it
             Supplier<LocalDateTime> s = LocalDateTime::now;
             LocalDateTime dueDate = s.get().plusMinutes(1);
             //Formating it into a more readable format
             DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
             //displaying duedate to user
             System.out.println("The quiz due date is " +  dueDate.format(formatTime));
             //start questioning
             AskPlayerQuestion1();
         }
         //if the player enters something other than yes then this comes up
         else {
             System.out.println("Silhouetted Man: 'What do you mean by" + reply1 + "? If you want to start the quiz just say yes, otherwise go do whatever it is you need to do elsewhere.'");
         }
     }

    /**
     *
     * the SetupQuestions() method sets up which questions will be used on the quiz by using random number generation to pick questions and corresponding answers from a list.
     * While loops are used to check if the question has already been picked, and to reset it with another question if so.
     */
    //randomly determines which questions will be asked
     public void SetupQuestions()
     {
         //new random number generator
         Random rad = new Random();
         //determine first question number
         q1 = rad.nextInt(Questions.size());
         q2 = rad.nextInt(Questions.size());
         //check if the question was already taken, and loop through if needed
         while (q1 == q2) {
             q2 = rad.nextInt(Questions.size());
         }
         q3 = rad.nextInt(Questions.size());
         //check if the question was already taken, and loop through if needed
         while (q3 == q1 || q3 == q2) {
             q2 = rad.nextInt(Questions.size());
         }
     }

    /**
     *
     * Each AskPlayerQuestion#() method works the same, and I am considering working them into one combined method in future versions of the NPC class.
     * It prints the first question that was selected in the SetupQuestions() method, and uses a scanner to get the user response. It checks the response to see
     * if it matches, this is not setup to be very forgiving, and some work needs to be put into improving its recognition of answers. It also checks to see if the user chosses to quit
     * the quiz, and calls the quitQuiz() method in that case. Finally, if the answer is wrong it checks the number of previous wrong answers, and gives an appropriate response to the number.
     */

    //Ask Player Question1
     public void AskPlayerQuestion1()
     {
         //prints the first question
         System.out.println("Silhouetted Man: 'Here is the first question.'" + Questions.get(q1));

         //get user response
         String answer1 = scanner.nextLine();
         //if the user response is correct
         if (answer1.toLowerCase() == Answers.get(q1)) {
             System.out.println("Silhouetted Man: 'Good answer, you might actually have a slight chance to escape.'");
             AskPlayerQuestion2();
         }

         //if the user answer incorrectly for the first time
         else if (incorrectAnswers == 0) {
             System.out.println("Silhouetted Man: 'That was your first wrong answer! You should give it another shot.'");
             incorrectAnswers++;
         }
         //second incorrect user response
         else if (incorrectAnswers == 1) {
             System.out.println("Silhouetted Man: 'That was another wrong answer! That makes 2 of your limit of 3!' ");
             incorrectAnswers++;
         }
         //Third incorrect response results in quiz failure
         else {
             quizFailure();
         }

     }

    /**
     *
     * essentially the same as AskPlayerQuestion1()
     */
    //Ask Player Question2
     public void AskPlayerQuestion2()
     {
         //prints the second question
         System.out.println("Silhouetted Man: 'On too the second question then.' " + Questions.get(q2));

         //get user response
         String answer2 = scanner.nextLine();
         //if the user response is correct
         if (answer2.toLowerCase() == Answers.get(q2)) {
             System.out.println("Silhouetted Man: 'Another good answer. Maybe I will finally get to see what happens when somebody passes this quiz.'");

             AskPlayerQuestion3();
         }
         //if the user answer incorrectly for the first time
         else if (incorrectAnswers == 0) {
             System.out.println("Silhouetted Man: 'That was your first wrong answer! You should give it another shot.'");
             incorrectAnswers++;
         }
         //second incorrect user response
         else if (incorrectAnswers == 1) {
             System.out.println("Silhouetted Man: 'That was another wrong answer! That makes 2 of your limit of 3! '");
             incorrectAnswers++;
         }
         //Third incorrect response results in quiz failure
         else {
             quizFailure();
         }
     }

    /**
     *
     * essentially the same as AskPlayerQuestion1(), accept that correctly answering in this method also calls the quizPass() method
     */
     //Ask Player Question3
     public void AskPlayerQuestion3()
     {
         //prints the third question
         System.out.println("Silhouetted Man: 'Here's the final question, In hope your ready for it." + Questions.get(q3) + "'");

         //get user response
         String answer3 = scanner.nextLine();
         //if the user response is correct
         if (answer3.toLowerCase() == Answers.get(q3)) {
             System.out.println("Silhouetted Man: 'Well this is a first, three correct answers. '");
             quizPass();
         }
         //if the user answer incorrectly for the first time
         else if (incorrectAnswers == 0) {
             System.out.println("Silhouetted Man: 'That was your first wrong answer! You should give it another shot.'");
             incorrectAnswers++;
         }
         //second incorrect user response
         else if (incorrectAnswers == 1) {
             System.out.println("Silhouetted Man: 'That was another wrong answer! That makes 2 of your limit of 3! '");
             incorrectAnswers++;
         }
         //Third incorrect response results in quiz failure
         else {
             quizFailure();
         }
     }

    /**
     *
     * This method is called when a third wrong answer is detected, and displays a failure message
     */
    //called when the player answer incorrectly for the third time
     public void quizFailure()
     {
         System.out.println("Silhouetted Man: 'That's unfortunate. You have just given your third and final wrong answer, and have failed the quiz.");
         examRoom.IsCompletion(false);
     }


    /**
     *
     * This method will set the FinalExamRoom.setCompletion value to true when called
     */
    //this method is called when the player has successfully completed the quiz
     public void quizPass()
     {
         examRoom.IsCompletion(true);
     }

}
