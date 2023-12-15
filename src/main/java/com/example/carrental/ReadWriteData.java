package com.example.carrental;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReadWriteData {

    public static ArrayList <Customer> customerContents = new ArrayList<>();
    public static ArrayList<Vehicle> vechicles_Content= new ArrayList<>();
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
                String[] parts = line.split(",");

                if (parts.length >= 5) {

                    Vehicle vehicle = new Vehicle(parts[0], parts[1], parts[2], parts[3], parts[4],parts[5]);

                    vechicles_Content.add(vehicle);
                    System.out.println(vechicles_Content);
                } else {
                    System.out.println("Invalid data format in line: " + line);
                }
            }
        }
    }

    public static void writeCustomersToFile() throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("customers.txt"));
        System.out.println("writing...");
        for (Customer customer : customerContents) {
            writer.write(customer.toString());
            writer.newLine();
        }
        writer.close();
    }


    public static boolean isEmailInList(String email) {
        return customerContents.stream()
                .anyMatch(customer -> customer.getEmail_Adress().equals(email));
    }

    public static boolean isPasswordInList(String password) {
        return customerContents.stream()
                .anyMatch(customer -> customer.getPassword().equals(password));
    }

}
