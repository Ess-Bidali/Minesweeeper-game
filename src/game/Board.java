package game;


public class Board {
    
    private final int width;
    private final int height;
    private final Cell[][] cells;
    
    public Board(int width, int height){
        this.width = width;
        this.height = height;
        this.cells = new Cell[height][width];
        this.addCells();
    }
    private void addCells(){
        for(int j = 0; j < cells.length; j++){
            for(int i = 0; i < cells[j].length; i++){
                cells[j][i] = new Cell();
                cells[j][i].setPositionX(i);
                cells[j][i].setPositionY(j);
            }
        }
    }
    
    public Cell CellAt(int x, int y) {
        return this.getCells()[y][x];
    }
    
    public int getWidth() {
        return width;
    }
   
    public int getHeight() {
        return height;
    }
    
    public void printBoard(){
        for(Cell[] ar: this.getCells()){
            for (Cell ar1 : ar) {
                System.out.print("[" + ar1.getValue() + "]");
            }
            System.out.println("");
        }
    }
    
    public void printSeeableBoard(){
        for(Cell[] ar: this.getCells()){
            for (Cell ar1 : ar) {
                System.out.print("[" + ar1.getIsRevealed() + "]");
            }
            System.out.println("");
        }
    }

    public Cell[][] getCells() {
        return cells;
    }
}
