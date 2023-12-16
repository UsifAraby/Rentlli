package com.example.carrental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Admin_controller implements Initializable {
    @FXML
    private AnchorPane rootPane;
    private SceneLoader sceneLoader = new SceneLoader();

    @FXML
    Button removeButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sceneLoader.makeFadeInTransition(rootPane);
    }

    public void toDeletePage(ActionEvent e){
        sceneLoader.makefadeout(rootPane, "deletescene.fxml");
    }

    public void toِِAddPage(ActionEvent e){
        sceneLoader.makefadeout(rootPane, "addScene.fxml");
    }

    public void toModify(ActionEvent e){
        sceneLoader.makefadeout(rootPane, "");
    }

}
