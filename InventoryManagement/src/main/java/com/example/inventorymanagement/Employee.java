package com.example.inventorymanagement;

import java.io.Serializable;


public class Employee implements Serializable {
    private String name;
    private String CNIC;
    private String Email;
    private String phone;
    private String Address;

    private String gender;
    private int age;
    private String password;
    private String userName;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Employee(String name, String CNIC, String email, String phone, String address, String gender, int age, String password, String userName) {
        this.name = name;
        this.CNIC = CNIC;
        Email = email;
        this.phone = phone;
        Address = address;
        this.gender = gender;
        this.age = age;
        this.password = password;
        this.userName = userName;
    }


}
