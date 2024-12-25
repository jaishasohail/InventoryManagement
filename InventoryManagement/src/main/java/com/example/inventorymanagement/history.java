package com.example.inventorymanagement;


import java.io.Serializable;

public class history extends DonorInfo implements Serializable {
    public enum status{
        RECIEVED,
        DONATED


    }

    String stat;

    public history(int ID, String name, String CNIC, String phoneNO, String bloodType, String address, String city, int age, String gender,String stating) {
        super(ID, name, CNIC, phoneNO, bloodType, address, city, age, gender);
        this.stat=Stat(stating);

    }
    public String Stat(String input){
        if(input.equalsIgnoreCase(status.RECIEVED.toString())){
            return "Recieved";
        }
        else if (input.equalsIgnoreCase(status.DONATED.toString())){
            return "Donated";
        }
        else
            return "-";


    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
