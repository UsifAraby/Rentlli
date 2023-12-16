package com.example.carrental;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReadWriteData {

    public static ArrayList <Customer> customerContents = new ArrayList<>();
    public static ArrayList<Vehicle> vechicles_Content= new ArrayList<>();
    public static ArrayList<Invoice> Invoice_Content=new ArrayList<>();
   // public static ArrayList<Reservation_history> Reservation_Content=new ArrayList<>();

    public static void readInvoice() throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader("reservation.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length >= 6) {

                    Invoice invoice = new Invoice(parts[0], parts[1], parts[2], parts[3],parts[4],parts[5]);
                    /*Reservation_history reservation_history=new Reservation_history(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5] );
                    Reservation_Content.add(reservation_history);*/
                    Invoice_Content.add(invoice);
                } else {

                    System.out.println("Invalid data format in line: " + line);
                }
            }
        }
    }
    public static void writeInvoiceToFile() throws IOException{

        BufferedWriter writer = new BufferedWriter(new FileWriter("reservation.txt",true));
        System.out.println("writing...");
        for (Invoice invoice : Invoice_Content) {
            writer.write(invoice.toString());
            writer.newLine();
        }
        writer.close();
    }


    public static void readCustomers() throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader("customers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length >= 6) {

                    Customer customer = new Customer(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);


                    customerContents.add(customer);
                } else {

                    System.out.println("Invalid data format in line: " + line);
                }
            }
        }
    }


    public static void readVehicles() throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader("vehicles.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into parts using a delimiter (assuming it's, for example, a comma)
                String[] parts = line.split(",");

                if (parts.length >= 5) {
                    // Assuming your vehicle class has a constructor that accepts parameters like email, password, etc.
                    Vehicle vehicle = new Vehicle(parts[0], parts[1], parts[2], parts[3], parts[4],parts[5]);

                    // Add the created Customer object to the list
                    vechicles_Content.add(vehicle);
                    System.out.println(vechicles_Content);
                } else {
                    // Handle the case where the line doesn't have enough parts
                    System.out.println("Invalid data format in line: " + line);
                }
            }
        }
    }

    // Write the contents of the customerContents list to a file
    public static void writeCustomersToFile() throws IOException{
        //String filepath = "C:/Users/user/Desktop/Rentlli/customers.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter("customers.txt"));
        System.out.println("writing...");
        for (Customer customer : customerContents) {
            writer.write(customer.toString());
            writer.newLine();
        }
        writer.close();
    }


    // Check if an email exists in the customer list using streams
    public static boolean isEmailInList(String email) {
        return customerContents.stream()
                .anyMatch(customer -> customer.getEmail_Adress().equals(email));
    }

    // Check if a password exists in the customer list using streams
    public static boolean isPasswordInList(String password) {
        return customerContents.stream()
                .anyMatch(customer -> customer.getPassword().equals(password));
    }
/*
     public static String getCarPhotoPathById(String carId){
        return vechicles_Content.stream()
                .filter(vehicle -> vehicle.)
     }*/
}
