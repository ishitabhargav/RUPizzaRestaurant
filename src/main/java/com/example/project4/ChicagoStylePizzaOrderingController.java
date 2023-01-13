package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * The ChicagoStylePizzaOrderingController class is the controller file for ordering a Chicago style pizza.
 * @author Sneha Balaji, Ishita Bhargava
 */
public class ChicagoStylePizzaOrderingController implements Initializable{

    public static final int EMPTY = 0;
    public static final int MAX_TOPPINGS = 7;
    public static final int FIRST_INDEX = 0;

    ObservableList<String> pizzaFlavors = FXCollections.observableArrayList("Deluxe", "BBQ Chicken", "Meatzza", "Build Your Own");
    ObservableList<String> pizzaToppings = FXCollections.observableArrayList("Sausage", "Pepperoni", "Green Pepper", "BBQ Chicken", "Provolone", "Cheddar", "Black Olives", "Pineapple", "Ham", "Onion", "Mushroom", "Beef", "Spinach");
    ObservableList<String> selectedPizzaToppings2 = FXCollections.observableArrayList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom");
    ObservableList<String> selectedPizzaToppings3 = FXCollections.observableArrayList("BBQ Chicken", "Green Pepper", "Provolone", "Cheddar");
    ObservableList<String> selectedPizzaToppings4 = FXCollections.observableArrayList("Sausage", "Pepperoni", "Beef", "Ham");
    @FXML
    private ComboBox chicagoPizzaFlavor;
    @FXML
    private RadioButton smallSize;
    @FXML
    private RadioButton mediumSize;

    @FXML
    private RadioButton largeSize;
    @FXML
    private TextField crust;
    @FXML
    private ListView availableToppings;
    @FXML
    private ListView selectedToppings;
    @FXML
    private TextField price;
    @FXML
    private ImageView chicagoStylePizza;

    public static Order order = new Order();

    ChicagoPizza chicagoPizza = new ChicagoPizza();
    Pizza pizza;

    boolean isFlavorSelected = false;

    /**
     * Sets the Chicago Pizza Flavors when the combo box is selected.
     */
    @FXML
    protected void setChicagoPizzaFlavors () {
        chicagoPizzaFlavor.setItems(pizzaFlavors);
    }

    /**
     * Creates the pizza based on the flavor, sets the available Chicago Pizza Toppings, the price for the selected toppings.
     */
    @FXML
    protected void setChicagoPizzaToppings () {
        ObservableList<String> emptyItems = FXCollections.observableArrayList();
        String selected = (String) chicagoPizzaFlavor.getSelectionModel().getSelectedItem();
        availableToppings.setItems(pizzaToppings);
        if (selected.equalsIgnoreCase("Build Your Own")){
            Image image = new Image("file:/Users/sneha/Desktop/CS213/Project4/target/classes/com/example/project4/images/chicagoBuildYourOwn.jpeg");
            chicagoStylePizza.setImage(image);
            crust.setText("Pan");
            selectedToppings.setItems(emptyItems);
            initializePriceBuildYourOwn();
        } else {
            if (selected.equalsIgnoreCase("Deluxe")) {
                Image image = new Image("file:/Users/sneha/Desktop/CS213/Project4/target/classes/com/example/project4/images/chicagoDeluxe.jpg");
                chicagoStylePizza.setImage(image);
                crust.setText("Deep Dish");
                selectedToppings.setItems(selectedPizzaToppings2);
                initializePriceDeluxe();
            } else if (selected.equalsIgnoreCase("BBQ Chicken")) {
                Image image = new Image("file:/Users/sneha/Desktop/CS213/Project4/target/classes/com/example/project4/images/chicagoBBQChicken.jpeg");
                chicagoStylePizza.setImage(image);
                crust.setText("Pan");
                selectedToppings.setItems(selectedPizzaToppings3);
                initializeBBQChicken();
            } else if (selected.equalsIgnoreCase("Meatzza"))  {
                Image image = new Image("file:/Users/sneha/Desktop/CS213/Project4/target/classes/com/example/project4/images/chicagoMeatzza.jpeg");
                chicagoStylePizza.setImage(image);
                crust.setText("Stuffed");
                selectedToppings.setItems(selectedPizzaToppings4);
                initializeMeatzza();
            }
        }
    }

    /**
     * Initializes the price for a Build Your Own Pizza.
     */
    @FXML
    protected void initializePriceBuildYourOwn () {
        if (smallSize.isSelected()) {
            pizza = chicagoPizza.createBuildYourOwn();
            pizza.setSize(Size.SMALL);
            isFlavorSelected = true;
            price.setText(String.valueOf(pizza.price()));
        } else if (mediumSize.isSelected()) {
            pizza = chicagoPizza.createBuildYourOwn();
            pizza.setSize(Size.MEDIUM);
            isFlavorSelected = true;
            price.setText(String.valueOf(pizza.price()));
        } else {
            pizza = chicagoPizza.createBuildYourOwn();
            pizza.setSize(Size.LARGE);
            isFlavorSelected = true;
            price.setText(String.valueOf(pizza.price()));
        }
    }

    /**
     * Initializes the price for a Deluxe Pizza.
     */
    @FXML
    protected void initializePriceDeluxe() {
        if (smallSize.isSelected()) {
            pizza = chicagoPizza.createDeluxe();
            pizza.setSize(Size.SMALL);
            isFlavorSelected = true;
            price.setText(String.valueOf(pizza.price()));
        } else if (mediumSize.isSelected()) {
            pizza = chicagoPizza.createDeluxe();
            pizza.setSize(Size.MEDIUM);
            isFlavorSelected = true;
            price.setText(String.valueOf(pizza.price()));
        } else {
            pizza = chicagoPizza.createDeluxe();
            pizza.setSize(Size.LARGE);
            isFlavorSelected = true;
            price.setText(String.valueOf(pizza.price()));
        }
    }

    /**
     * Initializes the price for a BBQChicken Pizza.
     */
    @FXML
    protected void initializeBBQChicken() {
        if (smallSize.isSelected()) {
            pizza = chicagoPizza.createBBQChicken();
            pizza.setSize(Size.SMALL);
            isFlavorSelected = true;
            price.setText(String.valueOf(pizza.price()));
        } else if (mediumSize.isSelected()) {
            pizza = chicagoPizza.createBBQChicken();
            pizza.setSize(Size.MEDIUM);
            isFlavorSelected = true;
            price.setText(String.valueOf(pizza.price()));
        } else {
            pizza = chicagoPizza.createBBQChicken();
            pizza.setSize(Size.LARGE);
            isFlavorSelected = true;
            price.setText(String.valueOf(pizza.price()));
        }
    }

    /**
     * Initializes the price for a Meatzza Pizza.
     */
    @FXML
    protected void initializeMeatzza() {
        if (smallSize.isSelected()) {
            pizza = chicagoPizza.createMeatzza();
            pizza.setSize(Size.SMALL);
            isFlavorSelected = true;
            price.setText(String.valueOf(pizza.price()));
        } else if (mediumSize.isSelected()) {
            pizza = chicagoPizza.createMeatzza();
            pizza.setSize(Size.MEDIUM);
            isFlavorSelected = true;
            price.setText(String.valueOf(pizza.price()));
        } else {
            pizza = chicagoPizza.createMeatzza();
            pizza.setSize(Size.LARGE);
            isFlavorSelected = true;
            price.setText(String.valueOf(pizza.price()));
        }
    }

    /**
     * Sets the price of a pizza based on the size.
     */
    @FXML
    protected void setPrice () {
        if(isFlavorSelected == true) {
            String selected = (String) chicagoPizzaFlavor.getSelectionModel().getSelectedItem();
            if (selected.equalsIgnoreCase("Deluxe")) {
                initializePriceDeluxe();
            } else if (selected.equalsIgnoreCase("BBQ Chicken")) {
                initializeBBQChicken();
            } else if (selected.equalsIgnoreCase("Meatzza")) {
                initializeMeatzza();
            } else {
                pizza = chicagoPizza.createBuildYourOwn();
                for (int i = 0; i < selectedToppings.getItems().size(); i++) {
                    String selectedTopping = (String) selectedToppings.getItems().get(i);
                    Topping topping = Topping.returnTopping(selectedTopping);
                    pizza.add(topping);
                }
                if (smallSize.isSelected()) {
                    pizza.setSize(Size.SMALL);
                } else if (mediumSize.isSelected()) {
                    pizza.setSize(Size.MEDIUM);
                } else {
                    pizza.setSize(Size.LARGE);
                }
                price.setText(String.valueOf(pizza.price()));
            }
            if (smallSize.isSelected()) {
                pizza.setSize(Size.SMALL);
            } else if (mediumSize.isSelected()) {
                pizza.setSize(Size.MEDIUM);
            } else {
                pizza.setSize(Size.LARGE);
            }
        }
    }

    /**
     * Adds the selected topping.
     * @return true if topping was added, false otherwise.
     */
    @FXML
    public boolean addTopping () {
        if (availableToppings.getItems().size() == EMPTY) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Please select a flavor");
            alert.showAndWait();
            return false;
        } else {
            String selected = (String) chicagoPizzaFlavor.getSelectionModel().getSelectedItem();
            if (selected.equalsIgnoreCase("Build Your Own")) {
                String selectedTopping = (String) availableToppings.getSelectionModel().getSelectedItem();
                if (selectedTopping == null) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setHeaderText("Please select a topping to add");
                    alert.showAndWait();
                    return false;
                }
                else if (selectedToppings.getItems().size() >= MAX_TOPPINGS) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setHeaderText("You must only add 7 toppings!");
                    alert.showAndWait();
                    return false;
                }
                selectedToppings.getItems().add(selectedTopping);
                availableToppings.getItems().remove(selectedTopping);
                Topping topping = Topping.returnTopping(selectedTopping);
                pizza.add(topping);
                price.setText(String.valueOf(pizza.price()));
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText("You cannot add toppings for flavors other than Build Your Own !");
                alert.showAndWait();
                return false;
            }
        }
    }

    /**
     * Removed the selected pizza topping.
     * @return true if removed, false otherwise.
     */
    @FXML
    public boolean removeTopping () {
        if (selectedToppings.getItems().size() == EMPTY && !((String) chicagoPizzaFlavor.getSelectionModel().getSelectedItem()).equals("Build Your Own")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Please select a flavor");
            alert.showAndWait();
            return false;
        } else {
            String selected = (String) chicagoPizzaFlavor.getSelectionModel().getSelectedItem();
            if (selected.equalsIgnoreCase("Build Your Own")) {
                String selectedTopping = (String) selectedToppings.getSelectionModel().getSelectedItem();
                if (selectedTopping == null) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setHeaderText("Please select a topping to remove");
                    alert.showAndWait();
                    return false;
                }
                selectedToppings.getItems().remove(selectedTopping);
                availableToppings.getItems().add(selectedTopping);
                Topping topping = Topping.returnTopping(selectedTopping);
                pizza.remove(topping);
                price.setText(String.valueOf(pizza.price()));
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText("You cannot remove toppings for flavors other than Build Your Own !");
                alert.showAndWait();
                return false;
            }
        }
    }

    /**
     * Checks if a flavor is selected.
     * @return true if selected, false otherwise.
     */
    @FXML
    protected boolean isValidFlavor () {
        if (chicagoPizzaFlavor.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Select a Flavor.");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    /**
     * Adds created pizza to the Order.
     */
    @FXML
    protected void addPizzaToOrder() {
        if (isValidFlavor()) {
            order.add(pizza);
            String selected = (String) chicagoPizzaFlavor.getSelectionModel().getSelectedItem();
            pizzaToppings = FXCollections.observableArrayList("Sausage", "Pepperoni", "Green Pepper", "BBQ Chicken", "Provolone", "Cheddar", "Black Olives", "Pineapple", "Ham", "Onion", "Mushroom", "Beef", "Spinach");
            if (selected.equalsIgnoreCase("Build Your Own")) {
                ObservableList<String> emptyItems = FXCollections.observableArrayList();
                selectedToppings.setItems(emptyItems);
                availableToppings.setItems(pizzaToppings);
                chicagoPizzaFlavor.getSelectionModel().select(FIRST_INDEX);
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Pizza added to the order!");
            alert.showAndWait();
        }
    }

    /**
     * implemented initialize method, sends this controller to CurrentOrderController.
     * @param url the given URL.
     * @param resourceBundle the given ResourceBundle.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CurrentOrderView.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CurrentOrderController orderController = fxmlLoader.getController();
        orderController.setChicagoStylePizzaOrderingController(this);
    }
}
