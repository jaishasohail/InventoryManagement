package com.example.inventorymanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class HistoryDetails implements Initializable, Serializable {
    @FXML
    private TableView<history> table;
    @FXML
    private TableColumn<history,Integer> id;
    @FXML
    private TableColumn<history,String> Name;
    @FXML
    private TableColumn<history,String> CNIC1;
    @FXML
    private TableColumn<history,String> Phone;
    @FXML
    private TableColumn<history,String> blood;
    @FXML
    private TableColumn<history,String> address;
    @FXML
    private TableColumn<history,String> city2;
    @FXML
    private TableColumn<history,Integer> aging;
    @FXML
    private TableColumn<history,String> MYG;
    @FXML
    private TableColumn<history,String> stats;
    static ObservableList<history> list;

    public void onActionB() throws IOException {
        FXMLLoader fxml =new FXMLLoader(WelcomePG.class.getResource("MainPG.fxml"));
        HelloApplication.changeScene(fxml);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            list =FXCollections.observableArrayList(HelloApplication.FileLoader1());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.id.setCellValueFactory(new PropertyValueFactory<>("ID"));
            this.Name.setCellValueFactory(new PropertyValueFactory<>("name"));
            this.CNIC1.setCellValueFactory(new PropertyValueFactory<>("CNIC"));
            this.Phone.setCellValueFactory(new PropertyValueFactory<>("phoneNO"));
            this.blood.setCellValueFactory(new PropertyValueFactory<>("bloodType"));
            this.address.setCellValueFactory(new PropertyValueFactory<>("Address"));
            this.city2.setCellValueFactory(new PropertyValueFactory<>("city"));
            this.aging.setCellValueFactory(new PropertyValueFactory<>("age"));
            this.MYG.setCellValueFactory(new PropertyValueFactory<>("gender"));
            this.stats.setCellValueFactory(new PropertyValueFactory<>("stat"));

            this.table.setItems(list);


    }
}
