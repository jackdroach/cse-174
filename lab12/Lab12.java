/*
* Author: Jack Roach
* Date: Nov 16, 2021
* Class: CSE 174 - I
* File: Lab12.java
* Description: 2D array algorithms as static methods.
*/

public class Lab12 {
    public static void main(String[] args) {
    } // End method main.

    /**
     * Gets the length a 2D array.
     * @param array is a 2D array of ints
     * @return length of the array
    */
    public static int getNumRows(int[][] array) {
        // Return the length of the array.
        return array.length;
    } // End method getNumRows.

    /**
     * Gets the length of a specific array in a 2D array.
     * @param array is a 2D array of ints
     * @param num is an int
     * @return length of the specified array
     */
    public static int getRowLength(int[][] array, int num) {
        try {
            // Return the length of the specified array.
            return array[num].length;

        } catch (ArrayIndexOutOfBoundsException e) {
            // Return zero if the exception occurs.
            return 0;
        } // End try/catch.
    } // End method getRowLength.

    /**
     * Changes the value of one element of an array in a 2D array.
     * @param array is a 2D array of ints
     * @param row is an int
     * @param col is an int
     * @param num is an int
     */
    public static void changeElem(int[][] array, int row, int col, int num) {
        try {
            // Replace the array element with the specified number.
            array[row][col] = num;

        } catch (ArrayIndexOutOfBoundsException e) {
            // Take no action on the array.
        } // End try/catch.
    } // End method changeElem.

    /**
     * Displays a 2D array to the console.
     * @param array is a 2D array of ints
     */
    public static void display(int[][] array) {
        for (int[] arr : array) {
            for (int elem : arr) {
                // Print the array.
                System.out.print(elem + " ");
            } // End enhanced for loop.

            // Add a new line.
            System.out.println();
        } // End enhanced for loop.
    } // End method display.

    /**
     * Displays a 2D array to the console.
     * @param array is a 2D array of ints
     * @return equality of the sums of all the rows in a 2D array
     */
    public static boolean isMagicRows(int[][] array) {
        // Array for the sums of the rows.
        int[] sums = new int[array.length];

        for (int[] arr : array) {
            // Normal for loop is used for easier index.
            for (int i = 0; i < arr.length; i++) {

                // Add the sum of the current index.
                sums[i] += arr[i];
            } // End for loop.
        } // End enhanced for loop.

        // Check equality of the sums.
        for (int elem : sums) {
            if (sums[0] != elem) {
                return false;
            } // End if/else.
        } // End enhanced for loop.

        return true;
    } // End method isMagicRows.

    /**
     * Displays a 2D array to the console.
     * @param array is a 2D array of ints
     * @return equality of the sums of all the columns in a 2D array
     */
    public static boolean isMagicColumns(int[][] array) {
        // Array for the sums of the columns.
        int[] sums = new int[array.length];

        for (int[] arr : array) {
            // Normal for loop is used for easier index.
            for (int i = 0; i < arr.length; i++) {

                // Add the sum of the current index.
                sums[i] += arr[i];
            } // End for loop.
        } // End enhanced for loop.

        // Check equality of the sums.
        for (int elem : sums) {
            if (sums[0] != elem) {
                return false;
            } // End if/else.
        } // End enhanced for loop.

        return true;
    } // End method isMagicColumns.

} // End class Lab12.