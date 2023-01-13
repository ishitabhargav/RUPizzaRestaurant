package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

/**
 * The StoreOrdersController class is the controller file for the current orders.
 * @author Sneha Balaji, Ishita Bhargava
 */
public class StoreOrdersController implements Initializable {

    public static final int RESET_VALUE = 0;
    @FXML
    private ComboBox orderNumbers;

    @FXML
    private TextField orderTotal;

    @FXML
    private ListView listOfStoreOrders;

    ObservableList<String> ordNum = FXCollections.observableArrayList();

    ObservableList<Pizza> pizzasInOrder = FXCollections.observableArrayList();

    private static CurrentOrderController currentOrderController;

    double totalPrice = 0;

    double salesTax = 0;

    double finalPrice = 0;

    DecimalFormat twoDecimalPlaces = new DecimalFormat(".##");


    /**
     * Sets the controller to CurrentOrderController controller.
     */
    @FXML
    public void setCurrentOrderController(CurrentOrderController controller) {
        currentOrderController = controller;
    }


    /**
     * implemented initialize method.
     * @param url the given URL.
     * @param resourceBundle the given ResourceBundle.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (currentOrderController != null) {
            if(! currentOrderController.storeOrder.getOrders().isEmpty()) {
                for (int i = 0; i<currentOrderController.storeOrder.getOrders().size(); i++) {
                    ordNum.add(String.valueOf(currentOrderController.storeOrder.getOrders().get(i).getOrderNumber()));
                }
                orderNumbers.setItems(ordNum);
            }
        }
    }

    /**
     * Sets up the list view and the total price based on the order number that was selected.
     */
    @FXML
    protected void selectOrderNumber() {
        ObservableList<Pizza> emptyList = FXCollections.observableArrayList();
        String selected = (String) orderNumbers.getSelectionModel().getSelectedItem();
        if (selected == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Please select an order");
            alert.showAndWait();
        } else {
            for (int i = 0; i<currentOrderController.storeOrder.getOrders().size(); i++) {
                if(currentOrderController.storeOrder.getOrders().get(i).getOrderNumber() == Integer.parseInt(selected)) {
                    for (int j = 0; j<currentOrderController.storeOrder.getOrders().get(i).getPizzas().size(); j++) {
                        pizzasInOrder.add(currentOrderController.storeOrder.getOrders().get(i).getPizzas().get(j));
                        totalPrice += currentOrderController.storeOrder.getOrders().get(i).getPizzas().get(j).price();
                    }
                    break;
                }
            }
            salesTax = Double.parseDouble((twoDecimalPlaces.format(totalPrice * currentOrderController.TAX)));
            finalPrice = Double.parseDouble((twoDecimalPlaces.format(totalPrice + salesTax)));
            orderTotal.setText(String.valueOf(finalPrice));
            listOfStoreOrders.setItems(pizzasInOrder);
            pizzasInOrder = emptyList;
            totalPrice = RESET_VALUE;
        }
    }

    /**
     * Exports the store orders to a txt file.
     */
    @FXML
    void exportStoreOrders() throws IOException {
        try {
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Create Target File for the Export");
            chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                    new FileChooser.ExtensionFilter("All Files", "*.*"));
            Stage stage = new Stage();
            File targetFile = chooser.showSaveDialog(stage); //get the reference of the target file
            BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile));
            for (int i = 0; i < currentOrderController.storeOrder.getOrders().size(); i++) {
                writer.write("Order Number: " + currentOrderController.storeOrder.getOrders().get(i).getOrderNumber() + "\n");
                for (int j = 0; j < currentOrderController.storeOrder.getOrders().get(i).getPizzas().size(); j++) {
                    writer.write(currentOrderController.storeOrder.getOrders().get(i).getPizzas().get(j) + "\n\n");
                }
            }
            writer.close();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Orders have been exported!");
            alert.showAndWait();
        } catch (NullPointerException e) {

        }

    }

    /**
     * Cancels an order.
     */
    @FXML
    void cancelOrder() {
        if (listOfStoreOrders.getItems().size() == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Please select an order!");
            alert.showAndWait();
        } else {
            ObservableList<Pizza> emptyList = FXCollections.observableArrayList();
            ordNum = FXCollections.observableArrayList();
            String selected = (String) orderNumbers.getSelectionModel().getSelectedItem();
            if (orderNumbers.getItems().size() != 1) {
                for (int i = 0; i<currentOrderController.storeOrder.getOrders().size(); i++) {
                    if (currentOrderController.storeOrder.getOrders().get(i).getOrderNumber() == Integer.parseInt(selected)) {
                        currentOrderController.storeOrder.getOrders().remove(i);
                        break;
                    }
                }
                listOfStoreOrders.setItems(emptyList);
                orderTotal.clear();
                for (int i = 0; i < orderNumbers.getItems().size(); i++) {
                    if (orderNumbers.getItems().get(i).equals(selected)) {
                        orderNumbers.getItems().remove(i);
                    }
                }
            } else {
                cancelOneOrder(emptyList, selected);
            }
        }
    }

    /**
     * Cancels an order if there is only one order.
     */
    @FXML
    void cancelOneOrder (ObservableList emptyList, String selected) {
        currentOrderController.storeOrder.getOrders().remove(0);
        listOfStoreOrders.setItems(emptyList);
        orderTotal.clear();
        for (int i = 0; i < orderNumbers.getItems().size(); i++) {
            if (orderNumbers.getItems().get(i).equals(selected)) {
                orderNumbers.getItems().remove(i);
            }
        }
    }
}
