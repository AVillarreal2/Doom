package org.jointheleague.level2.game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import static org.jointheleague.level2.game.DoomGamePanel.gameLeft;
import static org.jointheleague.level2.game.DoomGamePanel.gameRight;

public class ObjectManager implements ActionListener {
    Player player;
    int score = 0;
    public ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    public ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private Random random = new Random();

    public ObjectManager(Player player) {
        this.player = player;
    }

    void addEnemy() {
        enemies.add(new Enemy(gameRight - 50, random.nextInt(Doom.doomFrameHEIGHT - 250) + 80, 50, 50));
//        System.out.println("number of enemies = " + enemies.size());
    }

    public void addProjectile(Projectile projectile) {
        projectiles.add(projectile);
    }

    void update() {
        updateProjectiles();
        updateEnemies();
        checkCollision();
        purgeObjects();
    }

    private void updateEnemies() {
        for (Enemy enemy : enemies) {
            enemy.update();
            if (enemy.x < gameLeft) {
                enemy.isActive = false;
            }
        }
    }

    private void updateProjectiles() {
        for (Projectile projectile : projectiles) {
            projectile.update();
            System.out.println("updating");
            if (projectile.x > gameRight - 10) {
                projectile.isActive = false;
            }
        }
    }

    private void updatePlayer() {
        player.update();
    }

    void draw(Graphics g) {
        for (Projectile projectile : projectiles) {
            projectile.draw(g);
        }
        for (Enemy enemy : enemies) {
            enemy.draw(g);
        }
    }


    void purgeObjects() {
        if (enemies.isEmpty()) {
            return;
        }
        for (int i = 0; i < enemies.size(); i++) {
            if (!enemies.get(i).isActive) {
                enemies.remove(i);
                System.out.println("removing alien #" + i);
            }
        }
        for (int i = 0; i < projectiles.size(); i++) {
            if (!projectiles.get(i).isActive) {
                projectiles.remove(i);
            }
        }
    }

    void checkCollision() {
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if (!player.isActive) {
                return;
            }
            if (enemy.collisionBox.intersects(player.collisionBox)) {
                enemy.isActive = false;
                player.isActive = false;
                System.out.println("killed by alien number " + i);
                return;
            }
            for (Projectile projectile : projectiles) {
                if (enemy.collisionBox.intersects(projectile.collisionBox)) {
                    projectile.isActive = false;
                    enemy.isActive = false;
                    setScore(getScore() + 1);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        addEnemy();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score1) {
        this.score = score1;
    }
}
