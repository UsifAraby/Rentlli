package com.example.carrental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class RemoveCarController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private ComboBox<Integer> carIdComboBox;

    private SceneLoader sceneLoader = new SceneLoader();
HomePageController homePageController = new HomePageController();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneLoader.makeFadeInTransition(rootPane);

        carIdComboBox.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
    }
    public void Delete_car(ActionEvent event) {
        int selectedCarId = carIdComboBox.getValue();
        ReadWriteData.vechicles_Content.remove(selectedCarId);
        homePageController.rectanglesList.remove(selectedCarId);
    }

}
