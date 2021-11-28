/*
 * Author: Jack Roach
 * Date: Nov 19, 2021
 * Class: CSE 174 - I
 * File: Lab13.java
 * Description: Creates an array of objects from a file and evaluates the array
 * using linear and binary search algorithms.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab13 {
    public static void main(String[] args) throws FileNotFoundException {
        // Calculate and print the number of lines in the file.
        int lines = getLines();
        System.out.println("There are " + lines + " lines in the file");

        // Create a new array of Customer objects using the customers method.
        Customer[] customers = customers(lines);

        // Test case 1.
        Customer key = new Customer("gwstikg", 100005949L);
        search(customers, key);

        // Test case 2.
        key = new Customer("mqzhfygjuk", 6001073675L);
        search(customers, key);

        // Test case 3.
        key = new Customer("gnv", 7412760286L);
        search(customers, key);

        // Test case 4.
        key = new Customer("CSE174", 1111111111L);
        search(customers, key);
    } // End method main.

    /**
     * Gets the length of a file in lines.
     * @return the number of lines
     */
    public static int getLines() throws FileNotFoundException {
        // Scanner for the test file.
        Scanner scanner = new Scanner(new File("customer_list.txt"));

        // Add 1 to lines variable for every new line found.
        int lines = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            lines++;
        }
        return lines;
    } // End method getLines.

    /**
     * Creates a new array of Customer objects from a file.
     * @param lines is the number of lines in the file
     * @return array of Customer objects
     */
    public static Customer[] customers(int lines) throws FileNotFoundException {
        // Scanner for the test file.
        Scanner scanner = new Scanner(new File("customer_list.txt"));

        // Create the array of Customer objects.
        Customer[] customers = new Customer[lines];

        for (int i = 0; i < customers.length; i++) {
            String nickname = scanner.next();
            long id = scanner.nextLong();

            // Fill the index with the recorded nickname and id.
            customers[i] = new Customer(nickname, id);

            // Check if the index should be printed to console.
            printCustomers(customers, i, lines);
        } // End for loop.
        return customers;
    } // End method customers.

    /**
     * Prints matching indexes of an array of Customer objects to console.
     * @param customers is an array of Customer objects
     * @param i is an int
     * @param lines is the number of lines in the file
     */
    public static void printCustomers(Customer[] customers, int i, int lines) {
        // Index if 0.
        if (i == 0) {
            System.out.println("[0]: " + customers[i]);

        // Index if 10.
        } else if (i == 10) {
            System.out.println("[10]: " + customers[i]);

        // Index if 1000.
        } else if (i == 1000) {
            System.out.println("[1000]: " + customers[i]);

        // Index if 1000000.
        } else if (i == 1000000) {
            System.out.println("[1000000: " + customers[i]);

        // The index index recorded.
        } else if (i == lines - 1) {
            System.out.println("[last index]: " + customers[i]);
        } // End if/else.
    } // End method printCustomers.

    /**
     * Initiates linear and binary search on an array of Customer objects.
     * @param customers is an array of Customer objects
     * @param key is a Customer object
     */
    public static void search(Customer[] customers, Customer key) {
        // Initiate linear search.
        int index = linearSearch(customers, key);
        System.out.println("The object " + key + " is located at the index of: "
            + index);

        // Add white space.
        System.out.println();

        // Initiate binary search.
        index = binarySearch(customers, key);
        System.out.println("The object " + key + " is located at the index of: "
            + index);

        // Add white space.
        System.out.println();
    } // End method search.

    /**
     * Searches an array of customers using a linear search algorithm.
     * @param customers is an array of Customer objects
     * @param key is a Customer object
     * @return the index where the key is found
     */
    public static int linearSearch(Customer[] customers, Customer key) {
        int count = 0;

        // Search using a linear search algorithm.
        for (int i = 0; i < customers.length; i++) {

            // Add to the search count.
            count++;

            if (customers[i].equals(key)) {
                // If the key is found print the count and return the index.
                System.out.println("Linear Search: The key is found after "
                    + count + " comparison");
                return i;
            } // End if/else.
        } // End for loop.

        System.out.println("Linear Search: The key is found after " + count
            + " comparison");
        return -1;
    } // End method linearSearch.

    /**
     * Searches an array of customers using a binary search algorithm.
     * @param customers is an array of Customer objects
     * @param key is a Customer object
     * @return the index where the key is found
     */
    public static int binarySearch(Customer[] customers, Customer key) {
        int low = 0;
        int high = customers.length - 1;
        int count = 0;

        // Search using a binary search algorithm.
        while (low <= high) {

            // Add to the search count.
            count++;

            int mid = (low + high) / 2;
            if (customers[mid].getId() == key.getId()) {
                // If the key is found print the count and return the index.
                System.out.println("Binary Search: the key is found after "
                    + count + " comparison");
                return mid;
            } else if (key.getId() > customers[mid].getId()) {
                low = mid + 1;
            } else if (key.getId() < customers[mid].getId()) {
                high = mid - 1;
            } // End if/else.
        } // End while loop.

        // Print the number of searches.
        System.out.println("Binary Search: the key is found after " + count
            + " comparison");
        return -1;
    } // End method binarySearch.

} // End class Lab13.