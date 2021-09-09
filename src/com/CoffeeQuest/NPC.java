package com.CoffeeQuest;


import java.io.Console;
import java.util.*;

//Npc Version 1
public class NPC
{

        Scanner scanner = new Scanner(System.in);

        //list of possible questions, needs to b expanded with real questions

        List<String> Questions = new ArrayList<>();
        Questions.add("What is one");
        Questions.add("What is two");
        Questions.add("What is three");
        Questions.add("What is four");


        //list of corresponding answers
        List<String> Answers = new ArrayList<>();
        Answers.add("1");
        Answers.add("2");
        Answers.add("3");
        Answers.add("4");

        //randomly selected question numbers
        int q1, q2, q3;

        //total number of incorrect answers given
        int incorrectAnswers = 0;

        int firstAttempt = 0;

        //Greet Player
        public void GreetPlayer()
        {
            //greet player
            if (firstAttempt == 0) {
                System.out.println("QuizMaster: Hello adventurer, I' am the QuizMaster and to escape this dungeon you must answer these three questions of mine! Know that while you may try to answer a question again if you give an incorrect answer," +
                        "you will only be allowed three incorrect answers between the three questions before you fail, and that if you fail this quiz you will not pass out of this dungeon. If you are ready to begin, then telling me a" +
                        "simple yes shall suffice. If at any point you wish to concede, simply say quit.");
            } else {
                System.out.println("QuizMaster: So you have returned? Are you prepared to try again? If so say yes.");
            }

            //get user response
            String reply1 = scanner.nextLine();

            //check what the user responded with, a yes starts the quiz
            if (reply1.toLowerCase() == "yes") {
                //Determine random questions
                SetupQuestions();
                //start questioning
                AskPlayerQuestion1();
            }
            //if the player enters something other than yes then this comes up
            else {
                System.out.println("QuizMaster: I' am not sure what you mean by " + reply1 + ". If you do wish to take my quiz then talk with me some more, otherwise I ask that you depart my chamber.");
            }
        }

        //randomly determines which questions will be asked
        public void SetupQuestions ()
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

        //Ask Player Question1
        public void AskPlayerQuestion1 ()
        {
            //prints the first question
            System.out.println("QuizMaster: Here is my first question for you, try to pass it if you dare." + Questions.get(q1));


            //get user response
            String answer1 = scanner.nextLine();
            //if the user response is correct
            if (answer1.toLowerCase() == Answers.get(q1)) {
                System.out.println("QuizMaster: You have answered my first question correctly, though I imagine was purely through luck. My next question will not be so easy.");
                AskPlayerQuestion2();
            }
            //if the player chooses to quit
            else if (answer1.toLowerCase() == "quit") {
                quitQuiz();
            }
            //if the user answer incorrectly for the first time
            else if (incorrectAnswers == 0) {
                System.out.println("QuizMaster: Your first wrong answer! Give it another shot.");
                incorrectAnswers++;
            }
            //second incorrect user response
            else if (incorrectAnswers == 1) {
                System.out.println("QuizMasterAnother wrong answer! That makes 2 of 3! This will over soon enough, but you are welcome to try again.");
                incorrectAnswers++;
            }
            //Third incorrect response results in quiz failure
            else {
                quizFailure();
            }

        }

        //Ask Player Question2
        public void AskPlayerQuestion2 ()
        {
            //prints the second question
            System.out.println(Questions.get(q2));

            //get user response
            String answer2 = scanner.nextLine();
            //if the user response is correct
            if (answer2.toLowerCase() == Answers.get(q2)) {
                System.out.println("QuizMaster: You have done well in my quiz up to now. Yes you have gotten the second question right, but in truth I have been going easy on you so far, " +
                        "but surely you shall fail now that I no longer do so.");
                AskPlayerQuestion3();
            }
            //if the player chooses to quit
            else if (answer2.toLowerCase() == "quit") {
                quitQuiz();
            }
            //if the user answer incorrectly for the first time
            else if (incorrectAnswers == 0) {
                System.out.println("QuizMaster: Your first wrong answer! Give it another shot.");
                incorrectAnswers++;
            }
            //second incorrect user response
            else if (incorrectAnswers == 1) {
                System.out.println("QuizMaster: Another wrong answer! That makes 2 of 3! This will over soon enough, but you are welcome to try again.");
                incorrectAnswers++;
            }
            //Third incorrect response results in quiz failure
            else {
                quizFailure();
            }
        }

        //Ask Player Question3
        public void AskPlayerQuestion3 ()
        {
            //prints the third question
            System.out.println(Questions.get(q3));

            //get user response
            String answer3 = scanner.nextLine();
            //if the user response is correct
            if (answer3.toLowerCase() == Answers.get(q3)) {
                System.out.println("QuizMaster: How have you done this? Up to now no one has been able to answer all three of my questions. However you may have passed my quiz, I 'am forced to allow you passage out of this dungeon.");
                quizPass();
            }
            //if the player chooses to quit
            else if (answer3.toLowerCase() == "quit") {
                quitQuiz();
            }
            //if the user answer incorrectly for the first time
            else if (incorrectAnswers == 0) {
                System.out.println("QuizMaster: Your first wrong answer! Give it another shot.");
                incorrectAnswers++;
            }
            //second incorrect user response
            else if (incorrectAnswers == 1) {
                System.out.println("QuizMaster: Another wrong answer! That makes 2 of 3! This will over soon enough, but you are welcome to try again.");
                incorrectAnswers++;
            }
            //Third incorrect response results in quiz failure
            else {
                quizFailure();
            }
        }

        //called when the player answer incorrectly for the third time
        public void quizFailure()
        {
            System.out.println("QuizMaster: You have failed my quiz, as has everyone before you. If you wish to try again then you may ask me");
        }

        //A method that allows the player an out if they no longer want to do the quiz, or to complete another section of the game first
        public void quitQuiz ()
        {
            System.out.println("QuizMaster: So you have chosen to quit my quiz? It is probably for the best, as you would not have passed it any way. Still if you wish to try again you can seek me out here.");
        }

        //this method is called when the player has successfully completed the quiz
        public void quizPass ()
        {
            //I' am unsure how the game should from this point, needs some work//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        }

}
