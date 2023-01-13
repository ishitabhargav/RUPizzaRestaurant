package com.example.project4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The NYPizza Class is used to initialize a NYPizza Pizza (any of four types).
 * @author Sneha Balaji, Ishita Bhargava
 */
public class NYPizza implements PizzaFactory{

    /**
     * Creates a NY-style Deluxe Pizza.
     * @return the Pizza of Deluxe type
     */
    public Pizza createDeluxe() {
        ArrayList<Topping> toppings = new ArrayList<Topping>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI,
                Topping.GREEN_PEPPER, Topping.ONION, Topping.MUSHROOM));
        Crust crust = Crust.BROOKLYN;
        Size size = Size.SMALL;
        Pizza pizza = new Deluxe(toppings, crust, size);
        return pizza;
    }

    /**
     * Creates a NY-style Meatzza Pizza.
     * @return the Pizza of Meatzza type
     */
    public Pizza createMeatzza() {
        ArrayList<Topping> toppings = new ArrayList<Topping>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI,
                Topping.BEEF, Topping.HAM));
        Crust crust = Crust.HAND_TOSSED;
        Size size = Size.SMALL;
        Pizza pizza = new Meatzza(toppings, crust, size);
        return pizza;
    }

    /**
     * Creates a NY-style BBQChicken Pizza.
     * @return the Pizza of BBQChicken type
     */
    public Pizza createBBQChicken() {
        ArrayList<Topping> toppings = new ArrayList<Topping>(Arrays.asList(Topping.BBQ_CHICKEN, Topping.GREEN_PEPPER,
                Topping.PROVOLONE, Topping.CHEDDAR));
        Crust crust = Crust.THIN;
        Size size = Size.SMALL;
        Pizza pizza = new BBQChicken(toppings, crust, size);
        return pizza;
    }

    /**
     * Creates a NY-style BuildYourOwn Pizza.
     * @return the Pizza of BuildYourOwn type
     */
    public Pizza createBuildYourOwn() {
        ArrayList<Topping> toppings = new ArrayList<Topping>();
        Crust crust = Crust.HAND_TOSSED;
        Size size = Size.SMALL;
        Pizza pizza = new BuildYourOwn(toppings, crust, size);
        return pizza;
    }
}
