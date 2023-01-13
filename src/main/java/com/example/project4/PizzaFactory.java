package com.example.project4;

/**
 * The Pizza factory interface creates a pizza for the different kinds of flavors.
 * @author Sneha Balaji, Ishita Bhargava
 */
public interface PizzaFactory {

    /**
     * Implemented by Chicago Pizza and NY Pizza to create a deluxe pizza flavor.
     * @return the created Pizza.
     */
    Pizza createDeluxe();
    /**
     * Implemented by Chicago Pizza and NY Pizza to create a meatzza pizza flavor.
     * @return the created Pizza.
     */
    Pizza createMeatzza();
    /**
     * Implemented by Chicago Pizza and NY Pizza to create a bbq chicken pizza flavor.
     * @return the created Pizza.
     */
    Pizza createBBQChicken();
    /**
     * Implemented by Chicago Pizza and NY Pizza to create a build your own pizza flavor.
     * @return the created Pizza.
     */
    Pizza createBuildYourOwn();
}
