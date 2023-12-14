package com.example.carrental;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Reservation {

        public static int ReservationID;
        public int CarID; public int CustomerID;
        public int PickUpDate;
        public int ReturnDate;
        public float TotalCost;
        public String PickUpLocation;
        public String ReturnLocation;
        public String Status;
        public int CuID;
        public int RID;
        @FXML
        public TextField tc;
        @FXML
        public TextField pul;
        @FXML
        public TextField rel;
        @FXML
        public TextField n;
        @FXML
        public TextField ph;
        @FXML
        public DatePicker red;
        @FXML
        public DatePicker pud;

        @FXML
        public AnchorPane rootPane;

        private Stage stage;
        private Scene scene;
        private Parent root;
        @FXML
        public Button submitButton;
        Alert ERROR = new Alert(Alert.AlertType.ERROR);


   /*public Reservation(int cuID, int ReservationID){
        CuID = cuID;
        RID=ReservationID;
        ReservationID++;
    }*/

        public static void setReservationID(int reservationID) {
            ReservationID = reservationID;

        }

        public static int getReservationID() {
            return ReservationID;
        }

        public void setPickUpLocation(String pickUpLocation) {
            PickUpLocation = pickUpLocation;
        }

        public String getPickUpLocation() {
            return PickUpLocation;
        }
        public void setReturnLocation(String returnLocation) {
            ReturnLocation = returnLocation;
        }

        public String getReturnLocation() {
            return ReturnLocation;
        }

        public void setPickUpDate(int pickUpDate) {
            PickUpDate = pickUpDate;
        }

        public int getPickUpDate() {
            return PickUpDate;
        }

        public void setReturnDate(int returnDate) {
            ReturnDate = returnDate;
        }

        public int getReturnDate() {
            return ReturnDate;
        }

        public void setTotalCost(float totalCost) {
            TotalCost = totalCost;
        }

        public float getTotalCost() {
            return TotalCost;
        }

        public void setStatus(String status) {
            Status = status;
        }

        public String getStatus() {
            return Status;
        }

//methods

        public boolean isNumeric(String str) {
            return str.matches("\\d*");
        }
        public void submit(ActionEvent event) throws IOException {

            String NameInput = n.getText();
            String PickUpLocationInput=pul.getText();
            String ReturnLocationInput=rel.getText();
            String PhoneNumberInput=ph.getText();
            LocalDate PickUpDateInput=pud.getValue();
            LocalDate ReturnDateInput=red.getValue();

            if(!n.getText().isEmpty()&&!ph.getText().isEmpty()&&!pul.getText().isEmpty()&&!rel.getText().isEmpty()&&pud.getValue()!=null&&red.getValue()!=null) {
                if(isNumeric(ph.getText()))
                {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("InvScene.fxml"));
                    root = loader.load();

                    Invoice invoice = loader.getController();
                    invoice.InvoiceSetting(NameInput, PhoneNumberInput, PickUpLocationInput, ReturnLocationInput, PickUpDateInput, ReturnDateInput);


                    FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), root);
                    fadeTransition.setFromValue(0);
                    fadeTransition.setToValue(1);
                    fadeTransition.play();

                    WriteToResrvFile("reservation.txt", NameInput, PickUpLocationInput, ReturnLocationInput, PhoneNumberInput, PickUpDateInput, ReturnDateInput);
                }
                else {
                    ERROR.setHeaderText("The Phone Number Must Be A Number!");
                    ERROR.showAndWait();
                }
            }
            else {
                ERROR.setTitle("ERROR");
                ERROR.setHeaderText("Please Fill All The Required Inputs To Reserve The Car!");
                ERROR.showAndWait();
            }

            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
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

        private void WriteToResrvFile(String ReservFile, String Name,String PickUpLocation,String ReturnLocation,String PhoneNumber,LocalDate PickUpDate,LocalDate ReturnDate) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(ReservFile,true))) {
                writer.write(Name+"/"+PickUpLocation+"/"+ReturnLocation+"/"+ PhoneNumber+"/"+PickUpDate+"/"+ReturnDate + System.lineSeparator());
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }





