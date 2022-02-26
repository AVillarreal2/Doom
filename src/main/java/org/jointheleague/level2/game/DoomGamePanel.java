package org.jointheleague.level2.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

import static java.awt.event.KeyEvent.*;

public class DoomGamePanel extends JPanel implements ActionListener, KeyListener, MouseListener {
    int currentState = 0;
    int s_MENU = 0;
    int s_GAME = 1;
    int s_END = 2;
    int bulletVelocity = 30;
    Timer timer = new Timer(133, this);
    Font titleFont;
    Font otherFont;
    int playerX = 800;
    int playerY = 450;
    int playerWidth = 25;
    int playerVelocityX = 0;
    int playerVelocityY = 0;
    int distanceX;
    int distanceY;

    public DoomGamePanel() {
        this.timer.start();
        addMouseListener(this);
    }

    public void keyTyped(KeyEvent e) {
    }

    public void checkBarriers(){
        if (playerX<=267) {
            playerX+=10;
            playerVelocityX = 0;
        }if (playerX>=1333-playerWidth){
            playerX-=10;
            playerVelocityX = 0;
        }if (playerY<=80){
            playerY+=10;
            playerVelocityY = 0;
        }if (playerY>=780-playerWidth){
            playerY-=10;
            playerVelocityY = 0;
        }
    }

    public void movement(){
        playerX+=playerVelocityX;
        playerY+=playerVelocityY;
        checkBarriers();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == VK_W) {
            playerVelocityY = -10;
        }
        if (e.getKeyCode() == VK_A) {
            playerVelocityX = -10;
        }
        if (e.getKeyCode() == VK_S) {
            playerVelocityY = 10;
        }
        if (e.getKeyCode() == VK_D) {
            playerVelocityX = 10;
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(currentState==s_MENU) {
                JOptionPane.showMessageDialog(null, "Use WASD keys to move, Kill enemies, pick up loot, escape the maze.");
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (this.currentState == this.s_END) {
                this.currentState = this.s_MENU;
            } else {
                ++this.currentState;
            }
        }

    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == VK_W) {
            playerVelocityY = 0;
        }
        if (e.getKeyCode() == VK_A) {
            playerVelocityX = 0;
        }
        if (e.getKeyCode() == VK_S) {
            playerVelocityY = 0;
        }
        if (e.getKeyCode() == VK_D) {
            playerVelocityX = 0;
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
        g.fillRect(267, 80 ,1066, 700);
        g.setColor(Color.WHITE);
        g.setFont(this.titleFont);
        g.drawString("Doom 2D", 715, 60);
        g.setColor(Color.ORANGE);
        g.fillOval(playerX,playerY,playerWidth,playerWidth);
        g.setColor(Color.white);
        movement();
        //g.drawPolygon(new int[] {10, 20, 30}, new int[] {100, 20, 100}, 3);


    }

    void drawEndState(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, 1600, 900);
        g.setColor(Color.WHITE);
        g.setFont(this.titleFont);
        g.drawString("Game Over", 695, 150);
        g.setColor(Color.WHITE);
        g.setFont(this.otherFont);
        g.drawString("Your Total Score was: ", 600, 500);
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
    }

    private void updateMenuState() {
    }

    public void screen(){

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(currentState==s_GAME){
            distanceX = e.getX() - playerX;
            distanceY = e.getY() - playerY;
            bullet(distanceX, distanceY);
        }
    }

    public void bullet(int distanceX, int distanceY){
        //distanceX / 4;
        //distanceY / 4;
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
}

