package com.example.carrental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Customer extends User {
    @FXML
    static int cid = 0;

    final int costumer_ID;


    public Customer(){
        cid++;
        costumer_ID=cid;
    }
    public Customer(String first_Name, String last_Name, String email_Adress, String phone_Number) {

        super(first_Name, last_Name, email_Adress, phone_Number);
        costumer_ID = cid;
        cid++;
    }

    @Override
    public String toString() {

        return  first_Name + "\n" + last_Name + "\n" + email_Adress+ "\n" +phone_Number;
    }

    public int getCostumer_ID() {
        return costumer_ID;
    }
}