module com.example.inventorymanagement {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.inventorymanagement to javafx.fxml;
    exports com.example.inventorymanagement;
}