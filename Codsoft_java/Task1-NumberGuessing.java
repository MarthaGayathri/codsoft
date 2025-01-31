import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundsWon = 0;
        int totalRounds = 0;

        while (true) {
            // Generate a random number between 1 and 100
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 3;

            System.out.println("Welcome to the Guessing Game!");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                try {
                    // Prompt the user for their guess
                    System.out.print("Enter your guess (1-100): ");
                    int userGuess = scanner.nextInt();

                    if (userGuess < 1 || userGuess > 100) {
                        System.out.println("Please enter a number between 1 and 100.");
                        continue;
                    }

                    attempts++;

                    // Compare the user's guess with the target number
                    if (userGuess == targetNumber) {
                        System.out.println("Congratulations You guessed the number in " + attempts + " attempts.");
                        guessedCorrectly = true;
                        break;
                    } else if (userGuess < targetNumber) {
                        System.out.println("Your guess is too low. Try again!");
                    } else {
                        System.out.println("Your guess is too high. Try again!");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // Clear invalid input
                }
            }

            // If all attempts are used up without guessing correctly
            if (!guessedCorrectly) {
                System.out.println("Sorry, you didn't guess the number. The correct answer was " + targetNumber + ".");
            }

            totalRounds++;
            if (guessedCorrectly) {
                roundsWon++;
            }

            // Display current score
            System.out.println("\nCurrent Score: " + roundsWon + " wins out of " + totalRounds + " rounds.");

            // Ask if they want to play again
            while (true) {
                System.out.print("\nDo you want to play another round? (yes/no): ");
                String playAgain = scanner.next().toLowerCase();

                if (playAgain.equals("yes")) {
                    break;
                } else if (playAgain.equals("no")) {
                    return;
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }
        }
    }
}