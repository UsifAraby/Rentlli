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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewToReserveController implements Initializable {
        @FXML
        public Label carnameLabel, carmodelLabel, carcolorLabel, carfeaturesLabel, caryearLabel;
        @FXML
        ImageView viewCarImage=new ImageView();
        @FXML
        AnchorPane rootPane;
        String reserve="ReservScene.fxml";
        private Stage stage;
        private Scene scene;
        private Parent root;

        SceneLoader sceneLoader = new SceneLoader();


        public void ReserveNowButton(ActionEvent event) throws IOException{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ReservScene.fxml"));
                root = loader.load();
                FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), root);
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);
                fadeTransition.play();

                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene=new Scene(root);
                stage.setScene(scene);
                stage.show();

        }



        public void Back(ActionEvent event3) throws IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
                root = loader.load();
                HomePageController homePageController = loader.getController();

                FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), root);
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);
                fadeTransition.play();

                stage=(Stage)((Node)event3.getSource()).getScene().getWindow();
                scene=new Scene(root);
                stage.setScene(scene);
                stage.show();

        }


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