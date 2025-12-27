package me.jehn.entities;

import me.jehn.GamePanel;

import javax.management.timer.Timer;
import javax.swing.*;
import java.awt.*;

import static me.jehn.Constants.Movement.*;

public class Player extends Entity{
    //DECLARATIONS//
    private int yPosStart;
    private int action;


    //CONSTRUCTOR//
    public Player(GamePanel gamePanel) {
        super(gamePanel, 0,0,15,100, 1);
        init();
    }


    //METHODS//
    @Override
    public void init() {

        xPosStart = (int) (gamePanel.getGameWidth() * 0.95);

        setxPos(xPosStart);
        setyPos(yPosStart);
        setAction(STOP);
    }

    @Override
    public void draw(Graphics g) {
        g.fillRect(getxPos(), getyPos(), getWidth(), getHeight());
        if (canMoveKeyboard())
            move();
    }

    public boolean canMoveKeyboard(){
        switch (action){
            case UP:
                if(getyPos() <= 0)
                    return false;
                break;
            case DOWN:
                if(getyPos() + getHeight() >= gamePanel.getGameHeight())
                    return false;
                break;
        }
        return true;
    }

    public boolean canMoveMouse(int y){
        if(y <= 0 || y + getHeight() >= gamePanel.getGameHeight())
            return false;
        return true;
    }

    public void move(){
        switch (action){
            case UP:
                setyPos(getyPos() - 5);
                
                break;
            case DOWN:
                setyPos(getyPos() + 5);
                break;
        }
    }

    public void setAction(int action){
        this.action = action;
    }
}
