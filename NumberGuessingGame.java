import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        do {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            
            System.out.println("Round " + (rounds + 1) + ":");
            System.out.println("I've selected a number between " + lowerBound + " and " + upperBound + ". Guess it!");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Your guess is out of range. Try again.");
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                    score++;
                    break;
                }
            }
            
            if (attempts >= maxAttempts) {
                System.out.println("You've run out of attempts. The correct number was " + targetNumber + ".");
            }
            
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            
            if (playAgain.equals("no")) {
                break;
            }
            
            rounds++;
        } while (true);
        
        System.out.println("Game Over!");
        System.out.println("Rounds played: " + (rounds + 1));
        System.out.println("Score: " + score);
        
        scanner.close();
    }
}