package com.example.project4;

import java.util.ArrayList;

/**
 * The StoreOrder class creates a Store Order.
 * @author Sneha Balaji, Ishita Bhargava
 */
public class StoreOrder implements Customizable {


    private ArrayList<Order> orders;

    /**
     * The StoreOrder constructor initializes a Store Order.
     */
    public StoreOrder() {
        orders = new ArrayList<Order>();
        this.orders = orders;
    }

    /**
     * Adds a order to the Store Order array list.
     * @param object The given object.
     * @return true if added, false otherwise.
     */
    @Override
    public boolean add(Object object) {
        Order order = (Order) object;
        orders.add(order);
        return true;
    }

    /**
     * Gets the orders array list from Store Order.
     * @return orders array list.
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * Removes an order from Store Order array list.
     * @return true if removed, false otherwise.
     */
    @Override
    public boolean remove(Object object) {
        Order order = (Order) object;
        for (int i = 0; i < orders.size(); i++) {
            if (order.equals(orders.get(i))) {
                orders.remove(order);
                orders.trimToSize();
                return true;
            }
        }
        return false;
    }
}
