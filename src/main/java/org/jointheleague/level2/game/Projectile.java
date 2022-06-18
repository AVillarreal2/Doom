package org.jointheleague.level2.game;

import java.awt.*;
import java.util.ArrayList;

public class Projectile extends GameObject {
    public Projectile(int x, int y, int width, int height) {
        super(x, y, width, height);
        speed = 20;
    }

    void draw(Graphics g) {
        Point p = MouseInfo.getPointerInfo().getLocation();
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width+5, height+5);
    }

    void update() {
        super.update();
        x+=speed;
    //checkBorders();
//        if(x>DoomGamePanel.gameRight) {
//            projectile
//        }
    }
}
