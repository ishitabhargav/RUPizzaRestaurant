package com.example.project4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * The MainController class is the main controller for creating a chicago/ny style pizza, viewing the current order and viewing the store orders. .
 * @author Sneha Balaji, Ishita Bhargava
 */
public class MainController {

    /**
     * Loads the ChicagoStylePizzaOrderingView when pressed.
     */
    @FXML
    protected void onChicagoStylePressed() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChicagoStylePizzaOrderingView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 650);
        Stage stage = new Stage();
        stage.setTitle("Chicago Style Ordering");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Loads the NewYorkStylePizzaOrderingView when pressed.
     */
    @FXML
    protected void onNYStyleClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewYorkStylePizzaOrderingView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 650);
        Stage stage = new Stage();
        stage.setTitle("NY Style Ordering");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Loads the StoreOrdersView when pressed.
     */
    @FXML
    public void onStoreOrdersClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreOrdersView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Store Orders");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Loads the CurrentOrderView when pressed.
     */
    @FXML
    public void onCurrentOrderClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CurrentOrderView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Store Orders");
        stage.setScene(scene);
        stage.show();
    }

}