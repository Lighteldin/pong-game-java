package me.jehn;

import me.jehn.entities.Ball;
import me.jehn.entities.Enemy;
import me.jehn.entities.Player;
import me.jehn.listeners.Keyboard;
import me.jehn.listeners.Mouse;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

public class GamePanel extends JPanel {
    //DECLARATIONS//
    private GameTech gameTech;

    private int gameWidth = 1280;
    private int gameHeight = 720;
    private Dimension gameDimension;

    public Player player;
    public Enemy enemy;
    public Ball ball;
    public Wall wall;

    //CONSTRUCTOR//
    public GamePanel() {
        init();

        setFocusable(true);
        setPreferredSize(gameDimension);
        setLayout(null);
        setBackground(black);
    }

    //METHODS//
    public void init(){
        gameTech = new GameTech(this);
        gameDimension = new Dimension(1280, 720);

        player = new Player(this);
        enemy = new Enemy(this);
        ball = new Ball(this);
        wall = new Wall(this);

        addKeyListener(new Keyboard(player));
        addMouseListener(new Mouse(player));
        addMouseMotionListener(new Mouse(player));
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(white);
        player.draw(g);
        ball.draw(g);
        enemy.draw(g);

    }



    //GETTER/SETTERS

    public int getGameWidth() {
        return gameWidth;
    }

    public void setGameWidth(int gameWidth) {
        this.gameWidth = gameWidth;
    }

    public int getGameHeight() {
        return gameHeight;
    }

    public void setGameHeight(int gameHeight) {
        this.gameHeight = gameHeight;
    }
}
