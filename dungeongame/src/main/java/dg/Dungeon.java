package dg;

/**
 *
 * @author kostajoo
 */
import java.util.*;

public class Dungeon {

    private int xcoord;
    private int ycoord;
    private Player player;

    private Room[][] rooms;

    public Dungeon() {
        this.rooms = new Room[5][5];
        this.xcoord = 2;
        this.ycoord = 4;
        this.player = new Player();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 4 && j == 2) {
                    rooms[i][j] = new Room(j, i, 0);
                    rooms[i][j].step();
                } else {
                    rooms[i][j] = new Room(j, i, r.nextInt(5) + 1);
                }
            }
        }

    }

    public Room[][] floor() {
        return this.rooms;
    }

    public int getX() {
        return this.xcoord;
    }

    public int getY() {
        return this.ycoord;
    }

    public void move(int way) {
        rooms[ycoord][xcoord].leave();
        if (way == 1) {
            if (ycoord - 1 > -1) {
                ycoord -= 1;
            }
        }
        if (way == 2) {
            if (xcoord + 1 < 5) {
                xcoord += 1;
            }
        }
        if (way == 3) {
            if (ycoord + 1 < 5) {
                ycoord += 1;
            }
        }
        if (way == 4) {
            if (xcoord - 1 > -1) {
                xcoord -= 1;
            }
        }
        rooms[ycoord][xcoord].step();
        String type = rooms[ycoord][xcoord].getType();
        if (type.equals("trap")) {
            player.healthDown(1);
        }
        if (type.equals("bigtrap")) {
            player.healthDown(3);
        }
        if (type.equals("potion")) {
            player.healthUp(1);
        }
        if (type.equals("bigpotion")) {
            player.healthUp(3);
        }
        if (type.equals("exit")) {
            System.out.println("You won");
        }

    }

}
