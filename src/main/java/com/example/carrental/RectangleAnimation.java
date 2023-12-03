package com.example.carrental;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class RectangleAnimation {




    @FXML
    private Rectangle rectangle1;

    @FXML
    private Rectangle rectangle2;
    @FXML
    private Rectangle rectangle3;
    @FXML
    private Rectangle rectangle4;
    @FXML
    private Rectangle rectangle5;
    @FXML
    private Rectangle rectangle6;
    @FXML
    ImageView car1,car2,car3,car4,car5,car6;



    public void initialize() {
        setupHoverEffect(rectangle1,car1);
        setupHoverEffect(rectangle2,car2);
        setupHoverEffect(rectangle3,car3);
        setupHoverEffect(rectangle4,car4);
        setupHoverEffect(rectangle5,car5);
        setupHoverEffect(rectangle6,car6);

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
}




