package xxx.yyy;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {
    private TableView<InventoryItem> table;
    private ObservableList<InventoryItem> data;
    private TextField nameField, quantityField, priceField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Inventory Management");

        // Initialize TableView and data
        table = new TableView<>();
        data = FXCollections.observableArrayList();
        table.setItems(data);

        // Table columns for Item Name, Quantity, and Price
        TableColumn<InventoryItem, String> nameColumn = new TableColumn<>("Item Name");
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));

        TableColumn<InventoryItem, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getQuantity()).asObject());

        TableColumn<InventoryItem, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());

        table.getColumns().add(nameColumn);
        table.getColumns().add(quantityColumn);
        table.getColumns().add(priceColumn);

        // Form fields for input
        nameField = new TextField();
        quantityField = new TextField();
        priceField = new TextField();

        nameField.setPromptText("Item Name");
        quantityField.setPromptText("Quantity");
        priceField.setPromptText("Price");

        // Buttons for CRUD operations
        Button addButton = new Button("Add Item");
        Button updateButton = new Button("Update Item");
        Button deleteButton = new Button("Delete Item");

        // Add item functionality
        addButton.setOnAction(e -> addItem());

        // Update item functionality
        updateButton.setOnAction(e -> updateItem());

        // Delete item functionality
        deleteButton.setOnAction(e -> deleteItem());

        // Layout for form and buttons
        HBox formLayout = new HBox(10, nameField, quantityField, priceField);
        HBox buttonLayout = new HBox(10, addButton, updateButton, deleteButton);
        VBox mainLayout = new VBox(10, table, formLayout, buttonLayout);

        // Scene setup
        Scene scene = new Scene(mainLayout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Add item method
    private void addItem() {
        try {
            String name = nameField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());

            // Create a new InventoryItem and add to the list
            InventoryItem item = new InventoryItem(name, quantity, price);
            data.add(item);

            // Clear the input fields
            nameField.clear();
            quantityField.clear();
            priceField.clear();
        } catch (NumberFormatException e) {
            showErrorMessage("Invalid input. Please enter valid numbers for quantity and price.");
        }
    }

    // Update item method
    private void updateItem() {
        InventoryItem selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            try {
                selectedItem.setName(nameField.getText());
                selectedItem.setQuantity(Integer.parseInt(quantityField.getText()));
                selectedItem.setPrice(Double.parseDouble(priceField.getText()));

                // Refresh the table
                table.refresh();

                // Clear the input fields
                nameField.clear();
                quantityField.clear();
                priceField.clear();
            } catch (NumberFormatException e) {
                showErrorMessage("Invalid input. Please enter valid numbers for quantity and price.");
            }
        }
    }

    // Delete item method
    private void deleteItem() {
        InventoryItem selectedItem = table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            data.remove(selectedItem);
        } else {
            showErrorMessage("Please select an item to delete.");
        }
    }

    // Show error message
    private void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
