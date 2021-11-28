/*
* Author: Jack Roach
* Date: Nov 5, 2021
* Class: CSE 174 - I
* File: PizzaShop.java
* Description: Uses methods of a Pizza object to calculate the price for a
* pizza.
*/

import java.util.Scanner;

public class PizzaShop {
   public static void main(String[] args) {
       // Scanner for user input.
       Scanner scan = new Scanner(System.in);

       // Prompt the user to enter an Integer.
       System.out.print("Enter a lucky number: ");

       // Create a new Pizza object with the input.
       int luckyNumber = scan.nextInt();
       Pizza pizza = new Pizza(luckyNumber);

       // Print the cost of the pizza.
       System.out.printf("Your pizza will cost $%.2f", pizzaCost(pizza));
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

} // End class PizzaShop.