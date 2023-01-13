package com.example.project4;

import java.util.ArrayList;

/**
 * The Meatzza Class is used to initialize a Meatzza Pizza and set its price.
 * This class extends the abstract class Pizza.
 * @author Sneha Balaji, Ishita Bhargava
 */
public class Meatzza extends Pizza {

    /**
     * Creates a Meatzza pizza object.
     * @param toppings an arraylist of toppings
     * @param crust the type of crust
     * @param size the size of the pizza
     */
    public Meatzza(ArrayList<Topping> toppings, Crust crust, Size size) {
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
            price = 15.99;
        } else if (getSize().equals(Size.MEDIUM)) {
            price = 17.99;
        } else {
            price = 19.99;
        }
        return price;
    }
}
