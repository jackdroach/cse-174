/**
 * Jack Roach
 * Section: I
 * Sep 24, 2021
 * DiscountCalculator.java
 * This program calculates and prints the discount for a purchase based on user
 * input.
 */

// Import scanner and logger
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Scanner;

public class DiscountCalculator {
    public static void main(String[] args) {

        // Turn off the loggers
        Logger.getGlobal().setLevel(Level.OFF);

        // Print some lines to introduce the program
        System.out.println("*Discount Calculator*");
        System.out.println("1. Calculating dog discount");
        System.out.println("2. Calculating cat discount");
        System.out.println("3. Calculating rodent discount");

        // Declaring scanner used to get user input
        Scanner keyboardReader = new Scanner(System.in);
        
        // Receiving user input into variables
        System.out.print("Enter a number [1, 2, 3]: ");
        int number = keyboardReader.nextInt();
        System.out.print("Enter total purchase: ");
        double purchase = keyboardReader.nextDouble();

        // Log number and purchase
        Logger.getGlobal().info("User input number: " + number);
        Logger.getGlobal().info("User input purchase: " + purchase);

        // Declare and initialize variables for calculations
        double percent10 = .10;
        double percent12 = .12;
        double percent15 = .15;
        double percent20 = .20;
        double discount = 0;
        double price = 0;

        // Start calculations

        // If purchase is more than 100
        if (purchase > 100) {
            switch (number) {

                // If number is 1
                case 1:
                    discount = purchase * percent20;
                    price = purchase - discount;
                    System.out.printf("Dog discount (20%%): %.2f\n", discount);
                    System.out.printf("Price Payable: %.2f\n", price);
                    break;
                    
                // If number is 2
                case 2:
                    discount = purchase * percent15;
                    price = purchase - discount;
                    System.out.printf("Cat discount (15%%): %.2f\n", discount);
                    System.out.printf("Price Payable: %.2f\n", price);
                    break;

                // If number is 3
                case 3:
                    discount = purchase * percent12;
                    price = purchase - discount;
                    System.out.printf("Rodent discount (12%%): %.2f\n",
                        discount);
                    System.out.printf("Price Payable: %.2f\n", price);
                    break;

                // If number is not an expected value
                default:
                    System.out.println("Invalid purchase amount.");

            } // End switch

        // If purchase is lass than 100
        } else if (purchase <= 100) {
            switch (number) {

                // If number is 1
                case 1:
                    discount = purchase * percent10;
                    price = purchase - discount;
                    System.out.printf("Dog discount (10%%): %.2f\n", discount);
                    System.out.printf("Price Payable: %.2f\n", price);
                    break;

                // If number is 2
                case 2:
                    discount = purchase * percent10;
                    price = purchase - discount;
                    System.out.printf("Cat discount (10%%): %.2f\n", discount);
                    System.out.printf("Price Payable: %.2f\n", price);
                    break;

                // If number is 3
                case 3:
                    discount = purchase * percent10;
                    price = purchase - discount;
                    System.out.printf("Rodent discount (10%%): %.2f\n",
                        discount);
                    System.out.printf("Price Payable: %.2f\n", price);
                    break;

                // If number is not an expected value
                default:
                    System.out.println("\nInvalid number.");

            } // End switch

            // Log discount and price
            Logger.getGlobal().info("User input discount: " + discount);
            Logger.getGlobal().info("User input purchase: " + price);

        } // End if else

        // Print closing statement
        System.out.println("End");

    } // End method main
} // End class DiscountCalculator