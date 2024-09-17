import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 10;   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalRounds = 0;
        int totalWins = 0;

        while (true) {
            int numberToGuess = random.nextInt(100) + 1; 
            int attemptsLeft = MAX_ATTEMPTS;
            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess the number between 1 and 100. You have " + MAX_ATTEMPTS + " attempts.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attemptsLeft--;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Attempts left: " + attemptsLeft);
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("Congratulations! You've guessed the number correctly.");
                    hasGuessedCorrectly = true;
                    totalWins++;
                    break;
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            totalRounds++;

            System.out.println("Would you like to play another round? (yes/no)");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Game over!");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Total rounds won: " + totalWins);
        System.out.println("Score: " + totalWins + " / " + totalRounds);

        scanner.close();
    }
}
