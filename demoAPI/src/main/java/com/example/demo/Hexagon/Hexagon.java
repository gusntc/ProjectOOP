package com.example.demo.Hexagon;

public class Hexagon {
    private int row , column;
    private int[][] grid;

    public Hexagon(int row, int column) {
        this.row = row;
        this.column = column;
//        this.grid = new int[row][column];
        generateHexagonalGrid(row, column);
    }
    public int[][] generateHexagonalGrid(int row , int column){
        int[][] newGrid = new int[row][column];
        for(int i=0 ; i<row ; i++){
            for(int j=0 ; j<column ; j++){
                newGrid[i][j] = i+j;
            }
        }
        return  newGrid;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGridValue(int value ,int row , int column){
        this.grid[row][column] = value;
    }
}
