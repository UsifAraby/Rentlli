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

public class Invoice extends Reservation {

        private Stage stage;
        private Scene scene;
        private Parent root;
        @FXML
        public Label nl;
        @FXML
        public  Label phl;
        @FXML
        public  Label rll;
        @FXML
        public  Label pull;
        @FXML
        public  Label pudl;
        @FXML
        public  Label rdl;
        @FXML
        public  Label tcl;



        public void InvoiceSetting(String NameInput, String PhoneNumberInput, String PickUpLocationInput, String ReturnLocationInput, LocalDate PickUpDateInput, LocalDate ReturnDateInput) throws IOException {
            nl.setText(NameInput);
            phl.setText(PhoneNumberInput);
            pull.setText(PickUpLocationInput);
            rll.setText(ReturnLocationInput);
            pudl.setText(String.valueOf(PickUpDateInput));
            rdl.setText(String.valueOf(ReturnDateInput));

        }
        public void Back(ActionEvent event3) throws IOException{
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
        public void ReservationHistory(ActionEvent event2) throws IOException{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Reservation History.fxml"));
            root = loader.load();

            Reservation_history reservation_history = loader.getController();

            FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), root);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            stage=(Stage)((Node)event2.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

