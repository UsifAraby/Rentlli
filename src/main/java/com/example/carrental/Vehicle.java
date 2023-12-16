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
    String Price;
    String carAgency;
    private final String year_of_Manufacture;
    //public int num_of_Features;
    //String [] features;
    public int fuel_Level;
    public boolean rental_Status;
    public int rental_rate_per_Hour;

    public Vehicle( String licencePlate,String model, String make, String color, String yearOfManufacture,String Price,String carAgency, String photo_Path) {
        ve_Id=vehicle_Id;
        vehicle_Id++;

        this.licencePlate = licencePlate;
        this.model=model;
        this.make=make;
        this.color=color;
        this.year_of_Manufacture = yearOfManufacture;
        this.Price = Price;
        this.carAgency = carAgency;
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

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getMake() {
        return make;
    }

    public String getPrice() {
        return Price;
    }

    public String getCarAgency() {
        return carAgency;
    }

    public String getYear_of_Manufacture() {
        return year_of_Manufacture;
    }

    public String toString() {
        return licencePlate +"," + make + "," + model + "," + color + "," + year_of_Manufacture + "," + Price + "," + carAgency + "," + photo_Path + ","+"\n";
    }

}
