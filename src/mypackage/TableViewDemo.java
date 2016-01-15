package mypackage;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TableViewDemo extends Application {

    TextField nameInput, priceInput, quantityInput;
    Button addButton, deleteButton;
    TableView<Product> table;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) {

        addButton = new Button("Add");
        deleteButton = new Button("Delete");

        //add button action
        addButton.setOnAction(event -> checkAndAddItem());
        //delete button action
        deleteButton.setOnAction(event -> deleteItem());


        //Name column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        //PriceColumn
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(80);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        //Quantity Column
        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity ");
        quantityColumn.setMinWidth(80);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //NameInput
        nameInput = new TextField();
        nameInput.setPromptText("Product name");
        nameInput.setMinWidth(100);

        //Price input
        priceInput = new TextField();
        priceInput.setPromptText("Price");
        priceInput.setMaxWidth(100);

        //Quantity
        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");
        quantityInput.setMaxWidth(100);

        //Table
        table = new TableView<>();
        table.setItems(getProducts());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setSpacing(10);
        hbox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);


        //Vbox Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(table, hbox);

        //Scene
        Scene scene = new Scene(layout, 550, 300);

        //Window
        window.setTitle("Simple Window");
        window.setScene(scene);
        window.show();


    }

    public boolean checkPriceValue(String str) {
        try {
            Double.parseDouble(str);
            priceInput.setStyle("-fx-text-fill: BLACK;");
            return true;
        } catch (NumberFormatException e) {
            priceInput.setText("Wrong Format");
            priceInput.setStyle("-fx-text-fill: RED;");
            return false;
        }
    }

    private boolean checkQuantityValue(String productQuantity) {
        try {
            Integer.parseInt(productQuantity);
            quantityInput.setStyle("-fx-text-fill: BLACK;");
            return true;
        } catch (NumberFormatException e) {
            quantityInput.setText("Wrong Format");
            quantityInput.setStyle("-fx-text-fill: RED;");
            return false;
        }
    }

    private boolean valuesOk(){
        return (checkPriceValue(priceInput.getText()) & checkQuantityValue(quantityInput.getText())) ? true : false ;
    }

    private void checkAndAddItem() {

        String productName;
        double productPrice;
        int productQuantity;

        if (valuesOk()) {
            //assign values
            productPrice = Double.parseDouble(priceInput.getText());
            productQuantity = Integer.parseInt(quantityInput.getText());
            productName = nameInput.getText();
            //Add Item to store
            addItem(productName, productPrice, productQuantity);
        }

    }

    //Add item
    private void addItem(String productName, double productPrice, int quantity) {

        //create product
        Product product = new Product(productName, productPrice, quantity);

        //add product to the table
        table.getItems().add(product);

        //clear inputs
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    //Delete item
    private void deleteItem() {
        /*Bucky way
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();
        //remove selected Items
        productSelected.forEach(allProducts::remove);
        */
        /* Danca way */
        ObservableList<Product> selectedProducts = table.getSelectionModel().getSelectedItems();
        table.getItems().removeAll(selectedProducts);
        table.getSelectionModel().clearSelection();

    }

    //Get all the products
    public ObservableList<Product> getProducts() {
        //Observable list
        ObservableList<Product> listOfProducts = FXCollections.observableArrayList();

        //list of products
        listOfProducts.add(new Product("Laptop", 1200.00, 12));
        listOfProducts.add(new Product("Pc", 3253.00, 2));
        listOfProducts.add(new Product("Corn", 12.00, 62));
        listOfProducts.add(new Product("DVD", 32.49, 122));

        return listOfProducts;
    }


}
