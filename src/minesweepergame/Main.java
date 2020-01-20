package minesweepergame;

import game.Board;
import game.MineSweeper;
import game.ui.MinesweeperGui;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String args[]){
        //Board b = new Board(8,8);
        
        MineSweeper game = new MineSweeper(8,8,10);
        //game.revealCellAt(9, 0);
        
        
        game.getGrid().printBoard();
        System.out.println("");
        System.out.println(game.getGrid().CellAt(0, 0).isEmpty());
        System.out.println(game.getGrid().CellAt(0, 0).getValue());
        System.out.println("");
        game.getGrid().printSeeableBoard();
        
        System.out.println("");
        game.revealCellAt(0, 0);
        MinesweeperGui ui = new MinesweeperGui(game, 30);
        SwingUtilities.invokeLater(ui);
        game.getGrid().printSeeableBoard();
        
    }
}
