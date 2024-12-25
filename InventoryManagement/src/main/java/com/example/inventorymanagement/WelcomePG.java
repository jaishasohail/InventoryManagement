package com.example.inventorymanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.io.IOException;

public class WelcomePG {
    @FXML
    Button loggedOn;
    @FXML
    Button signUP;
    @FXML
    Button exiting;
    public void onActionLog() throws IOException {
        FXMLLoader fxml =new FXMLLoader(WelcomePG.class.getResource("LOGIN.fxml"));
        HelloApplication.changeScene(fxml);


    }
    public void onActionSig() throws IOException {
        FXMLLoader fxml =new FXMLLoader(WelcomePG.class.getResource("SIGN UP.fxml"));
        HelloApplication.changeScene(fxml);


    }
    public void onActionExit(){
        Alert confirm =new Alert(Alert.AlertType.CONFIRMATION,"are you sure you want to exit?");
        confirm.showAndWait().ifPresent((response)->{
            if(response==ButtonType.OK){
                System.exit(0);
            }

        });


    }

}
