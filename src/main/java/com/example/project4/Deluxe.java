package com.example.project4;

import java.util.ArrayList;

/**
 * The Deluxe Class is used to initialize a Deluxe Pizza and set its price.
 * This class extends the abstract class Pizza.
 * @author Sneha Balaji, Ishita Bhargava
 */
public class Deluxe extends Pizza {

    /**
     * Creates a Deluxe pizza object.
     * @param toppings an arraylist of toppings
     * @param crust the type of crust
     * @param size the size of the pizza
     */
    public Deluxe(ArrayList<Topping> toppings, Crust crust, Size size) {
        super(toppings, crust, size);
    }

    /**
     * Returns the price of the pizza based on size.
     * @return the price
     */
    @Override
    public double price() {
        double price;
        if (getSize().equals(Size.SMALL)) {
            price = 14.99;
        } else if (getSize().equals(Size.MEDIUM)) {
            price = 16.99;
        } else {
            price = 18.99;
        }
        return price;
    }
}
