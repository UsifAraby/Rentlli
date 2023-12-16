package com.example.carrental;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDate;

public class Reservation_history extends Reservation {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public Reservation_history(String nameInput, String phoneNumberInput, String pickUpLocationInput, String returnLocationInput, String pickUpDateInput,String returnDateInput) {
        super(nameInput, phoneNumberInput, pickUpLocationInput, returnLocationInput,pickUpDateInput,returnDateInput);
    }


    public void Back(ActionEvent event3) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReservScene.fxml"));
        root = loader.load();

        Reservation reservation = loader.getController();

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), root);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

        stage=(Stage)((Node)event3.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}