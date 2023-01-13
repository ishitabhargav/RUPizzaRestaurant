package com.example.project4;

import java.util.ArrayList;


/**
 * The BBQChicken Class is used to initialize a BBQChicken Pizza and set its price.
 * This class extends the abstract class Pizza.
 * @author Sneha Balaji, Ishita Bhargava
 */
public class BBQChicken extends Pizza {

    /**
     * Creates a BBQChicken pizza object.
     * @param toppings an arraylist of toppings
     * @param crust the type of crust
     * @param size the size of the pizza
     */
    public BBQChicken(ArrayList <Topping> toppings, Crust crust, Size size) {
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
            price = 13.99;
        } else if (getSize().equals(Size.MEDIUM)) {
            price = 15.99;
        } else {
            price = 17.99;
        }
        return price;
    }
}
