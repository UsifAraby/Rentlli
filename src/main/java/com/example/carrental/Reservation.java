package com.example.carrental;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Reservation implements Initializable {

    public static int ReservationID;
    public int CarID;
    public int Customer_ID;
    public int PickUpDate;
    public int ReturnDate;
    public float TotalCost;

    public String Status;
    public int CuID;
    public int RID;
    public String NameInput;
    public String PhoneNumberInput;
    public String PickUpLocationInput;
    public String ReturnLocationInput;
    public String PickUpDateInput;
    public String ReturnDateInput;

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
    String viewCar = "carView.fxml";
    @FXML
    public ImageView viewCarImage=new ImageView();

    @FXML
    public AnchorPane rootPane;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public Button submitButton;
    Alert ERROR = new Alert(Alert.AlertType.ERROR);

    @FXML
    SceneLoader sceneLoader = new SceneLoader();

    public static int ResId;

    //methods
    public Reservation() {
        RID = ReservationID;
        ReservationID++;

    }

    public Reservation(String nameInput, String phoneNumberInput, String pickUpLocationInput, String returnLocationInput, String pickUpDateInput, String returnDateInput) {
        RID = ReservationID;
        ReservationID++;

        NameInput = nameInput;
        PhoneNumberInput = phoneNumberInput;
        PickUpLocationInput = pickUpLocationInput;
        ReturnLocationInput = returnLocationInput;
        PickUpDateInput = pickUpDateInput;
        ReturnDateInput = returnDateInput;
    }

    public boolean isNumeric(String str) {
        return str.matches("\\d*");
    }

    public void submit(ActionEvent event) throws IOException {

        String NameInput = n.getText();
        String PickUpLocationInput = pul.getText();
        String ReturnLocationInput = rel.getText();
        String PhoneNumberInput = ph.getText();
        LocalDate PickUpDateInput = pud.getValue();
        LocalDate ReturnDateInput = red.getValue();
        String pickUpDateStr = PickUpDateInput.toString();
        String returnDateStr = ReturnDateInput.toString();

        if (!n.getText().isEmpty() && !ph.getText().isEmpty() && !pul.getText().isEmpty() && !rel.getText().isEmpty() && pud.getValue() != null && red.getValue() != null) {
            if (isNumeric(ph.getText())) {

                Reservation reservation = new Reservation(NameInput, PhoneNumberInput, PickUpLocationInput, ReturnLocationInput, pickUpDateStr, returnDateStr);
                ReadWriteData.Reservation_contents.add(reservation);


                FXMLLoader loader = new FXMLLoader(getClass().getResource("InvScene.fxml"));
                root = loader.load();

                Invoice invoice = loader.getController();
                invoice.InvoiceSetting(NameInput, PhoneNumberInput, PickUpLocationInput, ReturnLocationInput, PickUpDateInput, ReturnDateInput);
                ResId = ReservationID;

                FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), root);
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);
                fadeTransition.play();



            } else {
                ERROR.setHeaderText("The Phone Number Must Be A Number!");
                ERROR.showAndWait();
            }
        } else {
            ERROR.setTitle("ERROR");
            ERROR.setHeaderText("Please Fill All The Required Inputs To Reserve The Car!");
            ERROR.showAndWait();
        }

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void ReservationHistory(ActionEvent event2) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Reservation History.fxml"));
        root = loader.load();

        Reservation_history reservation_history = loader.getController();

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), root);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

        stage = (Stage) ((Node) event2.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void ReservationViewCar() {
        String photoPath = ReadWriteData.vechicles_Content.get(HomePageController.carI).getPhoto();
        Image carImage = new Image(new File(photoPath).toURI().toString());
        viewCarImage.setImage(carImage);
        System.out.println(HomePageController.carI);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneLoader.makeFadeInTransition(rootPane);
        ReservationViewCar();
    }

    public String getNameInput() {
        return NameInput;
    }

    public String getPhoneNumberInput() {
        return PhoneNumberInput;
    }

    public String getPickUpLocationInput() {
        return PickUpLocationInput;
    }

    public String getReturnLocationInput() {
        return ReturnLocationInput;
    }

    public String getPickUpDateInput() {
        return PickUpDateInput;
    }

    public String getReturnDateInput() {
        return ReturnDateInput;
    }


}





