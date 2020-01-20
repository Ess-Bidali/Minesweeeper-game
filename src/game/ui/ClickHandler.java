/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.ui;

import game.MineSweeper;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author ADMIN
 */

public class ClickHandler implements MouseListener{
    private MineSweeper game;
    private int x,y;
    
    public ClickHandler(MineSweeper game, int x, int y){
        this.game = game;
        this.x = x;
        this.y = y;
    }
    
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getButton()== MouseEvent.BUTTON1){
            this.game.revealCellAt(x,y);
            System.out.println("");
            this.game.getGrid().printSeeableBoard();
            
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
