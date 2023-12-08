package com.example.carrental;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReadWriteData {

    public static ArrayList <Customer> customerContents = new ArrayList<>();
    public static ArrayList<Vehicle> vechicles_Content= new ArrayList<>();
    public static void readCustomers() throws IOException {
        //String filepath = "C:/Users/user/Desktop/Rentlli/customers.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader("customers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into parts using a delimiter (assuming it's, for example, a comma)
                String[] parts = line.split(",");

                if (parts.length >= 6) {
                    // Assuing your Customer class has a constructor that accepts parameters like email, password, etc.
                    Customer customer = new Customer(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);

                    // Add the created Customer object to the list
                    customerContents.add(customer);
                } else {
                    // Handle the case where the line doesn't have enough parts
                    System.out.println("Invalid data format in line: " + line);
                }
            }
        }
    }
    public static void readVehicles() throws IOException {
        //String filepath = "C:/Users/user/Desktop/Rentlli/customers.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader("vehicles.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into parts using a delimiter (assuming it's, for example, a comma)
                String[] parts = line.split(",");

                if (parts.length >= 6) {
                    // Assuing your Customer class has a constructor that accepts parameters like email, password, etc.
                    Customer customer = new Customer(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);

                    // Add the created Customer object to the list
                    customerContents.add(customer);
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

}
