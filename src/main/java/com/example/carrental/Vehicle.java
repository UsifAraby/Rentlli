package com.example.carrental;

import javafx.scene.image.Image;

public class Vehicle {
    private Image photo;
    public static  int  vehicle_Id;
    public int ve_Id;
    private String model;
    private String color;
    private String make;
    private final String year_of_Manufacture;
    //public int num_of_Features;
    //String [] features;
    public int fuel_Level;
    public boolean rental_Status;
    public int rental_rate_per_Hour;

    public Vehicle( String model, String make, String color, String yearOfManufacture, String photo_Path) {
        ve_Id=vehicle_Id;
        vehicle_Id++;


        this.model=model;
        this.make=make;
        this.color=color;
        year_of_Manufacture = yearOfManufacture;
        this.photo= new Image(photo_Path);

    }

    public Image getPhoto() {
        return photo;
    }
    public String toString() {
        return vehicle_Id +"," + model + "," + make + "," + color + "," + year_of_Manufacture + "," + photo + ","+"\n";
    }
}
