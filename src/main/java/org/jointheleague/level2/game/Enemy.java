package org.jointheleague.level2.game;

import java.awt.*;

public class Enemy extends GameObject{
    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height);
        speed = 1;
    }

    void update() {
        super.update();
        y+=speed;
    }

    void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }
}
