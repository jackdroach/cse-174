/**
 * Sept 3, 2021
 * Author: Jack Roach
 * Counts tires.
 */

public class CountTires {
    public static void main(String[] args) {
 
        // Number of tire pairs (given)
        final int TIRE_PAIRS = 19873123;
 
        // Calculate and print the number of pairs
        int totalTires = (TIRE_PAIRS * 2);
        System.out.print("The number of: " + totalTires);
        System.out.println(" tires are added to the production line!");
 
        // Calculate and print the number of cars that can be made
        int cyberCars = TIRE_PAIRS / 2;
        System.out.println(cyberCars + " cars are produced.");
 
        // Calculate and print the number of tires left over
        int tiresLeft = (totalTires % cyberCars);
        System.out.println(tiresLeft + " tires are left.");
 
    } // End method main
} // End class CountTires