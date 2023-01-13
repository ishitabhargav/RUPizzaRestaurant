package com.example.project4;
import java.util.ArrayList;

/**
 * The Pizza class creates an pizza.
 * @author Sneha Balaji, Ishita Bhargava
 */
public abstract class Pizza implements Customizable {

    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;

    /**
     * The price abstract method that will be implemented in Build Your Own.
     */
    public abstract double price();

    /**
     * The constructor to create a pizza.
     * @param toppings the given array list toppings.
     * @param crust the given crust.
     * @param size the given size.
     */
    public Pizza(ArrayList<Topping> toppings, Crust crust, Size size) {
        this.toppings = toppings;
        this.crust = crust;
        this.size = size;
    }

    /**
     * Gets the size of a pizza.
     * @return size the size of a pizza.
     */
    public Size getSize() {
        return size;
    }

    /**
     * Sets the size of a pizza.
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Gets the toppings of a pizza.
     * @return the array list of toppings.
     */
    public ArrayList<Topping> getToppings() {
        return toppings;
    }


    /**
     * Adds a topping to the topping array list.
     * @return true if topping was added, false otherwise.
     */
    @Override
    public boolean add(Object object) {
        int maxNumToppings = 7;
        if (getToppings().size() != maxNumToppings) {
            Topping topping = (Topping) object;
            getToppings().add(topping);
            getToppings().trimToSize();
            return true;
        }
        return false;
    }

    /**
     * Removes a topping from the topping array list.
     * @return true if topping was removed, false otherwise.
     */
    @Override
    public boolean remove(Object object) {
        Topping topping = (Topping) object;
        for (int i = 0; i < getToppings().size(); i++) {
            if (topping.equals(getToppings().get(i))) {
                getToppings().remove(topping);
                getToppings().trimToSize();
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if two pizzas are equal.
     * @param obj the given object.
     * @return true if pizzas are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pizza) {
            Pizza pizza = (Pizza)obj;
            if ((this.toppings.equals(pizza.toppings) &&
                    (this.crust == (pizza.crust) &&
                    (this.size == pizza.size)))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the toString representation of a Pizza.
     * @return returningString the string representation of a Pizza.
     */
    @Override
    public String toString() {
        String returningString = "";
        if ((this.crust != Crust.BROOKLYN && this.crust != Crust.HAND_TOSSED && this.crust != Crust.THIN)) {
            returningString += toString2(returningString);

        } else {
            returningString += toString3(returningString);
        }
        return returningString;
    }

    /**
     * Helper Method for toString()
     * @return returningString the string representation of a Pizza.
     */
    public String toString2(String returningString) {
        if (this instanceof Deluxe) {
            returningString += ("Deluxe (Chicago Style - " + this.crust + "), ");
            if(!this.toppings.isEmpty()) {
                for (int i = 0; i < this.toppings.size(); i++) {
                    returningString += (this.toppings.get(i) + ", ");
                }
            }
            returningString += this.size + ", ";
            returningString += "$"+this.price();
        } else if (this instanceof BBQChicken) {
            returningString += ("BBQ Chicken (Chicago Style - " + this.crust + "), ");
            if(!this.toppings.isEmpty()) {
                for (int i = 0; i < this.toppings.size(); i++) {
                    returningString += (this.toppings.get(i) + ", ");
                }
            }
            returningString += this.size + ", ";
            returningString += "$"+this.price();
        } else if (this instanceof Meatzza) {
            returningString += ("Meatzza (Chicago Style - " + this.crust + "), ");
            if(!this.toppings.isEmpty()) {
                for (int i = 0; i < this.toppings.size(); i++) {
                    returningString += (this.toppings.get(i) + ", ");
                }
            }
            returningString += this.size + ", ";
            returningString += "$"+this.price();
        } else {
            returningString += ("Build Your Own (Chicago Style - " + this.crust + "), ");
            if(!this.toppings.isEmpty()) {
                for (int i = 0; i < this.toppings.size(); i++) {
                    returningString += (this.toppings.get(i) + ", ");
                }
            }
            returningString += this.size + ", ";
            returningString += "$"+this.price();
        }
        return returningString;
    }

    /**
     * Helper Method for toString()
     * @return returningString the string representation of a Pizza.
     */
    public String toString3 (String returningString) {
        if (this instanceof Deluxe) {
            returningString += ("Deluxe (New York Style - " + this.crust + "), ");
            if(!this.toppings.isEmpty()) {
                for (int i = 0; i < this.toppings.size(); i++) {
                    returningString += (this.toppings.get(i) + ", ");
                }
            }
            returningString += this.size + ", ";
            returningString += "$"+this.price();
        } else if (this instanceof BBQChicken) {
            returningString += ("BBQ Chicken (New York Style - " + this.crust + "), ");
            if(!this.toppings.isEmpty()) {
                for (int i = 0; i < this.toppings.size(); i++) {
                    returningString += (this.toppings.get(i) + ", ");
                }
            }
            returningString += this.size + ", ";
            returningString += "$"+this.price();
        } else if (this instanceof Meatzza) {
            returningString += ("Meatzza (New York Style - " + this.crust + "), ");
            if(!this.toppings.isEmpty()) {
                for (int i = 0; i < this.toppings.size(); i++) {
                    returningString += (this.toppings.get(i) + ", ");
                }
            }
            returningString += this.size + ", ";
            returningString += "$"+this.price();
        } else {
            returningString += ("Build Your Own (New York Style - " + this.crust + "), ");
            if(!this.toppings.isEmpty()) {
                for (int i = 0; i < this.toppings.size(); i++) {
                    returningString += (this.toppings.get(i) + ", ");
                }
            }
            returningString += this.size + ", ";
            returningString += "$"+this.price();
        }
        return returningString;
    }

}
