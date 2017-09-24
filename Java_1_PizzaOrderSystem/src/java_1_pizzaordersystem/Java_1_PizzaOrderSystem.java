/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_1_pizzaordersystem;

import java.util.Scanner;

/**
 *
 * @author Andrew
 */
public class Java_1_PizzaOrderSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // a scanner for keyboard input
        Scanner in = new Scanner(System.in);

        char morePizza = 'Y'; // used to control outer loop
        double orderTotal = 0; // total for the order of many pizzas
        String output = "";  // output to show at the end of the order
        System.out.println("Welcome to Andrew's Pizza order system, please begin your order.");
        // while the clerk has more pizzas for this order
        while (morePizza == 'Y') {
            Pizza pizza = new Pizza(); //pizza object

            // variables needed for user input
            int toppings = 0;
            int size = 0;

            // flag to keep track of valid values
            boolean isValid = false;

            // while user input is not valid, keep asking
            while (!isValid) {
                try { // get the number of toppings on this pizza 
                    System.out.print("Enter number of toppings (1 to 10): ");
                    toppings = in.nextInt();

                    pizza.setToppings(toppings); //set the pizza object's toppings

                    // if we get here, it all must be valid
                    isValid = true;
                } catch (Exception ex) {
                    // user either entered a string or they
                    // entered an invalid number of toppings
                    System.out.println("Invalid input, or exeeding limit for number of toppings.");
                    in.nextLine(); // purge buffer
                }
            } // end of while loop for toppings
            
            // reset the flag for the next input
            isValid = false;
            // while user input is not valid, keep asking
            while (!isValid) {
                try {
                    // get the size of the pizza
                    System.out.print("Enter pizza size (Small = 1, Medium = 2, Large = 3): ");
                    size = in.nextInt();

                    pizza.setSize(size); // set the pizza object's size

                    // if we get here, then it must be valid
                    isValid = true;
                } catch (Exception ex) {
                    // user either entered a string or they 
                    // entered an invalid size number
                    System.out.println("Invalid value for pizza size.");
                    in.nextLine(); // purge buffer
                }
            }

            double pizzaCost = pizza.calcPrice();// get the cost of the pizza
            System.out.print(pizza); // print out pizza object's order formatted with toString() method

            orderTotal += pizzaCost; // add the cost to the total

            output += (pizzaCost + "\n"); // concatenated order

            // is there another pizza in this order?
            System.out.print("Add another pizza? (Y/N): ");
            morePizza = in.next().toUpperCase().charAt(0);
            in.nextLine(); // purge buffer
        }// end of more pizza loop

        // display the complete order
        System.out.println("Order Total:");
        System.out.println(output);
        // display the final order total
        System.out.println("--------------");
        System.out.printf("Final Total: $%.2f%n", orderTotal);
    }

}
