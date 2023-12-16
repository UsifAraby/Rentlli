package com.example.carrental;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifySceneController implements Initializable {



    @FXML
    AnchorPane rootPane;
    SceneLoader sceneLoader = new SceneLoader();
    @FXML
    private ComboBox<String> caragencybox;
    @FXML
    private ComboBox<Integer> choosecarId;


    public String Name,model,plate,color,year,price,Agency;
    public String photopath;
    @FXML
    TextField carname,carmodel,licenceplate,colorField,priceField,yearField;

    @FXML
    Button addPhotoButton,addDataButton;
    @FXML
    ImageView carImage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneLoader.makeFadeInTransition(rootPane);
        caragencybox.getItems().addAll("Al Mansour","Ezz Elarab","Abou Ghaly","Kasrawy");
        int numVehicles = ReadWriteData.vechicles_Content.size();
        for (int i = 0; i < numVehicles; i++) {
            choosecarId.getItems().add(i);
        }
    }

    public void addPhoto(){
        System.out.println("addPhoto method called.");
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(rootPane.getScene().getWindow());
        if (selectedFile != null) {
            photopath = selectedFile.getAbsolutePath();
            Image image = new Image(new File(photopath).toURI().toString());
            carImage.setImage(image);
        } else {
            System.out.println("No file selected.");
        }
    }
    public void AddData() {
        Agency = caragencybox.getValue();
        plate = licenceplate.getText();
        Name = carname.getText();
        model = carmodel.getText();
        color = colorField.getText();
        year = yearField.getText();
        price = priceField.getText();

        Integer selectedCarId = choosecarId.getValue();
        if (selectedCarId != null) {
            Vehicle vehicle = new Vehicle(plate, Name, model, color, year, price, Agency, photopath);
            ReadWriteData.vechicles_Content.set(selectedCarId.intValue(), vehicle);
        }
    }


}
