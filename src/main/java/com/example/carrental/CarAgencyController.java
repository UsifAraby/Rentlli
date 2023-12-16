package com.example.carrental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CarAgencyController implements Initializable {

    @FXML
    public AnchorPane rootPane;

    @FXML
    Rectangle rectangle1,rectangle2,rectangle3;
    @FXML
    public Rectangle[] rectanglesArray ;
    @FXML
    ImageView car1, car2, car3;
    @FXML
    ImageView[] carArray ;

    public ArrayList<ImageView> carImageViewsList = new ArrayList<>();
    public ArrayList<Rectangle> rectanglesList = new ArrayList<>();
    public ArrayList<Button> Button_list=new ArrayList<>();
    public ArrayList<Label> PriceLabelList = new ArrayList<>();
    public ArrayList<Label> CarLabelList = new ArrayList<>();


    @FXML
    private GridPane gridPane;

    @FXML
    Button view0,view1,view2;
    Button []button;

    @FXML
    Label label0,label1,label2;

    Label[] labels;
    @FXML
    Label agency0,agency1,agency2;
    Label[] agencyLabels;
    SceneLoader sceneLoader = new SceneLoader();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneLoader.makeFadeInTransition(rootPane);
        button=new Button[]{view0,view1,view2};
        carArray = new ImageView[]{car1, car2, car3};
        rectanglesArray =  new Rectangle[]{rectangle1,rectangle2,rectangle3};
        labels = new Label[]{label0,label1,label2};
        agencyLabels = new Label[]{agency0,agency1,agency2};
        carImageViewsList.addAll(List.of(carArray));
        rectanglesList.addAll(List.of(rectanglesArray));
        Button_list.addAll(List.of(button));
        PriceLabelList.addAll(List.of(labels));
        CarLabelList.addAll(List.of(agencyLabels));
        displayAgencyCars();
        Hover();
    }
    public void ViewButtonClicked(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        int carIndex = Integer.parseInt(clickedButton.getId().substring(4));

        sceneLoader.loadCarDetails(rootPane, "carView.fxml", carIndex,HomePageController.carAgencyFilterContent);
    }


    public void displayAgencyCars() {

        for (int i = 0; i < HomePageController.carAgencyFilterContent.size(); i++) {
            Vehicle vehicle = HomePageController.carAgencyFilterContent.get(i);
            String photoPath = vehicle.getPhoto();
            String Price = vehicle.getPrice();
            String caragency = vehicle.getCarAgency();
            Image image = new Image(new File(photoPath).toURI().toString());

            carImageViewsList.get(i).setImage(image);
            PriceLabelList.get(i).setText(Price);
            CarLabelList.get(i).setText(caragency);
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






}
