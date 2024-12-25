package com.example.inventorymanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Inventory implements Initializable, Serializable {
    @FXML
    private TableView<DonorInfo> table;
    @FXML
    private TableColumn<DonorInfo,Integer> id;
    @FXML
    private TableColumn<DonorInfo,String> Name;
    @FXML
    private TableColumn<DonorInfo,String> CNIC1;
    @FXML
    private TableColumn<DonorInfo,String> Phone;
    @FXML
    private TableColumn<DonorInfo,String> blood;
    @FXML
    private TableColumn<DonorInfo,String> address;
    @FXML
    private TableColumn<DonorInfo,String> city2;
    @FXML
    private TableColumn<DonorInfo,Integer> aging;
    @FXML
    private TableColumn<DonorInfo,String> MYG;
    static ObservableList<DonorInfo>  list;
    @FXML
    private Button ADD;
    @FXML
    private Button Delete;
    @FXML
    private TextField Id;
    @FXML
    private TextField namae;
    @FXML
    private TextField cnic;
    @FXML
    private TextField phones;
    @FXML
    private TextField bloodG;
    @FXML
    private TextField addr;
    @FXML
    private TextField cities;
    @FXML
    private TextField AGE;
    @FXML
    private TextField G;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        try {

            list =FXCollections.observableArrayList(HelloApplication.FileLoader());
            this.id.setCellValueFactory(new PropertyValueFactory<>("ID"));
            this.Name.setCellValueFactory(new PropertyValueFactory<>("name"));
            this.CNIC1.setCellValueFactory(new PropertyValueFactory<>("CNIC"));
            this.Phone.setCellValueFactory(new PropertyValueFactory<>("phoneNO"));
            this.blood.setCellValueFactory(new PropertyValueFactory<>("bloodType"));
            this.address.setCellValueFactory(new PropertyValueFactory<>("Address"));
            this.city2.setCellValueFactory(new PropertyValueFactory<>("city"));
            this.aging.setCellValueFactory(new PropertyValueFactory<>("age"));
            this.MYG.setCellValueFactory(new PropertyValueFactory<>("gender"));

            this.table.setItems(list);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
    public void AddButtonAction(){

            try{
                ArrayList<history> R1=new ArrayList<>();
                if(Id.getText().isEmpty() || namae.getText().isEmpty() || cnic.getText().isEmpty() || phones.getText().isEmpty() || bloodG.getText().isEmpty() || addr.getText().isEmpty() || cities.getText().isEmpty() || AGE.getText().isEmpty() || G.getText().isEmpty() ){
                    Alert error=new Alert(Alert.AlertType.ERROR,"enter the feilds to add!");
                    error.showAndWait();
                    return;
                }
                if(!cnicValidation(cnic.getText())) {
                    Alert error = new Alert(Alert.AlertType.ERROR, "invalid cnic!");
                    error.showAndWait();
                    return;
                }




                int newID = Integer.parseInt(Id.getText());
                boolean exists = false;

                for (DonorInfo donors : list) {
                    if (donors.getID() == newID) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    Alert error = new Alert(Alert.AlertType.ERROR, "Don't add elements with the same ID!");
                    error.showAndWait();
                    return;
                }


                DonorInfo donor = new DonorInfo(newID, namae.getText(), cnic.getText(), phones.getText(), bloodG.getText(), addr.getText(), cities.getText(), Integer.parseInt(AGE.getText()), G.getText());
                list.add(donor);


                history hs=new history(donor.getID(), donor.getName(),donor.getCNIC(),donor.getPhoneNO(),donor.getBloodType(),donor.getAddress(),donor.getCity(),donor.getAge(),donor.getGender(),"recieved");



                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("DONORS.ser"))) {
                    for (DonorInfo student : list) {
                        output.writeObject(student);
                    }
                } catch (IOException e) {
                    System.err.println(e);
                }
                Id.setText("");
                namae.setText("");
                cnic.setText("");
                phones.setText("");
                bloodG.setText("");
                addr.setText("");
                cities.setText("");
                AGE.setText("");
                G.setText("");
                try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("history.ser")))) {
                    while (true) {
                        try {
                            history object = (history) input.readObject();
                            R1.add(object);
                        } catch (EOFException e) {
                            R1.add(hs);
                            break;
                        }
                    }
                } catch (IOException | ClassNotFoundException e) {
                    handleErrorAndExit("Error updating student or reading file. Terminating the program.", e);
                }

                try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get("history.ser")))) {
                    for (history employee : R1) {
                        output.writeObject(employee);
                    }
                } catch (IOException e) {
                    handleErrorAndExit("Error writing to file. Terminating the program.", e);
                }

            }
            catch(NumberFormatException nfe){
                Alert error = new Alert(Alert.AlertType.ERROR, "invalid ID or age!");
                error.showAndWait();


            }







    }

    public void DeleteButtonAc(){
        ArrayList<history> R2=new ArrayList<>();
        Alert confirm =new Alert(Alert.AlertType.CONFIRMATION,"are you sure you want to delete?");
        confirm.showAndWait().ifPresent((response)->{
            if(response==ButtonType.OK){

                DonorInfo selected=table.getSelectionModel().getSelectedItem();
                history hss=new history(selected.getID(), selected.getName(),selected.getCNIC(),selected.getPhoneNO(),selected.getBloodType(),selected.getAddress(),selected.getCity(),selected.getAge(),selected.getGender(),"donated");

                list.remove(selected);



                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("DONORS.ser"))) {
                    for (DonorInfo student : list) {
                        output.writeObject(student);
                    }
                } catch (IOException e) {
                    System.err.println(e);
                }
                try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("history.ser")))) {
                    while (true) {
                        try {
                            history object = (history) input.readObject();
                            R2.add(object);
                        } catch (EOFException e) {
                            R2.add(hss);
                            break;
                        }
                    }
                } catch (IOException | ClassNotFoundException e) {
                    handleErrorAndExit("Error updating student or reading file. Terminating the program.", e);
                }

                try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get("history.ser")))) {
                    for (history employee : R2) {
                        output.writeObject(employee);
                    }
                } catch (IOException e) {
                    handleErrorAndExit("Error writing to file. Terminating the program.", e);
                }


            }

        });



    }
    public void backing() throws IOException {
        FXMLLoader fxml=new FXMLLoader(Inventory.class.getResource("MainPG.fxml"));
        HelloApplication.changeScene(fxml);
    }
    private static void handleErrorAndExit(String message, Exception exception) {
        System.err.println(message);
        if (exception != null) {
            exception.printStackTrace();
        }
        System.exit(1);
    }
    public boolean cnicValidation(String cnic){
        if(cnic.matches("\\d{5}-\\d{7}-\\d{1}"))
            return true;
        else{
            return false;
        }

    }


}
