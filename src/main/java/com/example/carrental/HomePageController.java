package com.example.carrental;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
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

//ele zwedto

private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ScrollPane scrollPane;

    @FXML
    private GridPane gridPane;

    @FXML
    Button view0,view1,view2,view3,view4,view5,view6,view7,view8,view9,view10,view11;

    SceneLoader sceneLoader = new SceneLoader();
    //ViewToReserveController viewToReserveController = new ViewToReserveController();


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
public static int carI;
    public void ViewButtonClicked(ActionEvent event) {

        Button clickedButton = (Button) event.getSource();

        // Extract the car index from the button ID
        int carIndex = Integer.parseInt(clickedButton.getId().substring(4));
        carI=carIndex;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(viewCar));
            Parent viewCarRoot = loader.load();
            ViewToReserveController viewToReserveController = loader.getController();
            viewToReserveController.setCarDetails(ReadWriteData.vechicles_Content.get(carIndex));
            rootPane.getChildren().setAll(viewCarRoot.getChildrenUnmodifiable());
            sceneLoader.makeFadeInTransition(rootPane);

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

        }
    }
    //ele zwedto
    public void ReservationHistory(ActionEvent event2) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Reservation History.fxml"));
        root = loader.load();

        Reservation_history reservation_history = loader.getController();


        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), root);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

        stage=(Stage)((Node)event2.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




}




