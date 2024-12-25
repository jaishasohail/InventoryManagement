package com.example.inventorymanagement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HelloApplication extends Application {

    static Stage window;
    static ObjectOutputStream objOut;
    static ObjectInputStream objIn;

    @Override
    public void start(Stage stage) throws IOException {
        window=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WelcomePG.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Inventory system");
        stage.setScene(scene);
        stage.show();
    }
    public static void changeScene(FXMLLoader fxml) throws IOException {
        window.setScene(new Scene(fxml.load()));
        window.show();
    }
    public static void FileOpenW() throws IOException {
        objOut=new ObjectOutputStream(Files.newOutputStream(Paths.get("DONORS.ser")));


    }
    public static void Filewriter()  {
        try {

            objOut.writeObject(new DonorInfo(1,"ishfaq","35101-780-7726-4","03949823498","B+","Dera Chowk","lahore",18,"M"));
            objOut.writeObject(new DonorInfo(2,"hadia","35200-780-7734-4","03949823498","AB+","Dera Chowk","lahore",23,"F"));
            objOut.writeObject(new DonorInfo(3,"jaisha","35101-780-7726-4","03949823498","A+","Dera Chowk","lahore",22,"F"));
            objOut.writeObject(new DonorInfo(4,"noor jahan","35101-780-7726-4","03949823498","B-","Dera Chowk","lahore",30,"F"));
            objOut.writeObject(new DonorInfo(5,"ghulam","35101-780-7726-4","03949823498","O-","Dera Chowk","lahore",55,"M"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static void closeW(){
        if(objOut !=null){
            try {
                objOut.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static ObservableList<DonorInfo> FileLoader() throws IOException {
        ObservableList<DonorInfo> obs = FXCollections.observableArrayList();
        try {
            objIn = new ObjectInputStream(new FileInputStream("DONORS.ser"));
            while (true) {

                    DonorInfo di = (DonorInfo) objIn.readObject();
                    obs.add(di);



            }
        }
        catch (EOFException e) {

            return obs;


        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);

        }


    }
    public static ObservableList<history> FileLoader1() throws IOException {
        ObservableList<history> obs = FXCollections.observableArrayList();
        try {
            objIn = new ObjectInputStream(new FileInputStream("history.ser"));
            while (true) {

                history di = (history) objIn.readObject();
                obs.add(di);



            }
        }
        catch (EOFException e) {

            return obs;


        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);

        }


    }


    public static void main(String[] args) {
        launch();
    }
}