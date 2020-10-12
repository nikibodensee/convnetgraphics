package main.java.AIGraphics;

import javafx.scene.paint.Color;

public class Nodes {

    private int NetxAmount;
    private int screenxsize;
    private int NetyAmount;
    private int screenysize;


    public Nodes(int netxAmount, int screenxsize, int netyAmount, int screenysize) {
        NetxAmount = netxAmount;
        this.screenxsize = screenxsize;
        NetyAmount = netyAmount;
        this.screenysize = screenysize;
    }

    int NodexSize() {
        return Math.round((int)(0.5 * ((float)screenxsize / (float)NetxAmount)));
    }

    int NodeySize() {
        return Math.round((int)(0.5 * ((float)screenysize / (float)NetyAmount)));
    }

    Color[][] drawNode(int x, int y, Color col, Color[][] screen) {
        for (int i = y-1; i < y + NodeySize(); i++) {
            for (int k = x-1; k < x + NodexSize(); k++) {
                   screen[k][i] = col;
            }
        }
        return screen;
    }


}
