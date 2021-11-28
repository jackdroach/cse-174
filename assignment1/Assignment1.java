/**
 * Jack Roach
 * Section: I
 * Sep 2021
 * Assignment1.java
 * This program decodes the digits.
 */

import java.util.Scanner; // importing Scanner class

public class Assignment1 {
    public static void main(String[] args) {
        // Defining a Scanner object
        Scanner in = new Scanner(System.in);

        // Prompting the user with a message
        System.out.print("Enter a 10 digit phone number (e.g. 5131234567): ");

        // Saving the given number inside a constant variable
        final long PHONE_NUM = in.nextLong();

        // Separate the phone # into 3 parts
        int areaCode = (int)(PHONE_NUM / 10000000);
        int centralOffice = (int)((PHONE_NUM / 10000) % 1000);
        int stationNumber = (int)(PHONE_NUM % 10000);

        // Print the separate phone #
        // Note: Kunting helped me with ln. 29 during office hours
        // Fixes Java not printing leading zeros
        System.out.printf("(%03d) %03d - %04d\n", areaCode, centralOffice,
            stationNumber);

        // Separate the station number into 2 different 2 digit variables
        int encrypt1 = stationNumber / 100;
        int encrypt2 = stationNumber % 100;

        // "Encrypt" the 2 separated variables and then convert to chars
        encrypt1 = encrypt1 + 33;
        encrypt2 = encrypt2 + 33;
        char encrypt1Char = (char)encrypt1;
        char encrypt2Char = (char)encrypt2;

        // Print the encrypted phone #
        System.out.println("(" + areaCode + ") " + centralOffice + " - "
            + encrypt2Char + "" + encrypt1Char);

        // Combine area code and central office into one number and encrypt it
        int areaAndCentral = areaCode * 1000 + centralOffice;
        areaAndCentral = Integer.MAX_VALUE - areaAndCentral;

        // Print the combined and encrypted number
        System.out.println(areaAndCentral);

        // Print the final encrypted phone #
        System.out.println(encrypt2Char + "" + areaAndCentral + ""
            + encrypt1Char);

    } // End method main
} // End class Assignment1