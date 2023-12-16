package com.example.carrental;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class compare2Carscontroll implements Initializable {

    @FXML
    public Label car1nameLabel, car1modelLabel, car1colorLabel, car1yearLabel,car2nameLabel,car2modelLabel,car2colorLabel,car2yearLabel;
    @FXML
    Rectangle rectangle1,rectangle2,rectangle3,rectangle4,rectangle5,rectangle6,rectangle7,rectangle8,rectangle9,rectangle10,rectangle11,rectangle12;
    @FXML
    ImageView car1, car2, car3, car4, car5, car6,car7,car8,car9,car10,car11,car12;
    @FXML
    ImageView[] carArray ;
    @FXML
    public Rectangle[] rectanglesArray ;
    public ArrayList<ImageView> carImageViewsList = new ArrayList<>();
    public ArrayList<Rectangle> rectanglesList = new ArrayList<>();
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    public AnchorPane rootPane;
    SceneLoader sceneLoader =new SceneLoader();
    @FXML
    ImageView CarImage1,CarImage2;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneLoader.makeFadeInTransition(rootPane);
        rootPane.setOpacity(0);
        System.out.println(ReadWriteData.vechicles_Content.size());
        carArray = new ImageView[]{car1, car2, car3, car4, car5, car6,car7,car8,car9,car10,car11,car12};
        rectanglesArray =  new Rectangle[]{rectangle1,rectangle2,rectangle3,rectangle4,rectangle5,rectangle6,rectangle7,rectangle8,rectangle9,rectangle10,rectangle11,rectangle12};

        //carImageViewsList.addAll(List.of(carArray));
        // rectanglesList.addAll(List.of(rectanglesArray));
    }
    public void BackToCompare(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("compare.fxml"));
        root = loader.load();
        compare c = loader.getController();

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), root);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setCar1Details(Vehicle car) {
        car1nameLabel.setText(car.getMake());
        car1modelLabel.setText(car.getModel());
        car1colorLabel.setText(car.getColor());
        car1yearLabel.setText(car.getYear_of_Manufacture());
        String photoPath = car.getPhoto();
        Image image = new Image(new File(photoPath).toURI().toString());
        CarImage1.setImage(image);
    }
    public void setCar2Details(Vehicle car) {
        car2nameLabel.setText(car.getMake());
        car2modelLabel.setText(car.getModel());
        car2colorLabel.setText(car.getColor());
        car2yearLabel.setText(car.getYear_of_Manufacture());
        String photoPath = car.getPhoto();
        Image image = new Image(new File(photoPath).toURI().toString());
        CarImage2.setImage(image);
    }



}