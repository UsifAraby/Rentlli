package com.example.carrental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private ComboBox<Integer> carIdComboBox;

    private SceneLoader sceneLoader = new SceneLoader();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneLoader.makeFadeInTransition(rootPane);

        // Populate the ComboBox with values from 1 to 12
        carIdComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    }

    public void Delete_car(ActionEvent event) {
        int selectedCarId = carIdComboBox.getValue(); // Get the selected value from ComboBox
        ReadWriteData.vechicles_Content.remove(selectedCarId);
    }
}