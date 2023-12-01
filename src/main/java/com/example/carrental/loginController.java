package com.example.carrental;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    @FXML
    public AnchorPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
                rootPane.setOpacity(0);
                makeFadeInTransition();
    }

    public void makeFadeInTransition() {

            FadeTransition fadeTransition = new FadeTransition();
            fadeTransition.setDuration(Duration.millis(1000));
            fadeTransition.setNode(rootPane);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

    }


    public void signuptrans2(ActionEvent event) throws IOException {
        makefadeout();
    }

    public void makefadeout(){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(rootPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished((ActionEvent e) -> {
            try {
                loadNextScene();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        fadeTransition.play();

    }
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void loadNextScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        root = loader.load();
        stage = (Stage) rootPane.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




}
