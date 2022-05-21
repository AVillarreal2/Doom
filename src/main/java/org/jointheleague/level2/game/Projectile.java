package org.jointheleague.level2.game;

import java.awt.*;

public class Projectile extends GameObject {
    Point p = MouseInfo.getPointerInfo().getLocation();
    public Projectile(int x, int y, int width, int height) {
        super(x, y, width, height);
        speed = 10;
    }
    void draw(Graphics g) {
        p = MouseInfo.getPointerInfo().getLocation();
        g.drawLine(x+(width/2),y+(width/2), p.x-10, p.y-30);
    }

    void update() {
    }
}
