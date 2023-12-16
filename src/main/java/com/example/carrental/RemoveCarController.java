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

        int numVehicles = ReadWriteData.vechicles_Content.size();
        for (int i = 0; i < numVehicles; i++) {
            carIdComboBox.getItems().add(i);
        }
    }

    public void Delete_car(ActionEvent event) {
        Integer selectedCarId = carIdComboBox.getValue();
        if (selectedCarId != null) {
            ReadWriteData.vechicles_Content.remove(selectedCarId.intValue());
            homePageController.rectanglesList.remove(selectedCarId.intValue());
        }
    }

}
