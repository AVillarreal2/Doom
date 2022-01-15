package org.jointheleague.level2.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DoomGamePanel extends JPanel implements ActionListener, KeyListener {
    int currentState = 0;
    int s_MENU = 0;
    int s_GAME = 1;
    int s_END = 2;
    Timer timer = new Timer(133, this);
    Font titleFont;
    Font otherFont;

    public DoomGamePanel() {
        this.timer.start();
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 87) {
        }

        if (e.getKeyCode() == 65) {
        }

        if (e.getKeyCode() == 83) {
        }

        if (e.getKeyCode() == 68) {
        }

        if (e.getKeyCode() == 10) {
            if (this.currentState == this.s_END) {
                this.currentState = this.s_MENU;
            } else {
                ++this.currentState;
            }
        }

    }

    public void keyReleased(KeyEvent e) {
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
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1600, 900);
        g.setFont(this.titleFont);
        g.setColor(Color.WHITE);
        g.drawString("LEAGUE INVADERS", 50, 150);
        g.setFont(this.otherFont);
        g.drawString("Press ENTER to Start", 100, 450);
        g.drawString("Press SPACE for Instructions", 60, 600);
    }

    void drawGameState(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 1600, 900);
    }

    void drawEndState(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, 1600, 900);
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

        System.out.println("you are in action performed");
        System.out.println("currentState: " + this.currentState);
        this.repaint();
    }

    private void updateEndState() {
    }

    private void updateGameState() {
    }

    private void updateMenuState() {
    }
}

