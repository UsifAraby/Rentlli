package com.example.carrental;


abstract public class User {
    protected String first_Name;
    protected String last_Name;
    protected String phone_Number;
    protected String email_Adress;
    public String password;

    public User (String first_Name, String last_Name, String email_Adress, String phone_Number, String password) {

        this.first_Name=first_Name;
        this.last_Name=last_Name;
        this.email_Adress=email_Adress;
        this.phone_Number=phone_Number;
        this.password=password;

    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

    public void setEmail_Adress(String email_Adress) {
        this.email_Adress = email_Adress;
    }

    public String getPassword() {
        return password;
    }

    protected User() {
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public String getEmail_Adress() {
        return email_Adress;
    }
}
