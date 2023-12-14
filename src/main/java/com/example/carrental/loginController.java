package com.example.carrental;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.format.TextStyle;
import java.util.ResourceBundle;

public class loginController implements Initializable {

    public String file = "customers.txt";
    public String homeScene = "HomePage.fxml";
    public String signScene = "signupScene.fxml";
    public boolean logged ;

    @FXML
    public AnchorPane rootPane;
    @FXML
    TextField email;
    @FXML
    TextField password;

    SceneLoader sceneLoader = new SceneLoader();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
                rootPane.setOpacity(0);
                sceneLoader.makeFadeInTransition(rootPane);
    }


    Alert ERROR = new Alert(Alert.AlertType.ERROR);



    private boolean validateInputs_Login(){
        return !email.getText().isEmpty()&&!password.getText().isEmpty();
    }

    public void logintrans(ActionEvent event) throws IOException {
        if (validateInputs_Login()) {

            if ((ReadWriteData.isEmailInList(email.getText()) && ReadWriteData.isPasswordInList(password.getText()))) {
                sceneLoader.makefadeout(rootPane, homeScene);
                System.out.println("logged in succefully!");
            }
                else {
                ERROR.setTitle("ERROR");
                ERROR.setHeaderText("Wrong Email Or Password!");
                ERROR.setContentText("Click Ok To Continue: ");
                ERROR.showAndWait();
            }
        } else {
            if (!email.getText().isEmpty()) {
                ERROR.setTitle("ERROR");
                ERROR.setHeaderText("Enter Password!");
                ERROR.setContentText("Click Ok To Continue: ");
                ERROR.showAndWait();
            }else {
                ERROR.setTitle("ERROR");
                ERROR.setHeaderText("Enter Email Adress!");
                ERROR.setContentText("Click Ok To Continue: ");
                ERROR.showAndWait();}
            if (email.getText().isEmpty() && password.getText().isEmpty()){
                ERROR.setTitle("ERROR");
                ERROR.setHeaderText("Please enter Email And Password");
                ERROR.setContentText("Click Ok To Continue: ");
                ERROR.showAndWait();
            }
        }
    }


    public void signuptrans2(ActionEvent event) throws IOException {
        sceneLoader.makefadeout(rootPane, signScene);
    }



}
