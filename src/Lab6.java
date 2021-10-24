/**
 * Jack Roach
 * Section: I
 * OCt 1, 2021
 * Lab6.java
 * This program calculates grades based on file input and print it to an output
 * file.
 */

// Import File, FileNotFoundException, PrintWriter, and Scanner classes
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) throws FileNotFoundException {

        // Declaring scanner used to get user input
        Scanner keyboardReader = new Scanner(System.in);

        // Getting user input for the files to use
        System.out.print("Enter a file name: ");
        String inputFile = keyboardReader.next();
        System.out.print("Enter an output file name: ");
        String outputFile = keyboardReader.next();

        // Declaring scanner used to get input from a file
        Scanner fileReader = new Scanner(new File(inputFile));

        // Declaring scanner used to print output to a file
        PrintWriter fileWriter = new PrintWriter(outputFile);

        // Declaring variables to be used in calculations
        double sum = 0;
        int i = 0;
        char letterGrade;

        // Start scanner loop
        while (fileReader.hasNextLine()) {

            // Skip strings
            fileReader.next();

            // Get doubles that are in the file
            double grade = fileReader.nextDouble();

            // Start if/else for assigning a letter grade to each number
            if (grade >= 90) {
                letterGrade = 'A';
            } else if (grade >= 80) {
                letterGrade = 'B';
            } else if (grade >= 70) {
                letterGrade = 'C';
            } else if (grade >= 60) {
                letterGrade = 'D';
            } else {
                letterGrade = 'F';
            }

            // Calculate the running total of the grades
            sum = sum + grade;

            // Add one to the number of students
            i++;

            // Print the letter grade to the output file
            fileWriter.println(letterGrade);
        }

        // Calculate the average
        double average = sum / i;

        // Print number of students and class average to the output file
        fileWriter.println("Number of students: " + i);
        fileWriter.printf("Class Average: %.2f", average);

        // Close the file writer
        fileWriter.close();

        // Print number of students and class average to console
        System.out.println("Number of students: " + i);
        System.out.printf("Class Average: %.2f", average);

    }
}