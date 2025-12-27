package me.jehn.listeners;

import me.jehn.entities.Player;

import java.awt.event.*;

public class Mouse implements MouseMotionListener, MouseListener {
    Player player;
    public Mouse(Player player){
        this.player = player;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

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
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(player.canMoveMouse(e.getY()))
            player.setyPos(e.getY());
    }
}