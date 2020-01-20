/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;


import game.ui.DrawingBoard;
import java.util.Random;


public class MineSweeper{
    private final Board grid;
    private final Random rand;
    private boolean continues;
    private Cell lastRevealed;
    private DrawingBoard dBoard;

    
    public MineSweeper(int width, int height, int numberOfBombs){
        this.grid = new Board(width, height);
        this.rand = new Random();
        this.continues = true;
        this.generateBombs();
        this.mapBombs();

    }
    
    public Board getGrid() {
        return grid;
    }
    
    public Cell getLastRevealed() {
        return lastRevealed;
    }

    public void setLastRevealed(Cell lastRevealed) {
        this.lastRevealed = lastRevealed;
    }
    
    private void generateBombs(){
        int percentageOfBombs = 15;
        int howMany = ((this.grid.getHeight()*this.grid.getWidth())*percentageOfBombs/100) + 1;
        for(int i = 0; i < howMany; i++){
            int x = rand.nextInt(getGrid().getWidth());
            int y = rand.nextInt(getGrid().getHeight());
            
            //set bomb if cell doesnt already contain a bomb otherwise guess a random cell again
            if(!this.grid.CellAt(x, y).hasBomb()){
                this.grid.CellAt(x, y).setValue("x"); // x indicates a bomb
            }
            else{
                i--;
            }
        }
    }
    
    private void mapBombs(){
        for(int y = 0; y < this.grid.getHeight(); y++){
            for(int x = 0; x < this.grid.getWidth(); x++){
                if(!this.grid.CellAt(x, y).hasBomb()){
                    int val = this.numberOfSurroundingBombs(x, y);
                    this.getGrid().CellAt(x, y).setValue(String.valueOf(val));
                }
            }
        }
    }
    
    //helper method for mapBombs()
    public int numberOfSurroundingBombs(int x, int y){
        int numberOfBombs = 0;
        
        //when x has cells to its left
        if(x > 0){
            if(this.grid.CellAt(x-1, y).hasBomb()){
                numberOfBombs++;
            }
            if(y > 0){
                if(this.grid.CellAt(x-1, y-1).hasBomb()){
                    numberOfBombs++;
                }
            }
            if(y < this.grid.getHeight()-1){
                if(this.grid.CellAt(x-1, y+1).hasBomb()){
                    numberOfBombs++;
                }
            }
        }
        
        if(y > 0){
            if(this.grid.CellAt(x, y-1).hasBomb()){
                numberOfBombs++;
            }
            if(x < this.grid.getWidth()-1){
                if(this.grid.CellAt(x+1, y-1).hasBomb()){
                    numberOfBombs++;
                }
            }
        }
        
        if(x < this.grid.getWidth()-1){
            if(this.grid.CellAt(x+1, y).hasBomb()){
                numberOfBombs++;
            }
        }
        
        if(y < this.grid.getHeight()-1){
            if(this.grid.CellAt(x, y+1).hasBomb()){
                numberOfBombs++;
            }
        }
        
        if(x < this.grid.getWidth()-1 && y < this.grid.getHeight()-1){
            if(this.grid.CellAt(x+1, y+1).hasBomb()){
                numberOfBombs++;
            }
        }
        
        return numberOfBombs;
    }
    
    public boolean revealCellAt(int x, int y){
        
        if(this.grid.CellAt(x, y).getIsRevealed()==true){
            return this.continues;
        }
        
        this.grid.CellAt(x, y).setIsRevealed(true);
        this.setLastRevealed(this.grid.CellAt(x, y));
        
        if(this.grid.CellAt(x, y).hasBomb()){
            this.continues = false;
            System.out.println("Bomb!!");
        }
        
        //else check other cells minus diagonals
        else if(this.grid.CellAt(x,y).isEmpty()){
            if(x > 0){
                this.revealCellAt(x-1, y);
            }
            
            if(y > 0){
                this.revealCellAt(x,y-1); 
            }

            if(x < this.grid.getWidth()-1){
                this.revealCellAt(x+1, y);
            }
            
            if(y < this.grid.getHeight()-1){
                this.revealCellAt(x, y+1);
            }            
        }
        return this.continues;
    }    

    /**
     * @param dBoard the dBoard to set
     */
    public void setdBoard(DrawingBoard dBoard) {
        this.dBoard = dBoard;
    }

    
    
    
    
}
