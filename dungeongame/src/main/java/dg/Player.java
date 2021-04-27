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
public class Player {

    private int health;
    private int x;
    private int y;
 

    public Player() {
        this.health = 10;
        this.x = 2;
        this.y = 4;
       

    }

    public void healthDown(int amount) {
        this.health -= amount;
        if (health < 1) {
            System.out.println("You died");
        }
    }

    public void healthUp(int amount) {
        this.health += amount;
    }

    public int getHealth() {
        return this.health;
    }

    public void setLoc(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
