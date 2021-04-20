package dg;

import javafx.application.Application;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kostajoo
 */
public class Main {

    public static void main(String[] args) {
        Dungeon d = new Dungeon();
        Player c = new Player();

        Application.launch(UI.class, args);

    }
}
