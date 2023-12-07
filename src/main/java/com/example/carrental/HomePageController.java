package com.example.carrental;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;
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

public class HomePageController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public AnchorPane rootPane;
    @FXML
    private Rectangle rectangle1;
    @FXML
    private Rectangle rectangle2;
    @FXML
    private Rectangle rectangle3;
    @FXML
    private Rectangle rectangle4;
    @FXML
    private Rectangle rectangle5;
    @FXML
    private Rectangle rectangle6;
    @FXML
    ImageView car1,car2,car3,car4,car5,car6;
    @FXML
    private javafx.scene.control.ChoiceBox<String> ChoiceBox;
    @FXML
    private Label carAgencyName;
    @FXML
    private String[] carAgencys = {"ELKERSH","ELLAITHY","ELMASRYA","ELGOHARY"};



    public void Hover() {

        setupHoverEffect(rectangle1,car1);
        setupHoverEffect(rectangle2,car2);
        setupHoverEffect(rectangle3,car3);
        setupHoverEffect(rectangle4,car4);
        setupHoverEffect(rectangle5,car5);
        setupHoverEffect(rectangle6,car6);

    }

    private void setupHoverEffect(Rectangle rectangle,ImageView image) {
        image.setScaleX(1);
        image.setScaleY(1);

        rectangle.setScaleX(1);
        rectangle.setScaleY(1);


        rectangle.setOnMouseEntered(event -> {
            rectangle.setScaleX(1.1);
            rectangle.setScaleY(1.1);
        });


        rectangle.setOnMouseExited(event -> {
            rectangle.setScaleX(1);
            rectangle.setScaleY(1);
        });

        image.setOnMouseEntered(mouseEvent -> {
            image.setScaleY(1.1);
            image.setScaleX(1.1);

        });

        image.setOnMouseExited(mouseEvent -> {
            image.setScaleY(1);
            image.setScaleX(1);
        });


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       rootPane.setOpacity(0);
        makeFadeInTransition();
        Hover();
        ChoiceBox.getItems().addAll(carAgencys);
       ChoiceBox.setOnAction(event -> {
            try {
                makefadeout();
              getcarAgency(event);



            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        });
    }
    public void getcarAgency(ActionEvent event) throws IOException {
        String myCarAgency=ChoiceBox.getValue();
        System.out.println(myCarAgency);
     if(myCarAgency.equals(carAgencys[0])){

         FXMLLoader loader = new FXMLLoader(getClass().getResource("carAgency1.fxml"));
          root = loader.load();
         stage = (Stage) rootPane.getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();

       } else if (myCarAgency.equals(carAgencys[1])) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("carAgency2.fxml"));
         root = loader.load();
         stage = (Stage) rootPane.getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
     }
     else if (myCarAgency.equals(carAgencys[2])) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("carAgency3.fxml"));
         root = loader.load();
         stage = (Stage) rootPane.getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
     }
     else if (myCarAgency.equals(carAgencys[3])) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("carAgency4.fxml"));
         root = loader.load();
         stage = (Stage) rootPane.getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
     }
    }
    public void makefadeout(){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(2000));
        fadeTransition.setNode(rootPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);


        fadeTransition.play();

    }
    public void makeFadeInTransition() {

        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(rootPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

    }






}




