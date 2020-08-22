/*
 * Created on 27-Jun-2017 by amehra1
 *
 * Copyright (c) 2017 Walmart Inc. All Rights Reserved.
 */
package com.flipkart.tetris;

import java.util.ArrayList;

public class Board {

    private int size;
    private Cell grid[][];
    private ArrayList<WinningSet> winningSet;

    // BUILDER design pattern
    public static class Builder {

        private int size;
        private Cell grid[][];
        private ArrayList<WinningSet> winningSet;

        public Builder setSize(int size) {

            this.size = size;
            return this;
        }

        public Builder setGrid() {

            grid = new Cell[size + 1][size + 1];
            for (int i = 0; i <= size; ++i) {
                for (int j = 0; j <= size; ++j) {
                    grid[i][j] = new Cell(CellType.E);// mark all empty
                }
            }

            return this;
        }

        public Builder setwinningSet() {

            winningSet = new ArrayList<WinningSet>();
            return this;

        }

        public Board build() {

            return new Board(this);
        }
    }

    private Board(Builder builder) {
        this.size = builder.size;
        this.grid = builder.grid;
        this.winningSet = builder.winningSet;
    }

    public int getSize() {

        return size;
    }

    public void setSize(int size) {

        this.size = size;
    }

    public Cell[][] getGrid() {

        return grid;
    }

    public void setGrid(Cell[][] grid) {

        this.grid = grid;
    }

    public ArrayList<WinningSet> getWinningSet() {

        return winningSet;
    }

    public void setWinningSet(ArrayList<WinningSet> winningSet) {

        this.winningSet = winningSet;
    }

}
