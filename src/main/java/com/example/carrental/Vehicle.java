package com.example.carrental;

import javafx.scene.image.Image;

public class Vehicle {
    //private Image photo;
    public static  int  vehicle_Id = 0;
    public final int ve_Id;
    private String model;
    private String color;
    private String make;
    String licencePlate;
    String photo_Path;
    private final String year_of_Manufacture;
    //public int num_of_Features;
    //String [] features;
    public int fuel_Level;
    public boolean rental_Status;
    public int rental_rate_per_Hour;

    public Vehicle( String licencePlate,String model, String make, String color, String yearOfManufacture, String photo_Path) {
        ve_Id=vehicle_Id;
        vehicle_Id++;

        this.licencePlate = licencePlate;
        this.model=model;
        this.make=make;
        this.color=color;
        year_of_Manufacture = yearOfManufacture;
        this.photo_Path = photo_Path;
       // this.photo= new Image(photo_Path);

    }

    public String getPhoto() {
        return photo_Path;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public static int getVehicle_Id() {
        return vehicle_Id;
    }

    public int getVe_Id() {
        return ve_Id;
    }

    public String toString() {
        return licencePlate +"," + model + "," + make + "," + color + "," + year_of_Manufacture + "," + photo_Path + ","+"\n";
    }
}
