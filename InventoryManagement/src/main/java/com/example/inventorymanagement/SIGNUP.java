package com.example.inventorymanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.util.ArrayList;

public class SIGNUP {
    @FXML
    private ToggleGroup grp;
    @FXML
    private TextField nameEmp;
     static String name;
    @FXML
    private TextField CNICemp;
     static String cnic;
    @FXML
    private TextField addressEmp;
     static String adress;
    @FXML
    private TextField EmailEmp;
     static String email;
    @FXML
    private TextField phoneEmp;
     static String phone;
    @FXML
    private TextField AgeEmp;
     static String age;
     static String gender="";
    @FXML
    private RadioButton M;
    @FXML
    private RadioButton F;

    public void onActionBack() throws IOException {
        FXMLLoader fxml =new FXMLLoader(WelcomePG.class.getResource("WelcomePG.fxml"));
        HelloApplication.changeScene(fxml);


    }
    public void onAcN() throws IOException {
        try{

            name=nameEmp.getText();
            adress=addressEmp.getText();
            cnic=CNICemp.getText();
            email=EmailEmp.getText();
            phone=phoneEmp.getText();
            age=AgeEmp.getText();
            int age=Integer.parseInt(AgeEmp.getText());
            if(nameEmp.getText().isEmpty() || addressEmp.getText().isEmpty() || CNICemp.getText().isEmpty() || EmailEmp.getText().isEmpty() || phoneEmp.getText().isEmpty() || gender.equals("") || AgeEmp.getText().isEmpty()){
                Alert alert=new Alert(Alert.AlertType.ERROR,"please fill in all fields!");
                alert.showAndWait();
            }
            if(!cnicValidation(CNICemp.getText())){
                Alert alert=new Alert(Alert.AlertType.ERROR,"invalid CNIC!");
                alert.showAndWait();
            }
            if(!emailValidation(EmailEmp.getText())){
                Alert alert=new Alert(Alert.AlertType.ERROR,"invalid email!");
                alert.showAndWait();
            }

            else{

                FXMLLoader fxml =new FXMLLoader(WelcomePG.class.getResource("SETTING.fxml"));
                HelloApplication.changeScene(fxml);

            }
        }
        catch(NumberFormatException nfe){
            Alert alert=new Alert(Alert.AlertType.ERROR,"invalid age!");
            alert.showAndWait();
        }

    }
    public void Radio(){
        if(M.isSelected())
            gender="Male";
        else if(F.isSelected())
            gender="Female";


    }
    public boolean cnicValidation(String cnic){
        if(cnic.matches("\\d{5}-\\d{7}-\\d{1}"))
            return true;
        else{
            return false;
        }

    }
    public boolean emailValidation(String email){
        if(email.contains("@gmail.com"))
            return true;
        else{
            return false;
        }

    }



}
