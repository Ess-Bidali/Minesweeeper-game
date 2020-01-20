/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

public class Cell {
    private boolean isRevealed;//whether the cell content is isRevealed or not
    private String value; //whether cell is empty(0), next to a bomb(number) or has a bomb(x)
    private int positionX;
    private int positionY;
    
    public Cell(){
        this.isRevealed = false;
        this.value = "0";
    }

    
    public boolean getIsRevealed() {
        return isRevealed;
    }

    public void setIsRevealed(boolean isRevealed) {
        this.isRevealed = isRevealed;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public boolean isEmpty(){
        return this.getValue().equals("0");
    }
    public boolean hasBomb(){
        return this.getValue().equals("x");
    }

    /**
     * @return the positionX
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * @param positionX the positionX to set
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     * @return the positionY
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * @param positionY the positionY to set
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    
}
