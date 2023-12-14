package com.example.carrental;


import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable {



    public String file = "customers.txt";
    public boolean signed ;

    @FXML
    private Label welcomeText;
    @FXML
    private AnchorPane rootPane;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    TextField firstname ,lastname,email,password,phone_number,driver_license;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    Alert ERROR = new Alert(Alert.AlertType.ERROR);



    public Customer c1;
    public void sign_Info() throws IOException {
         c1=new Customer(firstname.getText(),lastname.getText(),email.getText(),password.getText(),phone_number.getText(),driver_license.getText());
    }
    public void signuptrans(ActionEvent event) throws IOException {
        if (validateInputs_Signup()) {
        signed= (ReadWriteData.isEmailInList(email.getText()) && ReadWriteData.isPasswordInList(password.getText()));
        if (!signed) {
                sign_Info();
                makefadeout();
                ReadWriteData.customerContents.add(c1);
        }
             else if(signed){
                    ERROR.setTitle("ERROR");
                    ERROR.setHeaderText("User Already Exist!");
                    ERROR.setContentText("Click Ok To Continue: ");
                    ERROR.showAndWait();
            }
        }
        else {
            ERROR.setTitle("ERROR");
            ERROR.setHeaderText("Make Sure To Enter All the Infromation!");
            ERROR.setContentText("Click Ok To Continue: ");
            ERROR.showAndWait();

        }
    }



    private boolean validateInputs_Signup() {

        return !firstname.getText().isEmpty() && !lastname.getText().isEmpty()
                && !email.getText().isEmpty() && !password.getText().isEmpty()
                && !phone_number.getText().isEmpty() && !driver_license.getText().isEmpty();
    }


    public void makefadeout(){

        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(rootPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished((ActionEvent e) -> {
            try {
                loadNextScene();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        fadeTransition.play();

    }






    public void loadNextScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loginScene.fxml"));
        root = loader.load();
        stage = (Stage) rootPane.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void makeFadeInTransition() {

        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(rootPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
                rootPane.setOpacity(0);
                makeFadeInTransition();
    }
}