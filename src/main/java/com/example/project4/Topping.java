package com.example.project4;

/**
 * The Topping Enum contains the available toppings for a pizza.
 * @author Sneha Balaji, Ishita Bhargava
 */
public enum Topping {
    SAUSAGE ("SAUSAGE"),
    PEPPERONI ("PEPPERONI"),
    GREEN_PEPPER ("GREEN PEPPER"),
    BBQ_CHICKEN ("BBQ CHICKEN"),
    PROVOLONE ("PROVOLONE"),
    CHEDDAR ("CHEDDAR"),
    BLACK_OLIVES ("BLACK OLIVES"),
    PINEAPPLE ("PINEAPPLE"),
    HAM ("HAM"),
    ONION ("ONION"),
    MUSHROOM ("MUSHROOM"),
    BEEF ("BEEF"),
    SPINACH ("SPINACH");

    private final String toppings;

    /**
     * Sets the topping to a given topping
     * @param toppings the given topping.
     */
    Topping (String toppings) {
        this.toppings = toppings;
    }

    /**
     * Returns a Topping based on a given string.
     * @param topping the given topping.
     * @return a Topping that matches with the given string, null otherwise.
     */
    public static Topping returnTopping(String topping) {
        if (topping.toUpperCase().equals("SAUSAGE")) {
            return SAUSAGE;
        } else if (topping.toUpperCase().equals("PEPPERONI")) {
            return PEPPERONI;
        } else if (topping.toUpperCase().equals("GREEN PEPPER")) {
            return GREEN_PEPPER;
        } else if (topping.toUpperCase().equals("BBQ CHICKEN")) {
            return BBQ_CHICKEN;
        } else if (topping.toUpperCase().equals("PROVOLONE")) {
            return PROVOLONE;
        } else if (topping.toUpperCase().equals("CHEDDAR")) {
            return CHEDDAR;
        } else if (topping.toUpperCase().equals("BLACK OLIVES")) {
            return BLACK_OLIVES;
        } else if (topping.toUpperCase().equals("PINEAPPLE")) {
            return PINEAPPLE;
        } else if (topping.toUpperCase().equals("HAM")) {
            return HAM;
        } else if (topping.toUpperCase().equals("ONION")) {
            return ONION;
        } else if (topping.toUpperCase().equals("MUSHROOM")) {
            return MUSHROOM;
        } else if (topping.toUpperCase().equals("BEEF")) {
            return BEEF;
        } else if (topping.toUpperCase().equals("SPINACH")) {
            return SPINACH;
        }
        return null;
    }



}

