package com.example.inventorymanagement;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;

public class SIGNEDIN {
    public void back() throws IOException {
        FXMLLoader fxml=new FXMLLoader(SETTING.class.getResource("WelcomePG.fxml"));
        HelloApplication.changeScene(fxml);

    }
    public void exit(){
        Alert confirm =new Alert(Alert.AlertType.CONFIRMATION,"are you sure you want to exit?");
        confirm.showAndWait().ifPresent((response)->{
            if(response== ButtonType.OK){
                System.exit(0);
            }

        });


    }
}
