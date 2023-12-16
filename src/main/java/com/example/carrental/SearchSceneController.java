package com.example.carrental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SearchSceneController implements Initializable {

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
    public ArrayList<Button> Button_list=new ArrayList<>();
    public ArrayList<Label> PriceLabelList = new ArrayList<>();
    public ArrayList<Label> CarLabelList = new ArrayList<>();

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private GridPane gridPane;

    @FXML
    Button view0,view1,view2,view3,view4,view5,view6,view7,view8,view9,view10,view11;
    Button []button;

    @FXML
    Label label0,label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11;

    Label[] labels;
    @FXML
    Label agency0,agency1,agency2,agency3,agency4,agency5,agency6,agency7,agency8,agency9,agency10,agency11;
    Label[] agencyLabels;
    SceneLoader sceneLoader = new SceneLoader();
    ViewToReserveController viewToReserveController = new ViewToReserveController();
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    TextField Search;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootPane.setOpacity(0);
        sceneLoader.makeFadeInTransition(rootPane);
        gridPane.getStyleClass().add("homebuttons.css");
        button=new Button[]{view0,view1,view2,view3,view4,view5,view6,view7,view8,view9,view10,view11};
        System.out.println(ReadWriteData.vechicles_Content.size());
        carArray = new ImageView[]{car1, car2, car3, car4, car5, car6,car7,car8,car9,car10,car11,car12};
        rectanglesArray =  new Rectangle[]{rectangle1,rectangle2,rectangle3,rectangle4,rectangle5,rectangle6,rectangle7,rectangle8,rectangle9,rectangle10,rectangle11,rectangle12};
        labels = new Label[]{label0,label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11};
        agencyLabels = new Label[]{agency0,agency1,agency2,agency3,agency4,agency5,agency6,agency7,agency8,agency9,agency10,agency11};
        carImageViewsList.addAll(List.of(carArray));
        rectanglesList.addAll(List.of(rectanglesArray));
        Button_list.addAll(List.of(button));
        PriceLabelList.addAll(List.of(labels));
        CarLabelList.addAll(List.of(agencyLabels));
        displaysearchCars();
        Hover();
    }



    public void ViewButtonClicked(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        int carIndex = Integer.parseInt(clickedButton.getId().substring(4));

        sceneLoader.loadCarDetails(rootPane, "carView.fxml", carIndex,HomePageController.searchFilterContent);
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



    public void displaysearchCars() {

        for (int i = 0; i < HomePageController.searchFilterContent.size(); i++) {
            Vehicle vehicle = HomePageController.searchFilterContent.get(i);
            String photoPath = vehicle.getPhoto();
            String Price = vehicle.getPrice();
            String caragency = vehicle.getCarAgency();
            Image image = new Image(new File(photoPath).toURI().toString());

            carImageViewsList.get(i).setImage(image);
            PriceLabelList.get(i).setText(Price);
            CarLabelList.get(i).setText(caragency);
        }
    }





}
