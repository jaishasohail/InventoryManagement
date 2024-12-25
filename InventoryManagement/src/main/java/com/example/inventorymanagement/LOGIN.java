package com.example.inventorymanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LOGIN {
    @FXML
    Button backingAway;
    @FXML
    Button loggingIn;
    @FXML
    TextField userN;
    @FXML
    TextField pass;

    public void onActionBack() throws IOException {

        FXMLLoader fxml = new FXMLLoader(WelcomePG.class.getResource("WelcomePG.fxml"));
        HelloApplication.changeScene(fxml);

    }

    public void loggingInB()  {

        boolean TF=false;

        if (userN.getText().isEmpty() || pass.getText().isEmpty()) {
            Alert alertMSG = new Alert(Alert.AlertType.ERROR, "enter the fields properly!");
            alertMSG.showAndWait();
        }
        else{
            try (ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(Paths.get("Employee.ser")))) {
                while (true) {
                    try {
                        Employee employee = (Employee) inputStream.readObject();
                        if((employee.getUserName()).equals(userN.getText()) && (employee.getPassword()).equals(pass.getText())){
                            FXMLLoader fxml =new FXMLLoader(LOGIN.class.getResource("MainPG.fxml"));
                            HelloApplication.changeScene(fxml);
                            TF=true;
                            return;
                        }

                    }catch (EOFException e) {
                            break;
                        }
                    catch (ClassNotFoundException | IOException e) {
                        e.printStackTrace();
                        break; // Exit loop on any error
                    }

                }
            }  catch (IOException e) {
                e.printStackTrace();
            }
            if(!TF){
                Alert alertMSG1 = new Alert(Alert.AlertType.ERROR, "user not found!");
                alertMSG1.showAndWait();
            }

        }

    }
}
