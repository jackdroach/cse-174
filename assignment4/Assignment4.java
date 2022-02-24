/*
 * Author: Jack Roach
 * Date: Dec 6, 2021
 * Class: CSE 174 - I
 * File: Assignment4.java
 * Description: Creates an ArrayList of Customer objects from a file. Sorts the
 * ArrayList using bubble sort based on nicknames or Ds.
 */

import Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment4 {
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Customer> loadedCustomers = new ArrayList<>();
    static ArrayList<Customer> sortedCustomers = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        int selection;

        do {
            // Show menu and execute the user's selection.
            menu();
            selection = scanner.nextInt();
            select(selection);

            System.out.println();

        } while (selection != 6); // End do while loop.
    } // End method main.

    /**
     * Displays the selection menu on the console.
     */
    public static void menu() {
        // Print menu options.
        System.out.println("1. Load from a file");
        System.out.println("2. Print the loaded list");
        System.out.println("3. Sort the list based on the nicknames");
        System.out.println("4. sort the list based on the ids");
        System.out.println("5. Print the sorted list");
        System.out.println("6. Exit");
        System.out.print("Enter a number[1-6]: ");
    } // End method menu.

    /**
     * Executes the user selection from menu().
     * @param selection is an int
     */
    public static void select(int selection) throws FileNotFoundException {
        // Check if customers have been loaded.
        if (loadedCustomers.isEmpty() && selection != 1 && selection != 6) {
            System.out.println("No data has been loaded yet!");

            // Check if customers have been sorted.
        } else if (sortedCustomers.isEmpty() && selection == 5) {
            System.out.println("Nothing is sorted yet!");

        } else {
            switch (selection) {
                case 1:
                    // Load a new customers list from a file.
                    customers.clear();
                    loadFile();

                    loadedCustomers = new ArrayList<>(customers);
                    sortedCustomers.clear();
                    break;

                case 2:
                    // Display the loaded customers list.
                    display(loadedCustomers);
                    break;

                case 3:
                    // Sort customers list by nickname.
                    sort1();
                    sortedCustomers = new ArrayList<>(customers);
                    break;

                case 4:
                    // Sort customers list by ID.
                    sort2();
                    sortedCustomers = new ArrayList<>(customers);
                    break;

                case 5:
                    // Display the sorted customers list.
                    display(sortedCustomers);
                    break;

                case 6:
                    // End the program.
                    System.out.print("End!");
                    break;

                default:
                    break;
            } // End switch.
        } // End if/else.
    } // End method select.

    /**
     * Loads an ArrayList of Customers from a file.
     */
    public static void loadFile() throws FileNotFoundException {
        System.out.println();

        // Prompt the user to enter a file name.
        System.out.print("Enter the name of the file: ");
        Scanner fileScanner = new Scanner(new File(scanner.next()));

        // Search the file for nicknames and IDs.
        while (fileScanner.hasNext()) {
            String nickname = fileScanner.next();
            long id = fileScanner.nextLong();

            // Create a new customer object and add it to the list.
            Customer customer = new Customer(nickname, id);
            customers.add(customer);
        } // End while loop.

        System.out.println("Loading from the file is done!");
    } // End method loadFile.

    /**
     * Sorts an ArrayList of Customers based on the nicknames.
     */
    public static void sort1() {
        for (int i = 0; i < customers.size() - 1; i++) {
            int min = i;
            // Find the index of the minimum value.

            for (int j = i + 1; j < customers.size(); j++) {
                if (customers.get(j).getName().compareTo(customers.get(min)
                    .getName()) < 0) {
                    min = j;
                } // End if/else.
            } // End for loop.

            // Swap the values if needed.
            if (min != i) {
                Customer temp = customers.get(min);
                customers.set(min, customers.get(i));
                customers.set(i, temp);
            } // End if/else
        } // End for loop.

        System.out.println("Sorting is done!");
    } // End method sort1.

    /**
     * Sorts an ArrayList of Customers based on the IDs.
     */
    public static void sort2() {
        for (int i = 0; i < customers.size() - 1; i++) {
            int min = i;

            // Find the index of the minimum value.
            for (int j = i + 1; j < customers.size(); j++) {
                if (customers.get(j).getId() < customers.get(min).getId()) {
                    min = j;
                } // End if/else.
            } // End for loop.

            // Swap the values if needed.
            if (min != i) {
                Customer temp = customers.get(min);
                customers.set(min, customers.get(i));
                customers.set(i, temp);
            } // End if/else.
        } // End for loop.

        System.out.println("Sorting is done!");
    } // End method sort2.

    /**
     * Displays an ArrayList of Customers.
     * @param customers is an ArrayList of Customer objects
     */
    public static void display(ArrayList<Customer> customers) {
        System.out.println("\n**** Printing the list ****");

        int elem = 0;
        int length = customers.size();
        String stop;

        do {
            for (int i = 0; i < 10; i++) {

                // Check if the element is within the bounds of the list.
                if (elem < length) {
                    System.out.println(elem + 1 + ". " + customers.get(elem));
                } // End if/else.

                elem++;
            } // End for loop.

            // Check if the element is not within the bounds of the list.
            if (!(elem < length)) {
                // End the method.
                return;
            } // End if/else.

            // Prompt the user to continue or end printing the list.
            System.out.print("Enter something to continue/enter s to stop: ");
            stop = scanner.next();

        } while (!stop.equals("s")); // End do while loop.
    } // End method display.

} // End class Assignment4.