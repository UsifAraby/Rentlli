package com.example.carrental;

public class Admin extends User{


    static int Aid=0;
    final int Admin_ID;

    public Admin(String first_Name,String last_Name,String email_Adress,String password,String phone_Number){
        super(first_Name,last_Name,email_Adress,password,phone_Number);
        Admin_ID=Aid;
        Aid++;

    }

    public int getAdmin_ID() {
        return Admin_ID;
    }
}
