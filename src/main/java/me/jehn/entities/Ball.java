package me.jehn.entities;

import me.jehn.GamePanel;

import java.awt.*;
import java.util.Random;
import static me.jehn.Constants.Collision.*;

public class Ball extends Entity{
    //DECLARATIONS//
    private boolean hasHitBat;
    private int xToGo;
    private int yToGo;
    private int collisionType;



    //CONSTRUCTOR//
    public Ball(GamePanel gamePanel) {
        super(gamePanel, 0,0,15,15, 1);
        init();
    }


    //METHODS//
    @Override
    public void init() {
        initializeBall();
        hasHitBat = false;

        //
        xPosStart = (int) (gamePanel.getGameWidth() * 0.5);
        yPosStart = (int) (gamePanel.getGameHeight() * 0.5);
        setxPos(xPosStart);
        setyPos(yPosStart);

    }

    @Override
    public void draw(Graphics g) {
        detectCollision();
        switch (collisionType){
            case WALL:
                ySpeed*=-1;
                collisionType = NONE;
                break;
            case UPPER:
                xSpeed*=-1;
                ySpeed = -Math.abs(ySpeed);
                collisionType = NONE;
                break;
            case LOWER:
                xSpeed*=-1;
                ySpeed = Math.abs(ySpeed);
                collisionType = NONE;
                break;
            case PLAYER_VOID:
                restartBall();
                collisionType = NONE;
                break;
            case ENEMY_VOID:
                restartBall();
                collisionType = NONE;
                break;
        }
        g.fillOval(getxPos()+getXSpeed(), getyPos()+getYSpeed(), getWidth(), getHeight());
        setxPos(getxPos() + getXSpeed());
        setyPos(getyPos() + getYSpeed());
    }

    private void initializeBall() {
        Random random = new Random();
        xSpeed = (random.nextBoolean() ? 1 : -1) * (random.nextInt(3) + 5);
        ySpeed = (random.nextBoolean() ? 1 : -1) * (random.nextInt(3) + 5);
    }

    public void detectCollision(){
        int xPosPlayer = gamePanel.player.getxPos();
        int yPosPlayer = gamePanel.player.getyPos();
        int widthPlayer = gamePanel.player.getWidth();
        int heightPlayer = gamePanel.player.getHeight();

        int xPosEnemy = gamePanel.enemy.getxPos();
        int yPosEnemy = gamePanel.enemy.getyPos();
        int widthEnemy = gamePanel.player.getWidth();
        int heightEnemy = gamePanel.player.getHeight();

        if (xPos + width >= xPosPlayer && xPos <= xPosPlayer + widthPlayer) {
            if (yPos + height >= yPosPlayer && yPos <= yPosPlayer + (heightPlayer/2))
                collisionType = UPPER;
            else if (yPos + height >= yPosPlayer + (heightPlayer/2) && yPos <= yPosPlayer + heightPlayer)
                collisionType = LOWER;
        }
        if (xPos <= xPosEnemy + widthEnemy && xPos + width >= xPosEnemy) {
            if (yPos >= yPosEnemy && yPos <= yPosEnemy + (heightEnemy/2))
                collisionType = UPPER;
            else if (yPos >= yPosEnemy + (heightEnemy/2) && yPos <= yPosEnemy + heightEnemy)
                collisionType = LOWER;
        }

        if (yPos <= 0 || yPos+height >= gamePanel.getGameHeight()){
            collisionType = WALL;
        }
        if (xPos <= 0){
            collisionType = ENEMY_VOID;
        }
        if (xPos+height >= gamePanel.getGameWidth()){
            collisionType = PLAYER_VOID;
        }
    }

    public void restartBall(){
        setxPos(xPosStart);
        setyPos(yPosStart);
        setSpeed(4);
        hasHitBat = false;
        initializeBall();
    }
}