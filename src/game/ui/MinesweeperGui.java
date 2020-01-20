package game.ui;

import game.MineSweeper;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;


public class MinesweeperGui implements Runnable{
    private JFrame frame;
    private final int cellLength;
    private final MineSweeper game;
    private final JButton[][] buttons;
    private final int height;
    private final int width;
    private DrawingBoard dBoard;
    
    public MinesweeperGui(MineSweeper game, int cellSize){
        this.game = game;
        
        this.cellLength = cellSize;
        this.height = this.game.getGrid().getHeight();
        this.width = this.game.getGrid().getWidth();
        this.buttons = new JButton[height][width];
    }
    
    @Override
    public void run(){
        this.frame = new JFrame("Minesweeper");
        int frameWidth = (width) * cellLength ;
        int frameHeight = (height) * cellLength ;
        
        getFrame().setPreferredSize(new Dimension(frameWidth, frameHeight));
        getFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(getFrame().getContentPane());
        
        getFrame().pack();
        getFrame().setVisible(true);
        
    }
    
    public void createComponents(Container container){
        container.setLayout(new GridLayout(height,width,3,3));
        //createButtonField(container);
        dBoard = new DrawingBoard(game,container);
        container.add(dBoard);
        dBoard.revalidate();
        dBoard.repaint();
        
    }
    
    public void createButtonField(Container container){
        for(int y = 0; y < this.buttons.length; y++){
            for(int x = 0; x < this.buttons[y].length; x++){
                if(game.getGrid().CellAt(x, y).getIsRevealed()== false){
                    buttons[y][x] = new JButton();
                    buttons[y][x].addMouseListener(new ClickHandler(game,x,y));
                    container.add(buttons[y][x]);
                }
                else{
                    container.add(new JLabel("   " + this.game.getGrid().CellAt(x, y).getValue()));
                }
            }
        }
    }

    public JFrame getFrame() {
        return frame;
    }
    
}
