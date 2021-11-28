/*
 * Author: Jack Roach
 * Date: Oct 29, 2021
 * Class: CSE 174 - I
 * File: Lab10.java
 * Description: Uses method overloading give the user different options for
 * formatting a name.
 */

import java.util.Scanner;

public class Lab10 {
    // Scanner Object for user input.
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // Variable for selection.
        int selection;

        // Print welcome message.
        System.out.println("Welcome to the Name Formatter");

        do {
            // Display menu, get user selection, and display name prompt.
            menu();
            selection = scan.nextInt();
            namePrompt(selection);

            // Call formatName with int selection until exit.
            switch (selection) {
                case 1:
                    System.out.println(formatName(scan.next()));
                    break;
                case 2:
                    System.out.println(formatName(scan.next(), scan.next()));
                    break;
                case 3:
                    System.out.println(formatName(scan.next(),
                        scan.next().charAt(0), scan.next()));
                    break;
                case 4:
                    System.out.println(formatName(scan.next(), scan.next(),
                        scan.next()));
                    break;
                case 5:
                    System.out.println("Thank You for using the Name"
                        + " Formatter!");
                    break;
                default:
                    break;
            } // End switch selection.
        } while (selection != 5);
    } // End method main.

    /**
     * Prompts the user to enter a selection number.
     */
    public static void menu() {
        System.out.println("Select an Option!");
        System.out.println("1. Only First Name");
        System.out.println("2. First Name, and Last Name");
        System.out.println("3. First Name, Middle Initial, and Last Name");
        System.out.println("4. First Name, Middle Name, and Last Name");
        System.out.println("5. Exit");
    } // End method menu.

    /**
     * Prompts the user to enter a name.
     * @param selection is an int value
     */
    public static void namePrompt(int selection) {
        if (selection != 5) {
            System.out.print("Please enter the name parts separated by a"
                + " space: ");
        } // End if/else.
    } // End method namePrompt.

    /**
     * Formats a name that the user inputs.
     * @param first is a string value
     * @return formatted String of the name
     */
    public static String formatName(String first) {
        return String.format("%-8s", first);
    } // End method formatName.

    /**
     * Formats a name that the user inputs.
     * @param first is a String value
     * @param last is a String value
     * @return formatted String of the name
     */
    public static String formatName(String first, String last) {
        return String.format("%-8s %-8s", first, last);
    } // End method formatName.

    /**
     * Formats a name that the user inputs.
     * @param first is a String value
     * @param middle is a char value
     * @param last is a String value
     * @return formatted String of the name
     */
    public static String formatName(String first, char middle, String last) {
        return String.format("%-8s %-8s %-8s", first, middle + ".", last);
    } // End method formatName.

    /**
     * Formats a name that the user inputs.
     * @param first is a String value
     * @param middle is a String value
     * @param last is a String value
     * @return formatted String of the name
     */
    public static String formatName(String first, String middle, String last) {
        return String.format("%-8s %-8s %-8s", first, middle, last);
    } // End method formatName.

} // End class Lab10.