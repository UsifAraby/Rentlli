package com.example.carrental;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static com.example.carrental.Reservation.ResId;

public class Reservation_history implements Initializable  {


    public String NameInput;
    public String PhoneNumberInput;
    public String PickUpLocationInput;
    public String ReturnLocationInput;
    public String PickUpDateInput;
    public String ReturnDateInput;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    ScrollPane scrollPane;
    @FXML
    VBox vBox;
    @FXML
    Label reservatoinname,reservatoinnnumber,reservatoinReturnLocation,reservationpickuplocation,reservatoinpickUpDate,reservatoinreturnDate;

    @FXML
    ImageView reservecar;


    public Reservation_history(){};

    public Reservation_history(String nameInput, String phoneNumberInput, String pickUpLocationInput, String returnLocationInput, String pickUpDateInput,String returnDateInput) {
        NameInput = nameInput;
        PhoneNumberInput = phoneNumberInput;
        PickUpLocationInput = pickUpLocationInput;
        ReturnLocationInput = returnLocationInput;
        PickUpDateInput = pickUpDateInput;
        ReturnDateInput = returnDateInput;
    }



    public void Back(ActionEvent event3) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        root = loader.load();

        HomePageController homePageController = loader.getController();

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), root);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

        stage = (Stage) ((Node) event3.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Reservation reservation : ReadWriteData.Reservation_contents) {

                reservatoinname.setText(reservation.getNameInput());
                reservatoinnnumber.setText(reservation.getPhoneNumberInput());
                reservationpickuplocation.setText(reservation.getPickUpLocationInput());
                reservatoinReturnLocation.setText(reservation.getReturnLocationInput());
                reservatoinpickUpDate.setText(reservation.getPickUpDateInput());
                reservatoinreturnDate.setText(reservation.getReturnDateInput());

                ImageView carImageView = new ImageView();
                String photoPath = ReadWriteData.vechicles_Content.get(HomePageController.carI).getPhoto();
                Image carImage = new Image(new File(photoPath).toURI().toString());
                reservecar.setImage(carImage);

                vBox.getChildren().add(carImageView);

            }
        }


/*
    public void cancelButton(ActionEvent e) {

    }
*/
    }


