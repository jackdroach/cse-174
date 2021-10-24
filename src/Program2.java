/*
 * Jack Roach
 * Section: I
 * Oct 7, 2021
 * Program1.java
 * This program uses loops to read and write to files.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) throws FileNotFoundException {
        // Declare scanner for user input and file input
        Scanner keyboardReader = new Scanner(System.in);
        Scanner fileReader = null;

        // Variables for getting input file
        boolean error = false;
        String inputFile = "";

        // Get input file
        while (!error) {
            try {
                System.out.print("Enter an input file name: ");
                inputFile = keyboardReader.next();
                fileReader = new Scanner(new File(inputFile));

            // Catch and loop until a valid file is entered
            } catch (FileNotFoundException e) {
                continue;
            } // End try/catch
            error = true;
        } // End while loop

        // Variables for scanning input file
        String fileContent = "";
        int wordLength = 0;

        // Scan input file
        while (fileReader.hasNextLine()) {

            // Scan for "#" character
            if (fileReader.hasNext("#")) {
                fileReader.next("#");
                fileContent = fileContent + "\n";

            // Scan for ints
            } else if (fileReader.hasNextInt()) {
                wordLength = fileReader.nextInt();

                // Build the word based on int scanned
                for (int i = 0; i < wordLength; i++) {
                    fileContent = fileContent + fileReader.next();
                } // End for loop

                // Add whitespace after the word
                fileContent = fileContent + " ";
            } // End if else
        } // End while loop

        // Remove extra whitespace from the file content
        if (fileContent.contains(" \n")) {
            fileContent = fileContent.replace(" \n", "\n");
        } // End if else

        if (fileContent.endsWith(" ")) {
            fileContent = fileContent.substring(0, fileContent.length() - 1);
        } // End if else

        // Print the file content and close the scanner used for file input
        System.out.print(fileContent);
        fileReader.close();

        // Variable for printing to output file
        String printToFile = "";

        // Ask user to print to output file
        while (!printToFile.equals("y") && !printToFile.equals("n")) {
            System.out.print("\n**Do you want to print in a file (y/n): ");
            printToFile = keyboardReader.next();
        } // End while loop

        // If yes in while loop above, then get output file
        if (printToFile.equals("y")) {
            System.out.print("Enter an output file name: ");
            String outputFile = keyboardReader.next();

            // Print to output file
            PrintWriter fileWriter = new PrintWriter(outputFile);
            fileWriter.print(fileContent);
            fileWriter.close();
            System.out.print("Printed inside the " + outputFile
                + " successfully!\n");
        } // End if else

        // Ending statement
        System.out.println("End!");

    } // End method main
} // End class Program2