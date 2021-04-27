/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dg.Dungeon;
import dg.Player;
import dg.Room;
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
import javafx.scene.layout.GridPane;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author kostajoo
 */
public class UI extends Application {

    Player p = new Player();
    Dungeon dung = new Dungeon();
    private final int tileSize = 128;
    Room[][] rooms = dung.floor();

    GridPane gridPane = new GridPane();

    @Override
    public void start(Stage primaryStage) {

        gridPane.setHgap(2);
        gridPane.setVgap(2);
        gridPane.setStyle("-fx-background-color: grey;");

        for (int y = 0; y < dung.floor().length; y++) {
            for (int x = 0; x < dung.floor().length; x++) {
                ImageView imageView = new ImageView(rooms[y][x].getImage());
                imageView.setFitWidth(tileSize);
                imageView.setFitHeight(tileSize);
                gridPane.add(imageView, x, y);
            }
        }

        Scene scene = new Scene(gridPane);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        dung.move(1);
                        update();
                        break;
                    case RIGHT:
                        dung.move(2);
                        update();
                        break;
                    case DOWN:
                        dung.move(3);
                        update();
                        break;
                    case LEFT:
                        dung.move(4);
                        update();
                        break;
                }
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void update() {
        for (int y = 0; y < dung.floor().length; y++) {
            for (int x = 0; x < dung.floor().length; x++) {
                ImageView imageView = new ImageView(rooms[y][x].getImage());
                imageView.setFitWidth(tileSize);
                imageView.setFitHeight(tileSize);
                gridPane.add(imageView, x, y);
            }
        }
    }
    


    public static void main(String[] args) {
        Application.launch(args);
    }
}


