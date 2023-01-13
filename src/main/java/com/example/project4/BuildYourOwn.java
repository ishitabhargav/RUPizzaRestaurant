package com.example.project4;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * The BuildYourOwn Class is used to initialize a BuildYourOwn (custom toppings) pizza and set its price.
 * This class extends the abstract class Pizza.
 * @author Sneha Balaji, Ishita Bhargava
 */
public class BuildYourOwn extends Pizza implements Customizable{

    DecimalFormat twoDecimalPlaces = new DecimalFormat(".##");

    /**
     * Creates a BuildYourOwn pizza object.
     * @param toppings an arraylist of toppings
     * @param crust the type of crust
     * @param size the size of the pizza
     */
    public BuildYourOwn(ArrayList<Topping> toppings, Crust crust, Size size) {
        super(toppings, crust, size);
    }

    /**
     * Returns the price of the pizza based on the size and number of toppings.
     * @return the price
     */
    @Override
    public double price() {
        double price;
        int numToppings = getToppings().size();
        double toppingCost = 1.59;
        if (getSize().equals(Size.SMALL)) {
            price = 8.99;
        } else if (getSize().equals(Size.MEDIUM)) {
            price = 10.99;
        } else {
            price = 12.99;
        }
        price += toppingCost * numToppings;
        price = Double.parseDouble((twoDecimalPlaces.format(price)));

        return price;
    }
}
