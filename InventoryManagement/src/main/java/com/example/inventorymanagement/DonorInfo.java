package com.example.inventorymanagement;
import java.io.Serializable;

public class DonorInfo implements Serializable{
    private int ID;
    private String name;
    private String CNIC;
    private String phoneNO;
    private String bloodType;
    private String Address;
    private String city;
    private int age;
    private String gender;

    public DonorInfo() {
    }

    public DonorInfo(int ID, String name, String CNIC, String phoneNO, String bloodType, String address, String city, int age, String gender) {
        this.ID = ID;
        this.name = name;
        this.CNIC = CNIC;
        this.phoneNO = phoneNO;
        this.bloodType = bloodType;
        Address = address;
        this.city = city;
        this.age = age;
        this.gender = gender;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

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

    public String getPhoneNO() {
        return phoneNO;
    }

    public void setPhoneNO(String phoneNO) {
        this.phoneNO = phoneNO;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
