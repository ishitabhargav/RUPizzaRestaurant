package com.example.project4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The ChicagoPizza Class is used to initialize a ChicagoPizza Pizza (any of four types).
 * @author Sneha Balaji, Ishita Bhargava
 */
public class ChicagoPizza implements PizzaFactory {

    /**
     * Creates a Chicago-style Deluxe Pizza.
     * @return the Pizza of Deluxe type
     */
    public Pizza createDeluxe() {
        ArrayList<Topping> toppings = new ArrayList<Topping>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI,
                Topping.GREEN_PEPPER, Topping.ONION, Topping.MUSHROOM));
        Crust crust = Crust.DEEP_DISH;
        Size size = Size.SMALL;
        Pizza pizza = new Deluxe(toppings, crust, size);
        return pizza;
    }

    /**
     * Creates a Chicago-style Meatzza Pizza.
     * @return the Pizza of Meatzza type
     */
    public Pizza createMeatzza() {
        ArrayList<Topping> toppings = new ArrayList<Topping>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI,
                Topping.BEEF, Topping.HAM));
        Crust crust = Crust.STUFFED;
        Size size = Size.SMALL;
        Pizza pizza = new Meatzza(toppings, crust, size);
        return pizza;
    }

    /**
     * Creates a Chicago-style BBQChicken Pizza.
     * @return the Pizza of BBQChicken type
     */
    public Pizza createBBQChicken() {
        ArrayList<Topping> toppings = new ArrayList<Topping>(Arrays.asList(Topping.BBQ_CHICKEN, Topping.GREEN_PEPPER,
                Topping.PROVOLONE, Topping.CHEDDAR));
        Crust crust = Crust.PAN;
        Size size = Size.SMALL;
        Pizza pizza = new BBQChicken(toppings, crust, size);
        return pizza;
    }

    /**
     * Creates a Chicago-style BuildYourOwn Pizza.
     * @return the Pizza of BuildYourOwn type
     */
    public Pizza createBuildYourOwn() {
        ArrayList<Topping> toppings = new ArrayList<Topping>();
        Crust crust = Crust.PAN;
        Size size = Size.SMALL;
        Pizza pizza = new BuildYourOwn(toppings, crust, size);
        return pizza;
    }



}
