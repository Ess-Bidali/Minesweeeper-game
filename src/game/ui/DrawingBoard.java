package game.ui;

import game.Cell;
import game.MineSweeper;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawingBoard extends JPanel{
    private final MineSweeper game;
    private final JButton[][] buttons;
    private final Container container;
    
    public DrawingBoard(MineSweeper game,Container container){
        this.game = game;
        this.buttons = new JButton[this.game.getGrid().getHeight()][this.game.getGrid().getWidth()];
        this.container = container;
    }
    
    @Override
    protected void paintComponent(Graphics graphic){
        super.paintComponent(graphic);
        
        for(int y = 0; y < this.buttons.length; y++){
            for(int x = 0; x < this.buttons[y].length; x++){
                buttons[y][x] = new JButton();
                buttons[y][x].addMouseListener(new ClickHandler(game,x,y));
                if(game.getGrid().CellAt(x, y).getIsRevealed()== true){
                    //buttons[y][x].setText("   " + this.game.getGrid().CellAt(x, y).getValue());
                    
                    //container.add(buttons[y][x]);

                    
                }
                //else{
                    //container.add(new JLabel("   " + this.game.getGrid().CellAt(x, y).getValue()));
                //}
                add(buttons[y][x]);
            }
        }
    }
    
}
