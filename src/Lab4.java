/**
 * Jack Roach
 * Section: I
 * Sep 17, 2021
 * Lab4.java
 * This program calculates and writes free time after sleep and classes to a
 * file
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) throws FileNotFoundException {

        // Declaring scanner used to get user input
        Scanner keyboardReader = new Scanner(System.in);

        // Asking the user for their name and storing in a variable
        System.out.printf("Enter your first and last name: ");
        String firstName = keyboardReader.next();
        String lastName = keyboardReader.next();
        String fullName = firstName + " " + lastName;

        // Asking the user for their hours slept and storing in a variable
        System.out.printf("Enter your time spent sleeping each night"
            + " " + "(in hours): ");
        double sleepTime = keyboardReader.nextDouble();

        // Asking the user for their # of classes and storing in a variable
        System.out.printf("Enter your number of classes: ");
        int numClasses = keyboardReader.nextInt();

        // Calculating the amount of free time based on user input
        double freeTime = 120 - (sleepTime * 5 + numClasses * 8.72);

        // Printing the user input to the console
        System.out.printf(" ____________________________________________\n");
        System.out.printf("|Name                |Num Classes |Free Time |\n");
        System.out.printf("|............................................|\n");
        System.out.printf("|%-20s|%-12s|%-10.1f|\n",
            fullName, numClasses, freeTime);
        System.out.printf(" --------------------------------------------\n");

        // Asking the user to specify a file name for input
        System.out.printf("Enter an input filename: ");
        String inputFile = keyboardReader.next();

        // Declaring scanner used to get file input
        Scanner fileReader = new Scanner(new File(inputFile));

        // Declaring variables and collecting input from the file
        String firstNameFile = fileReader.next();
        String lastNameFile = fileReader.next();
        String fullNameFile = firstNameFile + " " + lastNameFile;
        double sleepTimeFile = fileReader.nextDouble();
        int numClassesFile = fileReader.nextInt();

        fileReader.close();

        // Calculating the amount of free time based on file input
        double freeTimeFile = 120 - (sleepTimeFile * 5 + numClassesFile * 8.72);

        // Printing the file input to the console
        System.out.printf(" ____________________________________________\n");
        System.out.printf("|Name                |Num Classes |Free Time |\n");
        System.out.printf("|............................................|\n");
        System.out.printf("|%-20s|%-12s|%-10.1f|\n",
                fullNameFile, numClassesFile, freeTimeFile);
        System.out.printf(" --------------------------------------------\n");

        // Asking the user to specify a file name for output
        System.out.printf("Enter an output filename: ");
        String outputFile = keyboardReader.next();

        // Declaring scanner used to print output to a file
        PrintWriter fileWriter = new PrintWriter(outputFile);

        // Printing the user and file inputs to the specified output file
        fileWriter.printf(" ____________________________________________\n");
        fileWriter.printf("|Name                |Num Classes |Free Time |\n");
        fileWriter.printf("|............................................|\n");
        fileWriter.printf("|%-20s|%-12s|%-10.1f|\n",
                fullName, numClasses, freeTime);
        fileWriter.printf("|%-20s|%-12s|%-10.1f|\n",
                fullNameFile, numClassesFile, freeTimeFile);
        fileWriter.printf(" --------------------------------------------\n");

        fileWriter.close();

    } // End method main
} // End class Lab4