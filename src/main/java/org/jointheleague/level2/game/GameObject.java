package org.jointheleague.level2.game;

import java.awt.*;

public class GameObject {
    int x;
    int y;
    int width;
    int height;
    int speed = 0;
    boolean isActive = true;
    Rectangle collisionBox;

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        collisionBox = new Rectangle(x, y, width, height);
    }


    void update() {
        collisionBox.setBounds(x, y, width, height);
    }
        //checkCollision() in ObjectManager

    public void checkBorders() {
        if (x >= DoomGamePanel.gameRight - width) {
            x = DoomGamePanel.gameRight - width;
        } else if (x <= DoomGamePanel.gameLeft) {
            x = DoomGamePanel.gameLeft;
        }

        if (y <= DoomGamePanel.gameTop) {
            y = DoomGamePanel.gameTop;
        } else if (y >= DoomGamePanel.gameBottom - height) {
            y = DoomGamePanel.gameBottom - height;
        }
    }
}
