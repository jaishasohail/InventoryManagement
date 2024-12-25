package com.example.inventorymanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SETTING {
    @FXML
    private  TextField userName;
    @FXML
    private  TextField password;
    @FXML
    private TextField confirmIT;
    @FXML
    private Button Finish;
    @FXML
    private Button back;
    private  Employee emp;
    @FXML
    private Label confirming;



    public void backB() throws IOException {
        FXMLLoader fxml=new FXMLLoader(SETTING.class.getResource("SIGN UP.fxml"));
        HelloApplication.changeScene(fxml);
    }
    public void finishB() throws IOException {

        ArrayList<Employee> list=new ArrayList<>();
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("Employee.ser")))) {
            while (true) {
                Employee object = (Employee) input.readObject();
                list.add(object);

            }
        } catch (EOFException e) {



        } catch (IOException | ClassNotFoundException e) {
            handleErrorAndExit("Error updating student or reading file. Terminating the program.", e);
        }
        if(!confirmIT.getText().equals(password.getText())){
            confirming.setText("must be same as above");
            return;

        }
        String user = userName.getText();
        boolean exists = false;

        for (Employee emps : list) {
            if (Objects.equals(emps.getUserName(), user)) {
                exists = true;
                break;
            }
        }

        if (exists) {
            Alert error = new Alert(Alert.AlertType.ERROR, "user name already exists!");
            error.showAndWait();
            return;
        }
        emp=new Employee(SIGNUP.name,SIGNUP.cnic,SIGNUP.email,SIGNUP.phone,SIGNUP.adress,SIGNUP.gender,Integer.parseInt(SIGNUP.age),password.getText(),userName.getText());

        List<Employee> employeeList = new ArrayList<>();

        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("Employee.ser")))) {
            while (true) {
                Employee object = (Employee) input.readObject();
                    employeeList.add(object);

            }
        } catch (EOFException e) {
            employeeList.add(emp);


        } catch (IOException | ClassNotFoundException e) {
            handleErrorAndExit("Error updating student or reading file. Terminating the program.", e);
        }

        try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get("Employee.ser")))) {
            for (Employee employee : employeeList) {
                output.writeObject(employee);
            }
        } catch (IOException e) {
            handleErrorAndExit("Error writing to file. Terminating the program.", e);
        }
        FXMLLoader fxml=new FXMLLoader(SETTING.class.getResource("SIGNEDIN.fxml"));
        HelloApplication.changeScene(fxml);



    }
    private static void handleErrorAndExit(String message, Exception exception) {
        System.err.println(message);
        if (exception != null) {
            exception.printStackTrace();
        }
        System.exit(1);
    }
}
