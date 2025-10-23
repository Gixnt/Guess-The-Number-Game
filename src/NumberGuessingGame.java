import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        Random randomnumber = new Random();
        Scanner scanner = new Scanner(System.in);

        int numbertoGuess = randomnumber.nextInt(100) + 1;

        String difficulty = "";

        while (true) {
            System.out.println("Choose the following difficulty: easy, medium, or hard ");
            difficulty = scanner.nextLine().toLowerCase();
            if (difficulty.equals("easy") || difficulty.equals("medium") || difficulty.equals("hard")) {
                System.out.println("You have chosen: " + difficulty);
                break;
            } else {
                System.out.println("Invalid choice. Please enter 'easy' or 'medium' or 'hard'");
            }
        }

        int maxAttempts = switch (difficulty) {
            case "easy" -> 10;
            case "medium" -> 5;
            case "hard" -> 3;
            default -> 8;
        };
        System.out.println("The number of attempts you have is: " + maxAttempts + "\n");
        System.out.println("Let's start the game!");

        int attemptsUsed = 0;

        while (attemptsUsed < maxAttempts) {
            System.out.println("Enter a guess: ");
            String input = scanner.nextLine();
            int GuessTheNumber;

            try {
                GuessTheNumber = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("You have entered '" + input + "' That's not a number. Please enter a number.");
                continue;
            }

            if (GuessTheNumber < 1 || GuessTheNumber > 100) {
                System.out.println("The number you have chosen is either below or above the range.");
                continue;
            }
            attemptsUsed++;

            if (GuessTheNumber == numbertoGuess) {
                System.out.println("CONGRATULATIONS!!! You have guessed the correct number which is " + numbertoGuess);
                break;
            }
            else if(GuessTheNumber < numbertoGuess){
                System.out.println("Incorrect! The number is greater than " + GuessTheNumber);
            }
            else {
                System.out.println("Incorrect! The number is lower than " + GuessTheNumber);
            }
            int attemptsLeft = maxAttempts - attemptsUsed;

            if(attemptsLeft > 0) {
                System.out.println("You have " + attemptsLeft + " attempts left");
            }
            else{
                System.out.println("GAME OVER! The number was " + numbertoGuess);
            }



        }


    }
}
