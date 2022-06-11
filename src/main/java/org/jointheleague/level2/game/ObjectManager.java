package org.jointheleague.level2.game;

import java.awt.*;
import java.util.ArrayList;

public class ObjectManager {
    Player player;
    public ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

    public ObjectManager(Player player) {
        this.player = player;
    }

    public void addProjectile(Projectile projectile) {
        projectiles.add(projectile);
    }

    void update(){
        updateProjectiles();
    }

    void draw(Graphics g){
        for (Projectile projectile : projectiles) {
            projectile.draw(g);
        }
    }

    private void updateProjectiles() {
        for (Projectile projectile : projectiles) {
            projectile.update();
            System.out.println("updating");
            if (projectile.x > DoomGamePanel.gameRight) {
                projectile.isActive = false;
            }
        }
    }
}
