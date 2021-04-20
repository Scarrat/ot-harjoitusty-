/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dg;

/**
 *
 * @author kostajoo
 */
public class Room {

    private int x;
    private int y;
    private String type;

    public Room(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
