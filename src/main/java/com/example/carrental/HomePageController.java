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
    public ArrayList<Button> Button_list=new ArrayList<>();
    public ArrayList<Label> PriceLabelList = new ArrayList<>();
    public ArrayList<Label> CarLabelList = new ArrayList<>();
    public static ArrayList<Vehicle> carAgencyFilterContent = new ArrayList<>();
    public static ArrayList<Vehicle> searchFilterContent = new ArrayList<>();


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
    @FXML
    private ComboBox<String> caragencybox;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    TextField Search;

    public static int carI;
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
        displayCarImage();
        Hover();
        caragencybox.getItems().addAll("Al Mansour","Ezz Elarab","Abou Ghaly","Kasrawy");
    }

    public void ViewButtonClicked(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        int carIndex = Integer.parseInt(clickedButton.getId().substring(4));
        carI = carIndex;
        sceneLoader.loadCarDetails(rootPane, viewCar, carIndex);
    }


public void CarAgencySwitch(){

    for (int i = 0 ; i < ReadWriteData.vechicles_Content.size(); i++){

                    if (ReadWriteData.vechicles_Content.get(i).getCarAgency().equals(caragencybox.getValue())){
                        carAgencyFilterContent.add(ReadWriteData.vechicles_Content.get(i));
                    }
        }
                        sceneLoader.makefadeout(rootPane, "caragency.fxml");
                        System.out.println(carAgencyFilterContent);

}

public void searchSwitch(){


    for (int i = 0 ; i < ReadWriteData.vechicles_Content.size(); i++){

        if (ReadWriteData.vechicles_Content.get(i).getMake().equals(Search.getText())){
            searchFilterContent.add(ReadWriteData.vechicles_Content.get(i));
        }
    }       sceneLoader.makefadeout(rootPane,"searcheScene.fxml");

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
            String Price = vehicle.getPrice();
            String caragency = vehicle.getCarAgency();
            Image image = new Image(new File(photoPath).toURI().toString());

            if (vId >= 0 && vId < carImageViewsList.size()) {
                carImageViewsList.get(vId).setImage(image);
                PriceLabelList.get(vId).setText(Price);
                CarLabelList.get(vId).setText(caragency);
            }

        }
    }



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




