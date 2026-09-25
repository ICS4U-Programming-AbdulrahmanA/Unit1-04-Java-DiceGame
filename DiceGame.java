/*
 * The DiceGame program generates a random number from 1 to 6
 * and prompts the user to guess it, giving high/low feedback
 * and tracking guess count safely until correct.
 *
 * @author  Abdul
 * @version 1.0
 * @since   2026-09-25
 */

import java.util.Random;
import java.util.Scanner;

public final class DiceGame {

    /**
     * Private constructor to satisfy linter rule for utility classes.
     */
    private DiceGame() {
        // Prevent instantiation
    }

    /**
     * Main entry point of the program.
     *
     * @param args Command line arguments (unused).
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Random random = new Random();

        // Constants for die range
        final int minVal = 1;
        final int maxVal = 6;

        // Generate a random target number between 1 and 6 inclusive
        final int targetNumber = random.nextInt(maxVal - minVal + 1) + minVal;

        // Initializes user guess and guess target
        int guessCount = 0;
        int userGuess = 0;

        System.out.println("Welcome to the Dice Guessing Game!");

        // Loop until the correct number is guessed
        do {
            System.out.print("Guess a number between 1 and 6: ");
            final String inputString = scanner.nextLine();

            try {
                // Try to cast user input into an integer
                userGuess = Integer.parseInt(inputString);

                // Check if the guess is within the allowed range
                if (userGuess < minVal || userGuess > maxVal) {
                    System.out.println(
                        "Invalid input! Enter a number between 1 and 6."
                    );
                } else {
                    // Only increment count on valid attempts
                    guessCount++;

                    // Condition to check if user guess is under the target number
                    if (userGuess < targetNumber) {
                        System.out.println("Too low! Try again.");
                    // Condition to check if user guess is over the target number
                    } else if (userGuess > targetNumber) {
                        System.out.println("Too high! Try again.");
                    // Condition to check if user guess is correct
                    } else {
                        System.out.println(
                            "Correct! You guessed the right number!"
                        );
                    }
                }
            } catch (NumberFormatException e) {
                // Handle non-integer or decimal inputs to prevent crashes
                System.out.println(
                    "Invalid input! Please enter a valid whole number."
                );
            }

        } while (userGuess != targetNumber);

        // Display final score
        System.out.println(
            "It took you " + guessCount
            + " guess(es) to get the right answer."
        );

        scanner.close();
    }
}
