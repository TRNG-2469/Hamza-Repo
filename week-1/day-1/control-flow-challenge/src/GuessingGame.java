import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        int targetNumber = (int) (Math.random() * 50) + 1;
        int maxAttempts = 5;
        int attemptCount = 0;
        boolean hasGuessedCorrectly = false;
        Scanner scanner = new Scanner(System.in);
        while ((attemptCount < maxAttempts) && hasGuessedCorrectly == false){
            attemptCount += 1;
            System.out.println("Attempt" + "[" + attemptCount + "/5]" + " - Enter your guess: ");
            int userInput = scanner.nextInt();
            if (userInput > 50 || userInput < 1){
                System.out.println("Please input a number between 1 and 50");
                attemptCount -= 1;
                continue;
            }
            if (userInput > targetNumber){
                System.out.println("Too High!");
            }
            if (userInput < targetNumber){
                System.out.println("Too low!");
            }
            if (userInput == targetNumber){
                hasGuessedCorrectly = true;
                System.out.println("Correct! You guessed the correct number!");
                break;
            } else if (attemptCount == maxAttempts) {
                System.out.println("You've lost! The correct number was " + targetNumber);
            } else {
                System.out.println("Wrong guess! Please guess again");
            }
        }
        scanner.close();
    }
}
