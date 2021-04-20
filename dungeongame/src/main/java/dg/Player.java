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

    public Player() {
        this.health = 10;
    }

    public void HealthDown(int amount) {
        this.health -= amount;
    }

    public void HealthUp(int amount) {
        this.health += amount;
    }

    public int getHealth() {
        return this.health;
    }
}
