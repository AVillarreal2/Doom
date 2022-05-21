package org.jointheleague.level2.game;

import java.awt.*;

public class GameObject {
    int x;
    int y;
    int width;
    int height;
    int speed = 0;
    boolean isActive = true;
    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
//        collisionBox = new Rectangle(x, y, width, height);
    }

//    void update() {
//        collisionBox.setBounds(x, y, width, height);
//    }
//    //sets the bounds for the collision box
//}
}
