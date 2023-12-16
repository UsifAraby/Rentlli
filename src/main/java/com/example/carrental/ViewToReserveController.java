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
        private ImageView viewCarImage;
        @FXML
        AnchorPane rootPane;
        @FXML
        Button fbutton;

        SceneLoader sceneLoader = new SceneLoader();
        private Stage stage;
        private Scene scene;
        private Parent root;
        public AnchorPane rootPane1;

        public AnchorPane rootPane2;
        public AnchorPane rootPane3;
        public AnchorPane rootPane4;
        public AnchorPane rootPane5;
        public AnchorPane rootPane6;
        public AnchorPane rootPane7;
        public AnchorPane rootPane8;
        public AnchorPane rootPane9;
        public AnchorPane rootPane10;
        public AnchorPane rootPane11;




      public void setCarDetails(Vehicle car) {
              carnameLabel.setText(car.getMake());
              carmodelLabel.setText(car.getModel());
              carcolorLabel.setText(car.getColor());
              caryearLabel.setText(car.getYear_of_Manufacture());
              String photoPath = car.getPhoto();
              Image image = new Image(new File(photoPath).toURI().toString());
              viewCarImage.setImage(image);
      }

        public void show(ActionEvent event) throws IOException {

                String sceneFXML = "features.fxml"; // Default FXML file name
                if(HomePageController.index==0)
                        sceneFXML="features.fxml";
                else if(HomePageController.index==1)
                        sceneFXML="f2.fxml";

                else if (HomePageController.index==2)
                        sceneFXML="f3.fxml";
                else if (HomePageController.index==3)
                        sceneFXML="f4.fxml";
                else if (HomePageController.index==4)
                        sceneFXML="f5.fxml";
                else if (HomePageController.index==5)
                        sceneFXML="f6.fxml";
                else if (HomePageController.index==6)
                        sceneFXML="f7.fxml";
                else if (HomePageController.index==7)
                        sceneFXML="f8.fxml";
                else if (HomePageController.index==8)
                        sceneFXML="f9.fxml";
                else if (HomePageController.index==9)
                        sceneFXML="f10.fxml";
                else if (HomePageController.index==10)
                        sceneFXML="f11.fxml";
                else sceneFXML="f12.fxml";



                try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource(sceneFXML));
                        Parent root = loader.load();

                        // Additional processing if needed

                        SceneLoader sceneLoader = new SceneLoader();
                        sceneLoader.makeFadeInTransition(rootPane);
                        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), root);
                        fadeTransition.setFromValue(0);
                        fadeTransition.setToValue(1);
                        fadeTransition.play();

                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                } catch (IOException e) {
                        e.printStackTrace(); // Handle the exception appropriately
                }
        }


              /*  FXMLLoader loader = new FXMLLoader(getClass().getResource("features.fxml"));
                root = loader.load();


                featuerscontroller fcontroller = loader.getController();


                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                */




        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                sceneLoader.makeFadeInTransition(rootPane);

        }
}


