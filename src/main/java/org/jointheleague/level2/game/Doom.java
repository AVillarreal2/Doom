package org.jointheleague.level2.game;

import javax.swing.*;

public class Doom {
    JFrame frame;
    DoomGamePanel panel;
    public static final int doomFrameWIDTH = 1600;
    public static final int doomFrameHEIGHT = 900;

    public static void main(String[] args) {
        Doom display = new Doom();
        display.initializeDoom();
    }

    public Doom() {
        frame = new JFrame();
        panel = new DoomGamePanel();
    }
    public void initializeDoom() {
        frame.add(panel);
        frame.setSize(doomFrameWIDTH, doomFrameHEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addKeyListener(panel);
    }

}

