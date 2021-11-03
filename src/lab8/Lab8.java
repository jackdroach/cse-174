package lab8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Author: Jack Roach
 * Date: Oct 15, 2021
 * Section: I
 * Lab8.java
 * A program that gets an int value from the user and generates an output.
 */
public class Lab8 {
    public static void main(String[] args) {
        // Init. scanner for reading console input.
        Scanner keyboardReader = new Scanner(System.in);

        // String used to repeat the entire program.
        String repeat;

        do {
            // Variables for getting an int from the user.
            boolean intLoop = true;
            int input = 0;

            // Get an int from the user.
            while (intLoop) {
                try {
                    System.out.print("Enter an int number: ");
                    input = keyboardReader.nextInt();

                    // If an invalid int is entered throw illegal argument.
                    if (input <= 0) {
                        throw new IllegalArgumentException();
                    }

                // If an int was not entered then try again.
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input!");
                    keyboardReader.next();
                    continue;

                // Catch thrown illegal argument.
                } catch (IllegalArgumentException e) {
                    System.out.println("No result with an input less than or "
                        + "equal to zero!");
                } // End try/catch.

                // End while loop if the input passes the try/catch.
                intLoop = false;
            } // End while loop.


            // Count the number of rows.
            for (int i = 1; i <= input; i++) {

                // Count the number of columns.
                for (int j = 1; j <= input; j++) {

                    // Divide rows / columns and print the result.
                    if (i % j == 0) {
                        System.out.print("O");
                    } else {
                        System.out.print("X");
                    } // End if/else.

                }
                System.out.print("\n");
            } // End for loop.

            // Prompt the user to repeat the program.
            do {
                System.out.print("Do you want to repeat (y/n)? ");
                repeat = keyboardReader.next();

                // Repeat until y, Y, N or n is entered.
            } while (!repeat.equalsIgnoreCase("n")
                && !repeat.equalsIgnoreCase("y"));

            // Repeat the program if user input was y or Y.
        } while (repeat.equalsIgnoreCase("y"));

        // Print closing message.
        System.out.println("End");

    } // End method main.
} // End class Lab8.