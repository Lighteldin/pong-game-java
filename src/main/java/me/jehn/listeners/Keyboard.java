package me.jehn.listeners;

import me.jehn.GamePanel;
import me.jehn.entities.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;
import static me.jehn.Constants.Movement.*;

public class Keyboard implements KeyListener {
    Player player;
    public Keyboard(Player player){
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case VK_UP:
            case VK_W:
                player.setAction(UP);
                break;
            case VK_DOWN:
            case VK_S:
                player.setAction(DOWN);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.setAction(STOP);
    }
}
