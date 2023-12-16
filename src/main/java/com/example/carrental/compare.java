package com.example.carrental;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
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


public class compare implements Initializable {
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
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    public AnchorPane rootPane;
    @FXML
    Alert ERROR = new Alert(Alert.AlertType.ERROR);
    SceneLoader sceneLoader =new SceneLoader();

    @FXML
    CheckBox myCheckBox0, myCheckBox1, myCheckBox2, myCheckBox3, myCheckBox4, myCheckBox5, myCheckBox6, myCheckBox7, myCheckBox8, myCheckBox9, myCheckBox10, myCheckBox11;
    @FXML

    CheckBox selected;
    @FXML
    CheckBox[] mycheckbox ;
    public int counter =0;
    public void select(ActionEvent event) {
        CheckBox selected=(CheckBox) event.getSource() ;

        if(selected.isSelected()){
            counter++;
        }
        else {
            counter--;
        }
        if(counter>2){
            selected.setSelected(false);
            counter--;

            ERROR.setTitle("ERROR");
            ERROR.setHeaderText("Please Select 2");
            ERROR.setContentText("Click Ok To Continue: ");
            ERROR.showAndWait();

        }

    }

    public void comparebtn (ActionEvent event ) throws IOException {
        if (counter<2) {
            System.out.println(counter);
            ERROR.setTitle("ERROR");
            ERROR.setHeaderText("Please Select 2 ");
            ERROR.setContentText("Click Ok To Continue: ");
            ERROR.showAndWait();

        } else if (counter==2) {

            List<Vehicle> selectedCars = new ArrayList<>();

            for (int i = 0; i < mycheckbox.length; i++) {
                if (mycheckbox[i].isSelected()) {
                    System.out.println(mycheckbox.length);
                    selectedCars.add(ReadWriteData.vechicles_Content.get(i));
                }
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("compare2Carscontroll.fxml"));
            root = loader.load();
            compare2Carscontroll c = loader.getController();

            c.setCar1Details(selectedCars.get(0));
            c.setCar2Details(selectedCars.get(1));

            FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), root);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneLoader.makeFadeInTransition(rootPane);
        rootPane.setOpacity(0);
        System.out.println(ReadWriteData.vechicles_Content.size());
        carArray = new ImageView[]{car1, car2, car3, car4, car5, car6,car7,car8,car9,car10,car11,car12};
        rectanglesArray =  new Rectangle[]{rectangle1,rectangle2,rectangle3,rectangle4,rectangle5,rectangle6,rectangle7,rectangle8,rectangle9,rectangle10,rectangle11,rectangle12};
        mycheckbox = new CheckBox[]{myCheckBox0, myCheckBox1, myCheckBox2, myCheckBox3, myCheckBox4, myCheckBox5, myCheckBox6, myCheckBox7, myCheckBox8, myCheckBox9, myCheckBox10, myCheckBox11};
        carImageViewsList.addAll(List.of(carArray));
        rectanglesList.addAll(List.of(rectanglesArray));
        displayCarImage();
        Hover();
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
            Image image = new Image(new File(photoPath).toURI().toString());

            if (vId >= 0 && vId < carImageViewsList.size()) {
                carImageViewsList.get(vId).setImage(image);
            }
        }
    }
    public void BackToHome(ActionEvent event){
        sceneLoader.makefadeout(rootPane,"HomePage.fxml");
    }

}
