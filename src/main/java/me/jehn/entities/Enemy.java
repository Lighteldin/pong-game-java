package me.jehn.entities;

import me.jehn.GamePanel;

import java.awt.*;

public class Enemy extends Entity{
    //DECLARATIONS//

    //CONSTRUCTOR//
    public Enemy(GamePanel gamePanel) {
        super(gamePanel, 0, 0, 15, 100, 4);
        init();
    }

    //METHODS//
    public void init(){
        xPosStart = (int) (gamePanel.getGameWidth() * 0.05);

        setxPos(xPosStart);
        setyPos(yPosStart);
    }

    @Override
    public void draw(Graphics g) {
        int yBallPos = gamePanel.ball.getyPos();

        g.fillRect(getxPos(), getyPos(), getWidth(), getHeight());

        if (canMove(yBallPos - height/2)){
            if(getyPos() + (height/2) > yBallPos)
                setyPos(getyPos()-ySpeed);
            if(getyPos() + (height/2) < yBallPos)
                setyPos(getyPos()+ySpeed);
        }
    }
    public boolean canMove(int y){
        if(y <= 0 || y + getHeight() >= gamePanel.getGameHeight())
            return false;
        return true;
    }

}
