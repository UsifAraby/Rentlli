package com.example.carrental;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Admin_controller implements Initializable {
    @FXML
    private AnchorPane rootPane;
    private SceneLoader sceneLoader = new SceneLoader();

    @FXML
    Button removeButton;

    private Stage stage;
    private Scene scene;
    private Parent root;
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
        sceneLoader.makefadeout(rootPane, "modify.fxml");
    }

    public void logOut(ActionEvent e) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("loginScene.fxml"));
        root = loader.load();
        loginController l = loader.getController();
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), root);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
