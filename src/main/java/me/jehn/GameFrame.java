package me.jehn;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameFrame extends JFrame {
    //DECLARATION//
    private GamePanel gamePanel;


    //CONSTRUCTOR//
    public GameFrame() {

        gamePanel = new GamePanel();
        add(gamePanel);
        pack();
        setResizable(false);
        setEmptyCurser();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


    }


    //METHODS//
    private void setEmptyCurser() {
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
        setCursor(blankCursor);
    }
}
