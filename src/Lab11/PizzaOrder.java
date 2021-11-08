package Lab11;

/*
 * Author: Jack Roach
 * Date: Nov 5, 2021
 * Class: CSE 174 - I
 * File: PizzaOrder.java
 * Description: Uses methods of a Pizza object to complete a pizza order.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PizzaOrder {
    public static void main(String[] args) {
        // Scanner for user input.
        Scanner kb = new Scanner(System.in);

        // Prompt the user to enter an order file.
        System.out.print("Enter order filename: ");

        // Call pizzaOrder with the file name.
        String fileName = kb.next();
        pizzaOrder(fileName);
    } // End method main.

    /*
     * $4 for small, $5.50 for medium, $7 for large
     * Stuffed crust: $1 extra for small, $2 for medium, $3 for large
     * No extra charge for thin/thick
     * Toppings $0.75 each. However, there an additional $0.50 charge if
     * at least one of the toppings is anchovies.
     * For example, if the toppings are: anchovies, anchovies, onions,
     * and pepperoni, then the toppings charge will be $3.50
     * (4 toppings cost $3.00, and an extra 50 cents because at least
     * one of the toppings is anchovies).
     * Delivery: $2 (free for pizzas costing $10 or more)
     */

    /**
     * Gets the price in dollars of a pizza.
     * @param p is a Pizza object
     * @return price of the pizza
     */
    public static double pizzaCost(Pizza p) {
        // Price of the pizza.
        double price = 0;

        // Add to the price for size of the pizza.
        switch (p.getSize()) {
            case "small":
                // Add to the price if stuffed crust.
                if (p.getCrust().equals("stuffed")) {
                    price += 1;
                } // End if/else.

                // Add to the price for small size.
                price += 4;
                break;

            case "medium":
                // Add to the price if stuffed crust.
                if (p.getCrust().equals("stuffed")) {
                    price += 2;
                } // End if/else.

                // Add to the price for medium size.
                price += 5.50;
                break;

            case "large":
                // Add to the price if stuffed crust.
                if (p.getCrust().equals("stuffed")) {
                    price += 3;
                } // End if/else.

                // Add to the price for large size.
                price += 7;
                break;
            default:
                break;
        } // End switch.

        // Add to the price for each topping.
        price += p.toppingCount() * 0.75;

        // Add to the price for anchovies.
        if (p.hasTopping("anchovies")) {
            price += 0.50;
        } // End if/else.

        // Add to the delivery price.
        if (p.getDelivery() && (price + 2) < 10) {
            price += 2;
        } // End if/else.

        return price;
    } // End method pizzaCost.

    /**
     * Creates an order for a pizza based on file input.
     * @param fileName is a String
     */
    public static void pizzaOrder(String fileName) {
        try {
            // Scanner for file input.
            Scanner scan = new Scanner(new File(fileName));

            // Get the order size, crust, and delivery options.
            String size = scan.next();
            String crust = scan.next();
            String delivery = scan.next();

            // List of toppings.
            ArrayList<String> toppings = new ArrayList<>();

            // Add toppings to the list.
            while (scan.hasNextLine()) {
                toppings.add(scan.nextLine());
            } // End while loop.

            // Construct a new Pizza object with buildPizza.
            Pizza pizza = buildPizza(size, crust, delivery);

            // Add topping to the Pizza object.
            addToppings(pizza, toppings);

            // Print the order to console.
            printOrder(pizza);

        } catch (Exception e) {
            // Print an error message.
            System.out.println("INVALID ORDER. GOODBYE");

        } // End try/catch.
    } // End method pizzaOrder.

    /**
     * Makes a new pizza object based on file input.
     * @param size is a String
     * @param crust is a String
     * @param delivery is a String
     * @return a new pizza object
     */
    public static Pizza buildPizza(String size, String crust, String delivery) {
        // Construct a new Pizza object.
        Pizza pizza = new Pizza(size, crust);

        // Set delivery status.
        if (delivery.equals("delivery")) {
            pizza.setDelivery(true);
        } // End if/else.

        return pizza;
    } // End method buildPizza.

    /**
     * Adds toppings to the pizza.
     * @param pizza is a Pizza object
     * @param toppings is a String ArrayList
     */
    public static void addToppings(Pizza pizza, ArrayList<String> toppings) {
        // Valid pizza toppings.
        String[] availableToppings = {"pepperoni", "mushrooms", "sausage",
            "bacon", "pineapple", "onions", "peppers", "steak", "ham",
            "chicken", "tomatoes", "anchovies", "spinach", "broccoli", "olives"
        };

        // Print the toppings header.
        System.out.println("---Toppings---");

        // Add toppings to the pizza object.
        for (int i = 1; i < toppings.size(); i++) {
            // Current topping for the for loop.
            String topping = toppings.get(i);

            // Filter invalid toppings
            if (!Arrays.toString(availableToppings).contains(topping)) {
                System.out.println(topping + ": TRY PAPA JOHNS.");

            // Add valid toppings.
            } else if (!pizza.hasTopping(topping)) {
                pizza.addTopping(topping);
                System.out.println(topping + ": added");

            // Filter duplicate valid toppings.
            } else {
                System.out.println(topping + ": DUPLICATE. NOT ADDED.");

            } // End if/else.
        } // End for loop.
    } // End method addToppings.

    /**
     * Prints the pizza order.
     * @param pizza is a Pizza object
     */
    public static void printOrder(Pizza pizza) {
        // Print the order header.
        System.out.println("---Here is your order---");

        // Print the pizza.
        System.out.println(pizza.toString());

        // Print the pizza cost.
        System.out.printf("Your total is $%.2f.\n", pizzaCost(pizza));

        // Exit message.
        System.out.println("---Have a nice day---");
    } // End method printOrder.

} // End class PizzaShop.