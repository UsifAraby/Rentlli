package com.example.carrental;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewToReserveController implements Initializable {
        @FXML
        public Label carnameLabel, carmodelLabel, carcolorLabel, carfeaturesLabel, caryearLabel;
        @FXML
        ImageView viewCarImage;
        @FXML
        AnchorPane rootPane;

        SceneLoader sceneLoader = new SceneLoader();



        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                sceneLoader.makeFadeInTransition(rootPane);

        }



        public void setCarDetails(Vehicle car) {
                carnameLabel.setText(car.getMake());
                carmodelLabel.setText(car.getModel());
                carcolorLabel.setText(car.getColor());
                caryearLabel.setText(car.getYear_of_Manufacture());
                String photoPath = car.getPhoto();
                Image image = new Image(new File(photoPath).toURI().toString());
                viewCarImage.setImage(image);
        }



}