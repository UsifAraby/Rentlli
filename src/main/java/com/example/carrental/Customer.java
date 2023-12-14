package com.example.carrental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Customer extends User {
    @FXML
    static int cid = 0;

    final int costumer_ID;


    String license;
    public Customer(){

        costumer_ID=cid;
        cid++;

    }
    public Customer(String first_Name, String last_Name, String email_Adress,String password, String phone_Number,String license) {

        super(first_Name, last_Name, email_Adress,password, phone_Number);
        costumer_ID = cid;
        cid++;
        this.license=license;
    }

    public void setLicense(String license) {
        this.license = license;
    }



    @Override
    public String toString() {
        return first_Name + "," + last_Name + "," + email_Adress + "," + password + "," + phone_Number + "," + license + "\n";
    }


}