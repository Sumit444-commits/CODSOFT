package myPackage;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    Random rm = new Random();
    Scanner sc = new Scanner(System.in);
    int guess_num;
    int ram_num;
    int total_chances = 1;
    int totalMatches = 0;
    int totalMatchesWon = 0;

    public void guessNumber() {
        ram_num = rm.nextInt(1000);
        System.out.println("Guess the number in between (0-100) ");
        System.out.println("Total Number of Chances 5");
        int limit = 5;
        do {
            if (limit == 0) {
                System.out.println("You lose");
                break;
            }

            guess_num = sc.nextInt();
            if (guess_num == ram_num) {
                System.out.println("Correct answer");
                System.out.println("You won after " + total_chances + " chances");
                totalMatchesWon += 1;
            } else if (ram_num > guess_num) {
                System.out.println("Guess a big number");
                total_chances += 1;
            } else if (ram_num < guess_num) {
                System.out.println("Guess a small number");
                total_chances += 1;
            }
            limit -= 1;
            System.out.println("You have " + limit + " more chances left");
        } while (guess_num != ram_num);
    }

    public void play() {
        String user = "No";

        do {
            totalMatches += 1;
            guessNumber();
            System.out.println("\nWant to Play Again (Yes/No)");
            user = sc.next();
        } while (user.equalsIgnoreCase("Yes"));
        System.out.println("\nTotal Matches Played : "+totalMatches);
        System.out.println("Total Matches won "+totalMatchesWon);
    }

}

