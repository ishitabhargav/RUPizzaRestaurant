package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;


/**
 * The CurrentOrderController class is the controller file for the current orders.
 * @author Sneha Balaji, Ishita Bhargava
 */

public class CurrentOrderController implements Initializable{

    public static final double TAX = 6.625/100;

    public static final int NOT_FOUND = -1;
    @FXML
    private ListView listOfOrders;

    @FXML
    private TextField subtotal;

    @FXML
    private TextField orderTotal;

    @FXML
    private TextField salesTax;

    @FXML
    private TextField orderNumber;

    private static ChicagoStylePizzaOrderingController chicagoController;
    private static NewYorkStylePizzaOrderingController nyController;

    ObservableList<Pizza> pizzas = FXCollections.observableArrayList();

    double totalPrice = 0;
    double sTax = 0;
    double finalPrice = 0;

    DecimalFormat twoDecimalPlaces = new DecimalFormat(".##");

    public static StoreOrder storeOrder = new StoreOrder();

    Order sendToStoreOrder = new Order();


    /**
     * Sets the controller to chicago style ordering controller.
     */
    @FXML
    public void setChicagoStylePizzaOrderingController(ChicagoStylePizzaOrderingController controller) {
        chicagoController = controller;
    }


    /**
     * Sets the controller to ny style ordering controller.
     */
    public void setNewYorkStylePizzaOrderingController(NewYorkStylePizzaOrderingController controller) {
        nyController = controller;
    }

    /**
     * implemented initialize method, sends this controller to Store Orders Controller
     * @param url the given URL.
     * @param resourceBundle the given ResourceBundle.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderNumber.setText(String.valueOf(sendToStoreOrder.getOrderNumber()));
        if (chicagoController != null && nyController != null) {
            setChicagoPizza();
            setNyPizza();
        }
        if (chicagoController != null && nyController == null) {
            setChicagoPizza();
        }
        if (nyController != null && chicagoController == null) {
            setNyPizza();
        }
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreOrdersView.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StoreOrdersController storeOrderController = fxmlLoader.getController();
        storeOrderController.setCurrentOrderController(this);
    }


    /**
     * Sets up the listView for the chicago style pizzas.
     */
    @FXML
    void setChicagoPizza() {
        for (int i = 0; i<chicagoController.order.getPizzas().size(); i++) {
            pizzas.add(chicagoController.order.getPizzas().get(i));
            totalPrice += chicagoController.order.getPizzas().get(i).price();
        }
        listOfOrders.setItems(pizzas);
        calculatePrices(totalPrice);
    }


    /**
     * Sets up the listView for the ny style pizzas.
     */
    @FXML
    void setNyPizza() {
        for (int i = 0; i<nyController.order.getPizzas().size(); i++) {
            pizzas.add(nyController.order.getPizzas().get(i));
            totalPrice += nyController.order.getPizzas().get(i).price();
        }
        listOfOrders.setItems(pizzas);
        calculatePrices(totalPrice);
    }

    /**
     * Gets the prices of the pizzas and sets the tax and order total.
     * @param totalPrice the total price of the pizzas.
     */
    @FXML
    void calculatePrices(Double totalPrice) {
        totalPrice = Double.parseDouble((twoDecimalPlaces.format(totalPrice)));
        subtotal.setText(String.valueOf(totalPrice));
        sTax = Double.parseDouble((twoDecimalPlaces.format(totalPrice * TAX)));
        finalPrice = Double.parseDouble((twoDecimalPlaces.format(totalPrice + sTax)));
        salesTax.setText(String.valueOf(sTax));
        orderTotal.setText(String.valueOf(finalPrice));
    }

    /**
     * Removes a pizza from the order.
     */
    @FXML
    public void removePizza() {
        Pizza selectedPizza = (Pizza) listOfOrders.getSelectionModel().getSelectedItem();
        if (selectedPizza == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Please select a pizza to remove");
            alert.showAndWait();
        } else {
            int index = chicagoController.order.retrievePizza(selectedPizza);
            if (index == NOT_FOUND) {
                index = nyController.order.retrievePizza(selectedPizza);
                double removingPrice = nyController.order.getPizzas().get(index).price();
                totalPrice -= removingPrice;
                calculatePrices(totalPrice);
                nyController.order.remove(selectedPizza);
                listOfOrders.getItems().remove(selectedPizza);
            } else {
                double removingPrice = chicagoController.order.getPizzas().get(index).price();
                totalPrice -= removingPrice;
                calculatePrices(totalPrice);
                chicagoController.order.remove(selectedPizza);
                listOfOrders.getItems().remove(selectedPizza);
            }
        }
    }

    /**
     * Places the order.
     */
    @FXML
    public void placeOrder() {
        if (listOfOrders.getItems().size() == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Please add an order!");
            alert.showAndWait();
        } else {
            sendToStoreOrder.incrementNextOrderNumber();
            for (int i = 0; i<listOfOrders.getItems().size(); i++) {
                sendToStoreOrder.add(listOfOrders.getItems().get(i));
            }
            storeOrder.add(sendToStoreOrder);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Order added to Store Orders!");
            alert.showAndWait();
            clearOrder();
        }
    }

    /**
     * Clears the order.
     */
    @FXML
    public void clearOrder() {
        if (chicagoController != null) {
            for (int i = 0; i<chicagoController.order.getPizzas().size(); i++) {
                chicagoController.order.getPizzas().remove(i);
            }
            chicagoController.order = new Order();
        }
        if(nyController != null) {
            for (int i = 0; i<nyController.order.getPizzas().size(); i++) {
                nyController.order.getPizzas().remove(i);
            }
            nyController.order = new Order();
        }
        ObservableList<Pizza> emptyList = FXCollections.observableArrayList();
        listOfOrders.setItems(emptyList);
        orderNumber.clear();
        subtotal.clear();
        orderTotal.clear();
        salesTax.clear();
    }


}
