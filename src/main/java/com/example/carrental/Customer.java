package com.example.carrental;

public class Customer extends User {
    static int cid = 0;

    final int costumer_ID;

    public Customer(String first_Name, String last_Name, String email_Adress, int phone_Number) {

        super(first_Name, last_Name, email_Adress, phone_Number);
        costumer_ID = cid;
        cid++;
    }


    public int getCostumer_ID() {
        return costumer_ID;
    }
}