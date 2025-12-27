package me.jehn.entities;

import me.jehn.GamePanel;

import java.awt.*;

public abstract class Entity {
    protected GamePanel gamePanel;
    protected int xPos;
    protected int yPos;
    protected int width;
    protected int height ;
    protected int yPosStart;
    protected int xPosStart;
    protected int xSpeed;
    protected int ySpeed;


    public Entity(GamePanel gamePanel, int xPos, int yPos, int width, int height, int speed) {
        this.gamePanel = gamePanel;
        yPosStart = (int) (gamePanel.getGameHeight()/2)-(height/2);
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.xSpeed = speed;
        this.ySpeed = speed;
    }

    public abstract void init();
    public abstract void draw(Graphics g);

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getYSpeed() {
        return ySpeed;
    }

    public int getXSpeed() {
        return xSpeed;
    }

    public void setSpeed(int speed) {
        this.xSpeed = speed;
        this.ySpeed = speed;
    }
}
