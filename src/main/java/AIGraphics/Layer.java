package main.java.AIGraphics;

import javafx.scene.paint.Color;

public class Layer {

    private int sizestep;
    private int NetxAmount;
    private int screenxsize;
    private int NetyAmount;
    private int screenysize;

    public Layer(int sizestep, int netxAmount, int screenxsize, int netyAmount, int screenysize) {
        this.sizestep = sizestep;
        NetxAmount = netxAmount;
        this.screenxsize = screenxsize;
        NetyAmount = netyAmount;
        this.screenysize = screenysize;
    }

    public Color[][] drawNet(Color[][] screen, int[] inputval) {

        Nodes n = new Nodes(NetxAmount,
                screenxsize,
                NetyAmount,
                screenysize);

        int[][] nodeaddress = new int[NetyAmount][NetxAmount];
        int[] nodesaddress = new int[NetyAmount];
        int objecthight = n.NodeySize();
        int objectwidth = n.NodexSize();
        int c = 0;
        int Lx = screenxsize/NetxAmount;
        int Ly = screenysize/NetyAmount;

        for (int a = 0; a < NetyAmount; a++) {
//            nodesaddress[a] = ((Ly*(a+1) - Ly*a) / 2) - objecthight/2 + Ly*a; // Formel mit Abstand
            nodesaddress[a] = ((screenysize/2 - ((NetyAmount*objecthight)/2)) + a*objecthight); // Formel ohne Abstand
            System.out.println(nodesaddress[a]);
            for (int b = 0; b < NetxAmount; b++) {
//                nodeaddress[a][b] = ((Lx*(b+1) - Lx*b) / 2) - objectwidth/2 + Lx*b; // Formel mit Abstand
                nodeaddress[a][b] = ((screenxsize/2 - (NetxAmount*objectwidth/2)) + b*objectwidth); // Formel ohne Abstand
                System.out.println(nodeaddress[a][b]);
                screen = n.drawNode(
                        nodeaddress[a][b],
                        nodesaddress[a],
                        Color.grayRgb(inputval[c]),
                        screen);
                c++;
            }
        }

        return screen;
    }


}
