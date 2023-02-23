package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Hexagon2 {
    private int column,row;
    private int[][] grid;

    public Hexagon2(int column ,int row) {
        this.column = column;
        this.row = row;
        this.grid = new int[row][column];
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
    //    public int getSize(){
//        return size;
//    }
    public void setHexagonValue(int x, int y, int value) {
        if (x >= 0 && x < column && y >= 0 && y < row) {
            grid[x][y] = value;
        }
    }

    public int getHexagonValue(int x, int y) {
        if (x >= 0 && x < column && y >= 0 && y < row) {
            return grid[x][y];
        }
        return -1;
    }

    public List<List<Integer>> getGrid() {
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> list = new ArrayList<>();
            for (int value : row) {
                list.add(value);
            }
            result.add(list);
        }
        return result;
    }
}

