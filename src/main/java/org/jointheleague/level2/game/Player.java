package org.jointheleague.level2.game;

import java.awt.*;

public class Player extends GameObject {
    int velocityX = 0;
    int velocityY = 0;

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
        speed = 5;
    }

    void draw(Graphics g) {
        update();
        g.setColor(Color.ORANGE);
        g.fillOval(x, y, width, height);
    }

    void update() {
        checkBorders();
        x += velocityX;
        y += velocityY;
    }

    public void checkBorders() {
        if (x >= DoomGamePanel.gameRight - width) {
            x = DoomGamePanel.gameRight - width;
        } else if (x <= DoomGamePanel.gameLeft) {
            x = DoomGamePanel.gameLeft;
        } else if (y <= DoomGamePanel.gameTop) {
            y = DoomGamePanel.gameTop;
        } else if (y >= DoomGamePanel.gameBottom - height) {
            y = DoomGamePanel.gameBottom - height;
        }
    }

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


}
