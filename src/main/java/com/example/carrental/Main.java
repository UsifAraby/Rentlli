package com.example.carrental;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("loginScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Rentlli");
        stage.setScene(scene);
        stage.show();

        // Move the initialization logic here
        try {
            ReadWriteData.readCustomers();
            ReadWriteData.readVehicles();
            ReadWriteData.readInvoice();
            System.out.println(ReadWriteData.customerContents);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                ReadWriteData.writeCustomersToFile();
                ReadWriteData.writeVehiclesToFile();
                ReadWriteData.writeInvoiceToFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Program is closing. Performing cleanup actions...");
        }));

    }
}