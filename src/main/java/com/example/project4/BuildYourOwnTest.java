package com.example.project4;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BuildYourOwnTest {

    //tests a pizza of small size and 4 toppings
    @org.junit.Test
    public void price_Test_1() {
        ArrayList<Topping> topping = new ArrayList<>();
        topping.add(Topping.SAUSAGE);
        topping.add(Topping.ONION);
        topping.add(Topping.MUSHROOM);
        Crust crust = Crust.PAN;
        Size size = Size.SMALL;

        BuildYourOwn pizza1 = new BuildYourOwn(topping, crust, size);

        double expectedOutput = 13.76;
        double actualOutput = pizza1.price();

        assertEquals(expectedOutput, actualOutput, 0);

    }

    //tests a pizza of medium size and no toppings
    @org.junit.Test
    public void price_Test_2() {
        ArrayList<Topping> topping = new ArrayList<>();
        Crust crust = Crust.PAN;
        Size size = Size.MEDIUM;

        BuildYourOwn pizza1 = new BuildYourOwn(topping, crust, size);

        double expectedOutput = 10.99;
        double actualOutput = pizza1.price();

        assertEquals(expectedOutput, actualOutput, 0);

    }

    //tests a pizza of large size and 7 toppings
    @org.junit.Test
    public void price_Test_3() {
        ArrayList<Topping> topping = new ArrayList<>();
        topping.add(Topping.SAUSAGE);
        topping.add(Topping.ONION);
        topping.add(Topping.MUSHROOM);
        topping.add(Topping.BLACK_OLIVES);
        topping.add(Topping.PROVOLONE);
        topping.add(Topping.CHEDDAR);
        topping.add(Topping.BEEF);
        Crust crust = Crust.PAN;
        Size size = Size.LARGE;

        BuildYourOwn pizza1 = new BuildYourOwn(topping, crust, size);

        double expectedOutput = 24.12;
        double actualOutput = pizza1.price();

        assertEquals(expectedOutput, actualOutput, 0);

    }
}