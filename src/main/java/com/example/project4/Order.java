package com.example.project4;

import java.util.ArrayList;

/**
 * The Order class creates an order.
 * @author Sneha Balaji, Ishita Bhargava
 */

public class Order implements Customizable {

    public static final int NOT_FOUND = -1;

    private ArrayList<Pizza> pizzas;
    private int orderNumber;
    private static int nextOrderNumber = 1;

    /**
     * Constructor for creating an order.
     */
    public Order () {
        pizzas = new ArrayList<Pizza>();
        orderNumber = nextOrderNumber;
    }

    /**
     * Increments the serial number for each new order created.
     */
    public void incrementNextOrderNumber() {
        nextOrderNumber++;
    }

    /**
     * Gets the order number of an order. .
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Gets the pizza array list for an Order.
     */
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    /**
     * Finds a pizza in an orders pizza array list and returns the found index.
     * @param pizza the given Pizza.
     * @return i the index if pizza is found in array list, NOT_FOUND otherwise.
     */
    public int retrievePizza(Pizza pizza) {
        for (int i = 0; i<this.getPizzas().size(); i++) {
            if (this.getPizzas().get(i).equals(pizza)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * Adds a pizza to the order array list.
     * @param object the given object.
     * @return true if added, false otherwise.
     */
    @Override
    public boolean add(Object object) {
        Pizza pizza = (Pizza) object;
        pizzas.add(pizza);
        return true;
    }

    /**
     * Removes a pizza from the order array list.
     * @param object the given object.
     * @return true if removed, false otherwise.
     */
    @Override
    public boolean remove(Object object) {
        Pizza pizza = (Pizza) object;
        for (int i = 0; i < pizzas.size(); i++) {
            if (pizza.equals(pizzas.get(i))) {
                pizzas.remove(pizza);
                pizzas.trimToSize();
                return true;
            }
        }
        return false;
    }
}
