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
import java.util.ArrayList;
import java.util.List;
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

    String viewCar = "carView.fxml";

    @FXML
    public AnchorPane rootPane;

    @FXML
    Rectangle rectangle1,rectangle2,rectangle3,rectangle4,rectangle5,rectangle6,rectangle7,rectangle8,rectangle9,rectangle10,rectangle11,rectangle12;
    @FXML
    public Rectangle[] rectanglesArray ;
    @FXML
    ImageView car1, car2, car3, car4, car5, car6,car7,car8,car9,car10,car11,car12;
    @FXML
    ImageView[] carArray ;

    public ArrayList<ImageView> carImageViewsList = new ArrayList<>();
    public ArrayList<Rectangle> rectanglesList = new ArrayList<>();


    @FXML
    private ScrollPane scrollPane;

    @FXML
    private GridPane gridPane;

    @FXML
    Button view0,view1,view2,view3,view4,view5,view6,view7,view8,view9,view10,view11;

    SceneLoader sceneLoader = new SceneLoader();
    ViewToReserveController viewToReserveController = new ViewToReserveController();

    private Stage stage;
    private Scene scene;
    private Parent root;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootPane.setOpacity(0);
        sceneLoader.makeFadeInTransition(rootPane);
        gridPane.getStyleClass().add("homebuttons.css");
        System.out.println(ReadWriteData.vechicles_Content.size());
        carArray = new ImageView[]{car1, car2, car3, car4, car5, car6,car7,car8,car9,car10,car11,car12};
        rectanglesArray =  new Rectangle[]{rectangle1,rectangle2,rectangle3,rectangle4,rectangle5,rectangle6,rectangle7,rectangle8,rectangle9,rectangle10,rectangle11,rectangle12};
        carImageViewsList.addAll(List.of(carArray));
        rectanglesList.addAll(List.of(rectanglesArray));
        displayCarImage();
        Hover();
    }

    public void ViewButtonClicked(ActionEvent event) {
        // Get the clicked button
        Button clickedButton = (Button) event.getSource();

        // Extract the car index from the button ID
        int carIndex = Integer.parseInt(clickedButton.getId().substring(4));
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(viewCar));
            loader.load();
            loader.setRoot(rootPane);
            viewToReserveController = loader.getController();
            viewToReserveController.setCarDetails(ReadWriteData.vechicles_Content.get(carIndex));
            sceneLoader.makefadeout(rootPane, viewCar);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }



        public void Hover() {

        for (int i = 0 ; i<carImageViewsList.size() ; i++){
            setupHoverEffect(rectanglesList.get(i),carImageViewsList.get(i));
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

            if (vId >= 0 && vId < carImageViewsList.size()) {
                carImageViewsList.get(vId).setImage(image);
            }

            /*switch (vId) {

                case 0:
                    carImageViewsList.get(0).setImage(image);
                break;

                case 1:
                    carImageViewsList.get(1).setImage(image);
                    break;

                case 2:
                    carImageViewsList.get(2).setImage(image);
                    break;

                case 3:
                    carImageViewsList.get(3).setImage(image);
                    break;

                case 4:
                    carImageViewsList.get(4).setImage(image);
                    break;

                case 5:
                    carImageViewsList.get(5).setImage(image);
                    break;

                case 6:
                    carImageViewsList.get(6).setImage(image);
                    break;

                case 7:
                    carImageViewsList.get(7).setImage(image);
                    break;

                case 8:
                carImageViewsList.get(8).setImage(image);
                    break;

                case 9:
                    carImageViewsList.get(9).setImage(image);
                    break;

                case 10:
                    carImageViewsList.get(10).setImage(image);
                    break;

                case 11:
                    carImageViewsList.get(11).setImage(image);
                    break;

            }*/


        }
    }






}




