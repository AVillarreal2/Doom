package org.jointheleague.level2.game;

import java.awt.*;

public class Player extends GameObject {
    int velocityX = 0;
    int velocityY = 0;
//    Point p = MouseInfo.getPointerInfo().getLocation();

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
        speed = 5;
    }

    void draw(Graphics g) {
        update();
        g.setColor(Color.ORANGE);
        g.fillOval(x, y, width, height);
//        drawLaser(g);
    }

    void update() {
        super.update();
        x += velocityX;
        y += velocityY;
        checkBorders();
    }

//    public void checkBorders() {
//        if (x >= DoomGamePanel.gameRight - width) {
//            x = DoomGamePanel.gameRight - width;
//        } else if (x <= DoomGamePanel.gameLeft) {
//            x = DoomGamePanel.gameLeft;
//        }
//
//        if (y <= DoomGamePanel.gameTop) {
//            y = DoomGamePanel.gameTop;
//        } else if (y >= DoomGamePanel.gameBottom - height) {
//            y = DoomGamePanel.gameBottom - height;
//        }
//    }

    public void left() {
        velocityX = -speed;
    }

    public void right() {
        velocityX = speed;
    }

    public void up() {
        velocityY = -speed;
    }

    public void down() {
        velocityY = speed;
    }

    public void releaseX() {
        velocityX = 0;
    }

    public void releaseY() {
        velocityY = 0;
    }

//    void drawLaser(Graphics g) {
//        Point p = MouseInfo.getPointerInfo().getLocation();
//        g.drawLine(x + (width/2), y + (width/2), p.x-10, p.y-30);
//    }

    public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 10);
    }
}
