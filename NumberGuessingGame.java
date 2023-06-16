import java.util.Scanner;

public class NumberGuessingGame {
    public static final int Initial_Value = 14;
    public static final int Last_Value = 9999;

    public static void main(String[] args) {
        int randomNumber = generateRandomNumber();
        playGame(randomNumber);
    }

    public static int generateRandomNumber() {
        return (int) (Math.random() * (Last_Value + 1));
    }

    public static void playGame(int randomNumber) {
        try (Scanner scanner = new Scanner(System.in)) {
            int Turns = 0;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("You have a maximum of 14 Turns to guess a number between 0 and 9999.");

            while (Turns < Initial_Value) {
                System.out.printf("Turn Number %d: ", Turns + 1);

                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    System.out.printf("Turn Number %d: ", Turns + 1);
                    scanner.next();
                }

                int guessedNumber = scanner.nextInt();

                if (guessedNumber == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + (Turns + 1) + " Turns.");
                    return;
                } else if (guessedNumber < randomNumber) {
                    System.out.println("The number is greater.");
                } else {
                    System.out.println("The number is smaller.");
                }

                Turns++;
            }
        }
        System.out.println("Sorry, all of the " + Initial_Value + " turns are gone.");
        System.out.println("The number was: " + randomNumber);
    }
}
