package org.jointheleague.level2.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import static java.awt.event.KeyEvent.*;

public class DoomGamePanel extends JPanel implements ActionListener, KeyListener, MouseListener {
    int currentState = 0;
    int s_MENU = 0;
    int s_GAME = 1;
    int s_END = 2;
    int bulletVelocity = 30;
    Timer enemySpawn;
    Timer frameDraw;
    Font titleFont;
    Font otherFont;
    int playerX = 800;
    int playerY = 450;
    int playerWidth = 25;
    int projectileX = playerX;
    int projectileY = playerY;
    int projectileWidth = 2;
    int distanceX;
    int distanceY; //267, 80 ,1066, 700
    public static int gameTop = 80;
    public static int gameRight = 1333;
    public static int gameLeft = 267;
    public static int gameBottom = 780;
    int gameWidth = 1066;
    int gameHeight = 700;
    private Player player = new Player(playerX, playerY, playerWidth, playerWidth);
    private ObjectManager objectManager = new ObjectManager(player);


    public DoomGamePanel() {
        frameDraw = new Timer(20, this);
        frameDraw.start();
        addMouseListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == VK_W) {
            player.up();
        }
        if (e.getKeyCode() == VK_A) {
            player.left();
        }
        if (e.getKeyCode() == VK_S) {
            player.down();
        }
        if (e.getKeyCode() == VK_D) {
            player.right();
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (currentState == s_MENU) {
                JOptionPane.showMessageDialog(null, "Use WASD keys to move, Kill enemies, pick up loot, escape the maze.");
            }
        }
        //TODO CREATE A NEW PLAYER WHEN ENDING THE GAME AND PASS IT INTO THE OBJECT MANAGER
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (this.currentState == this.s_END) {
                this.currentState = this.s_MENU;

                player = new Player(playerX, playerY, playerWidth, playerWidth);
                objectManager = new ObjectManager(player);
                System.out.println("currentState a" + this.currentState);
            } else if (this.currentState == this.s_MENU) {
                this.currentState++;
                startGame();
            } else if (this.currentState == this.s_GAME) {
                this.currentState++;
                enemySpawn.stop();

//                System.out.println("currentState b" + this.currentState);
//                if(this.currentState==this.s_GAME) {
//                    System.out.println("currentState c " + this.currentState);
//                }
//                else if (this.currentState == this.s_END) {
//                    System.out.println("ending game");
//                    enemySpawn.stop();
//                    for (Enemy enemy : objectManager.enemies) {
//
//                    }
//                }
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == VK_W) {
            player.releaseY();
        }
        if (e.getKeyCode() == VK_A) {
            player.releaseX();
        }
        if (e.getKeyCode() == VK_S) {
            player.releaseY();
        }
        if (e.getKeyCode() == VK_D) {
            player.releaseX();
        }
    }


    public void paintComponent(Graphics g) {
        this.titleFont = new Font("Arial", 0, 40);
        this.otherFont = new Font("Arial", 0, 28);
        if (this.currentState == this.s_MENU) {
            this.drawMenuState(g);
        } else if (this.currentState == this.s_GAME) {
            this.drawGameState(g);
        } else if (this.currentState == this.s_END) {
            this.drawEndState(g);
        }

    }

    void drawMenuState(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 1600, 900);
        g.setFont(this.titleFont);
        g.setColor(Color.WHITE);
        g.drawString("Doom 2D", 715, 150);
        g.setFont(this.otherFont);
        g.drawString("Press ENTER to Start", 662, 450);
        g.drawString("Press SPACE for Instructions", 615, 600);
    }

    void drawGameState(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1600, 900);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(gameLeft, gameTop, gameWidth, gameHeight);
        g.setColor(Color.WHITE);
        g.setFont(this.titleFont);
        g.drawString("Doom 2D", 715, 60);
//        player.movement();
        player.draw(g);
        objectManager.draw(g);
        //g.setColor(Color.ORANGE);
        //g.fillOval(playerX,play   erY,playerWidth,playerWidth);
        g.setColor(Color.white);
        //g.drawPolygon(new int[] {10, 20, 30}, new int[] {100, 20, 100}, 3);
//        p = MouseInfo.getPointerInfo().getLocation();
//        g.drawLine(playerX+(playerWidth/2),playerY+(playerWidth/2), p.x-10, p.y-30);

    }

    void drawEndState(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, 1600, 900);
        g.setColor(Color.WHITE);
        g.setFont(this.titleFont);
        g.drawString("Game Over", 695, 150);
        g.setColor(Color.WHITE);
        g.setFont(this.otherFont);
        g.drawString("Your Total Score was: " + objectManager.getScore(), 600, 500);
    }

    public void actionPerformed(ActionEvent e) {
        if (this.currentState == this.s_MENU) {
            this.updateMenuState();
        }
        if (this.currentState == this.s_GAME) {
            this.updateGameState();
        }
        if (this.currentState == this.s_END) {
            this.updateEndState();
        }
        this.repaint();
    }

    private void updateEndState() {
    }

    private void updateGameState() {
        if (!player.isActive) {
            currentState = s_END;
            return;
        }
        objectManager.update();
    }

    private void updateMenuState() {
    }

    public void screen() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && currentState == s_GAME) {
            objectManager.addProjectile(player.getProjectile());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }

    void startGame() {
        if (currentState == s_GAME) {
            enemySpawn = new Timer(1000, objectManager);
            enemySpawn.start();
            System.out.println("starting game");
        }
    }
}

