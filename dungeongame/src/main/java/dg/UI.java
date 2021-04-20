/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dg;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;

/**
 *
 * @author kostajoo
 */
public class UI extends Application {

    private Button up;
    private Button right;
    private Button down;
    private Button left;

    public UI() {

    }

    @Override
    public void start(Stage window) {

        Canvas canvas = new Canvas(250, 250);
        GraphicsContext draw = canvas.getGraphicsContext2D();

        BorderPane bp = new BorderPane();
        Pane pane = new Pane();

        Image image = new Image("file:src/main/java/Images/Groundblack.png");
        ImageView vimage = new ImageView(image);

        pane.getChildren().add(vimage);

        Scene nakyma = new Scene(pane);

        window.setScene(nakyma);
        window.show();

    }
}
