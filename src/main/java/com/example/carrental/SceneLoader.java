package com.example.carrental;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class SceneLoader {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void loadNextScene(AnchorPane rootPane, String NScene) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(NScene));
            root = loader.load();
            stage = (Stage) rootPane.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void makefadeout(AnchorPane rootPane,String NScene){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(rootPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished((ActionEvent e) -> {
            try {
                loadNextScene(rootPane,NScene);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        fadeTransition.play();

    }
    public void makeFadeInTransition(AnchorPane rootPane) {

        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(rootPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }


}
