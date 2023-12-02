package com.example.carrental;

public class Admin extends User{


    static int Aid=0;
    final int Admin_ID;

    public Admin(String first_Name,String last_Name,String email_Adress,String phone_Number,String password){
        super(first_Name,last_Name,email_Adress,phone_Number,password);
        Admin_ID=Aid;
        Aid++;

    }

    public int getAdmin_ID() {
        return Admin_ID;
    }
}
