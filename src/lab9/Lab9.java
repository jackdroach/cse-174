package lab9;

/*
* Author: Jack Roach
* Date: Oct 23, 2021
* Section: I
* File: Lab9.java
* Description: A program that gets a binary number(s) from the user and prints
* out the corresponding decimal number(s) in ascii character form.
 */

/**
 * Meisam Amjad.
 * Lab9.java
 * Practicing writing methods.
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class Lab9 {
    // main method
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option;

        do {
            menu();  // Displaying the menu
            try {
                option = in.nextInt();
            } catch (InputMismatchException err) {
                in.next();  // clearing the input
                option = 0; // picking zero as a value for the option
            }
            switch (option) {
                case 1:
                    System.out.printf("Enter a single binary code: ");
                    char letter = getLetter(in.next());
                    System.out.printf("The letter is: %s\n", letter);
                    break;
                case 2:
                    System.out.printf("Enter binary codes: ");
                    String word = getWord(in.next());
                    System.out.printf("The word is: %s\n", word);
                    break;
                case 3:
                    System.out.printf("End!\n");
                    break;
                default:
                    System.out.printf("Invalid Input!\n");
            }
        } while (option != 3);
    }

    /*
     * Prints a menu with options on the display.
     */
    private static void menu() {
        System.out.printf("\n**Binary Code Translator v 1.0**\n");
        System.out.printf("1. Translate a binary code into a letter\n");
        System.out.printf("2. Translate binary codes into a word\n");
        System.out.printf("3. Exit\nEnter a number [1-3]: ");
    }

    // TODO
    // ADD getLetter and getWord methods here

    /**
     * Takes a binary value and returns the decimal value a an ascii char.
     * @param letter is a string value
     * @return binary value converted to ascii char
     */
    public static char getLetter(String letter) {
        // Ascii char that the method will return
        double finalLetter = 0;

        // Iterator used for calculating the exponent
        int j = 7;

        for (int i = 0; i <= 7; i++) {

            // Check if there is a one in the position
            if (letter.charAt(i) == '1') {

                // Calculate value at each position. Add to the return variable
                finalLetter += Math.pow(2.0, j);
            }

            // Subtract one from the exponent iterator
            j--;
        }

        // Return the decimal value as a char
        return (char)finalLetter;
    }

    /**
     * Takes binary values and returns the decimal values as ascii chars.
     * @param word is a string value
     * @return binary values converted to ascii chars
     */
    public static String getWord(String word) {
        // String value that the method will return
        String finalWord = "";

        // Number of times the next for loop will operate
        int numOfChars = word.length() / 8;

        for (int i = 0; i < numOfChars; i++) {

            // Get the ascii character
            char letter = getLetter(word.substring(i * 8, i * 8 + 8));

            // Concatenate the String
            finalWord += letter;
        }

        // Return the string of char values
        return finalWord;
    }
}