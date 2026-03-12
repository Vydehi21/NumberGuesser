package com.monocept.NumberGuesser;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesserGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String playAgain;

        do {
            int number = rand.nextInt(100) + 1;   // random 1-100
            int guess=0;
            int attempts = 0;
            int maxAttempts = 5;

          
            System.out.println("Maximum possible attempts -> " + maxAttempts);

            while (attempts < maxAttempts) {
                System.out.print("Guess a number(1-100) ");
                
                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter an integer.");
                    sc.next(); // remove invalid input
                    continue;
                }
                
                guess = sc.nextInt();
                
                if (guess <= 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                }
                
                attempts++;

                if (guess < number) {
                    System.out.println("Sorry too low");
                } 
                else if (guess > number) {
                    System.out.println("Sorry too high");
                } 
                else {
                    System.out.println("You won: in attempt: " + attempts);
                    break;
                }

                if (attempts == maxAttempts) {
                    System.out.println("You lost! Number was: " + number);
                }
            }

            while (true) {

                System.out.print("\nDo you want to play again? (yes/no): ");
                playAgain = sc.next().toLowerCase();

                if (playAgain.equals("yes") || playAgain.equals("y") ||
                    playAgain.equals("no") || playAgain.equals("n")) {
                    break;
                } else {
                    System.out.println("Invalid input! Please enter YES or NO.");
                }
            }

        } while (playAgain.equals("yes")|| playAgain.equals("y"));

        System.out.println("Game exited. Thank you for playing!");
        sc.close();
    }
}
