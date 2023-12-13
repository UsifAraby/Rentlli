package com.example.carrental;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.io.*;
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

import java.net.URL;
import java.time.format.TextStyle;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {
    @FXML
    public AnchorPane rootPane;

    @FXML
    Rectangle rectangle1,rectangle2,rectangle3,rectangle4,rectangle5,rectangle6,rectangle7,rectangle8,rectangle9;
    @FXML
    public Rectangle[] rectangles ;
    @FXML
    ImageView car1, car2, car3, car4, car5, car6,car7,car8,car9;
    @FXML
    ImageView[] carImageViews ;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private GridPane gridPane;

    @FXML
    Button view1,view2,view3,view4,view5,view6,view7,view8,view9;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootPane.setOpacity(0);
        makeFadeInTransition();
        displayCarImage();
        gridPane.getStyleClass().add("homebuttons.css");
        System.out.println(ReadWriteData.vechicles_Content.size());
        carImageViews= new ImageView[]{car1, car2, car3, car4, car5, car6,car7,car8,car9};
        rectangles =  new Rectangle[]{rectangle1,rectangle2,rectangle3,rectangle4,rectangle5,rectangle6,rectangle7,rectangle8,rectangle9};
        Hover();
    }


    public void Hover() {

        for (int i = 0 ; i<carImageViews.length ; i++){
            setupHoverEffect(rectangles[i],carImageViews[i]);
        }

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


    public void displayCarImage() {

        for (Vehicle vehicle : ReadWriteData.vechicles_Content) {
            int vId = vehicle.getVe_Id();
            String photoPath = vehicle.getPhoto();
           // System.out.println(vId);

            Image image = new Image(new File(photoPath).toURI().toString());

            switch (vId) {

                case 0:
                car1.setImage(image);
                break;

                case 1:
                    car2.setImage(image);
                    break;

                case 2:
                    car3.setImage(image);
                    break;

                case 3:
                    car4.setImage(image);
                    break;

                case 4:
                    car5.setImage(image);
                    break;

                case 5:
                    car6.setImage(image);
                    break;

                case 6:
                    car7.setImage(image);
                    break;

                case 7:
                    car8.setImage(image);
                    break;

                case 8:
                    car9.setImage(image);
                    break;
            }


        }
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




