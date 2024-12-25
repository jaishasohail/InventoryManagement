package com.example.inventorymanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPG {
    @FXML
    Button checkInventory;

    public void checkInventoryAction(ActionEvent e) throws IOException {
        FXMLLoader InventoryFX=new FXMLLoader(MainPG.class.getResource("Inventory.fxml"));
        HelloApplication.changeScene(InventoryFX);

    }
    public void Exit()  {
        Alert confirm =new Alert(Alert.AlertType.CONFIRMATION,"are you sure you want to exit?");
        confirm.showAndWait().ifPresent((response)->{
            if(response== ButtonType.OK){
                FXMLLoader FX=new FXMLLoader(MainPG.class.getResource("WelcomePG.fxml"));
                try {
                    HelloApplication.changeScene(FX);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        });

    }
    public void HistoryDET(){
        FXMLLoader FX=new FXMLLoader(MainPG.class.getResource("HistoryDetails.fxml"));
        try {
            HelloApplication.changeScene(FX);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
