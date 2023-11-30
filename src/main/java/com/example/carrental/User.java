package com.example.carrental;


abstract public class User {
    protected String first_Name;
    protected String last_Name;
    protected int phone_Number;
    protected String email_Adress;
    public User (String first_Name,String last_Name,String email_Adress,int phone_Number) {

        this.first_Name=first_Name;
        this.last_Name=last_Name;
        this.email_Adress=email_Adress;
        this.phone_Number=phone_Number;


    }

    public String getFirst_Name() {
        return first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public int getPhone_Number() {
        return phone_Number;
    }

    public String getEmail_Adress() {
        return email_Adress;
    }
}
