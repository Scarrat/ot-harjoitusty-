/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dg;

import javafx.scene.image.Image;

/**
 *
 * @author kostajoo
 */
public class Room {

    private int x;
    private int y;
    private String type;
    private boolean found;
    private Image image;
    private boolean player;
    Image b = new Image("file:src/main/java/Images/Groundblack.png");
    Image w = new Image("file:src/main/java/Images/Groundwhite.png");
    Image p = new Image("file:src/main/java/Images/Currloc.png");

    public Room(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.found = false;
        this.player = false;
        this.image = b;
        if (type == 0) {
            this.type = "entry";
        }
        if (type == 1) {
            this.type = "trap";
        }
        if (type == 2) {
            this.type = "potion";
        }
        if (type == 3) {
            this.type = "bigtrap";
        }
        if (type == 4) {
            this.type = "bigpotion";
        }
        if (type == 5) {
            this.type = "exit";
        }
    }

    public String getType() {
        return type;
    }

    public Image getImage() {
        return this.image;
    }

    public void leave() {
        this.image = w;
        this.player = false;
    }

    public void step() {
        this.image = p;
        this.player = true;
    }

    public boolean isPlayer() {
        return this.player;
    }

}
