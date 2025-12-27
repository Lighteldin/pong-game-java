package me.jehn;

import javax.swing.*;
import java.awt.image.BufferStrategy;
import java.nio.Buffer;

public class GameTech implements Runnable{
    private GamePanel gamePanel;
    private final int FPS_SET = 120;
    private int frames = 0;
    private long lastCheck = 0;


    public GameTech(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        while(true){
            now = System.nanoTime();

            if(now - lastFrame >= timePerFrame) {
                gamePanel.repaint();
                lastFrame = now;
                frames++;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
    }
}
