package com.example.project4;

/**
 * The Customizable Interface briefly defines 2 methods used in a few Classes in this project
 * @author Sneha Balaji, Ishita Bhargava
 */
public interface Customizable {

    /**
     * Implemented by Order, Pizza, and StoreOrder to add an Object
     * @param obj object to be added
     * @return true if obj is added, false otherwise
     */
    boolean add (Object obj);

    /**
     * Implemented by Order, Pizza, and StoreOrder to remove an Object
     * @param obj object to be removed
     * @return true is obj is removed, false otherwise
     */
    boolean remove (Object obj);
}
