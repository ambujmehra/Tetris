/*
 * Created on 27-Jun-2017 by amehra1
 *
 * Copyright (c) 2017 Walmart Inc. All Rights Reserved.
 */
package com.flipkart.tetris;

import java.util.ArrayList;


public class HumanMode implements GameType {
    ArrayList<WinningSet> resultSets;
    
    public HumanMode(){
        resultSets = new ArrayList<WinningSet>();
    }
    public void play(ArrayList<Turn> turns, Cell grid[][],int size) {

        for (Turn turn : turns) {
            if (!isValideCol(turn,grid)) {
                System.out.println("Error cannot put at col: " + turn.col);
                return;
            }
            int row = insertInGrid(turn,grid,size);
            if (checkWinner(turn, row,grid,size)) {
                printGrid(grid,size);
                printResultSet();
                System.out.println("Player " + turn.player + " wins");
                return;
            }

        }

        System.out.println("No one won");

    }
    
    boolean isValideCol(Turn turn,Cell grid[][]) {
        if (grid[1][turn.col].value.compareTo(CellType.E) != 0)// if not empty
            return false;
        return true;
    }
    
    private int insertInGrid(Turn turn,Cell grid[][],int size) {
        int i = 1;
        for (i = 1; i <= size; ++i) {
            if (grid[i][turn.col].value.compareTo(CellType.E) != 0)
                break;

        }

        grid[i - 1][turn.col] = new Cell(CellType.valueOf(turn.player));
        return i - 1;

    }
    
    
    private boolean checkWinner(Turn turn, int row,Cell grid[][],int size) {
        int count = 1;
        resultSets = new ArrayList<WinningSet>();
        resultSets.add(new WinningSet(row, turn.col));
        int i = row + 1;
        while (i <= size) {

            if (grid[i][turn.col].value.compareTo(CellType.valueOf(turn.player)) == 0) {
                resultSets.add(new WinningSet(i, turn.col));
                ++count;

            } else
                break;

            if (count == 4) {
                return true;
            }
            ++i;
        }

        resultSets = new ArrayList<WinningSet>();
        resultSets.add(new WinningSet(row, turn.col));
        count = 1;
        int j = turn.col + 1;
        while (j <= size) {

            if (grid[row][j].value.compareTo(CellType.valueOf(turn.player)) == 0) {
                resultSets = new ArrayList<WinningSet>();
                resultSets.add(new WinningSet(row, j));
                ++count;
            } else {
                break;
            }
            if (count == 4) {
                return true;
            }
            ++j;
        }

        count = 1;
        resultSets = new ArrayList<WinningSet>();
        resultSets.add(new WinningSet(row, turn.col));
        j = turn.col - 1;
        while (j > 0) {

            if (grid[row][j].value.compareTo(CellType.valueOf(turn.player)) == 0) {
                resultSets.add(new WinningSet(row, j));
                ++count;
            } else {
                break;
            }
            if (count == 4) {
                return true;
            }
            --j;
        }

        count = 1;
        resultSets = new ArrayList<WinningSet>();
        resultSets.add(new WinningSet(row, turn.col));
        // move left up
        int x = row - 1;
        int y = turn.col - 1;
        while (x > 0 && y > 0) {
            if (grid[x][y].value.compareTo(CellType.valueOf(turn.player)) == 0) {
                resultSets.add(new WinningSet(x, y));
                ++count;
            } else {
                break;
            }
            if (count == 4) {
                return true;
            }
            --x;
            --y;
        }

        // move right bottom
        x = row + 1;
        y = turn.col + 1;
        while (x <= size && y <= size) {
            if (grid[x][y].value.compareTo(CellType.valueOf(turn.player)) == 0) {
                resultSets.add(new WinningSet(x, y));
                ++count;
            } else {
                break;
            }
            if (count == 4) {
                return true;
            }
            ++x;
            ++y;
        }

        // check top right and bottom left diagnol
        count = 1;
        resultSets = new ArrayList<WinningSet>();
        resultSets.add(new WinningSet(row, turn.col));
        // move right up
        x = row - 1;
        y = turn.col + 1;
        while (x > 0 && y <=size) {
            if (grid[x][y].value.compareTo(CellType.valueOf(turn.player)) == 0) {
                resultSets.add(new WinningSet(x, y));
                ++count;
            } else {
                break;
            }
            if (count == 4) {
                return true;
            }
            --x;
            ++y;
        }

        // move left bottom
        x = row + 1;
        y = turn.col - 1;
        while (x <= size && y >0) {
            if (grid[x][y].value.compareTo(CellType.valueOf(turn.player)) == 0) {
                resultSets.add(new WinningSet(x, y));
                ++count;
            } else {
                break;
            }
            if (count == 4) {
                return true;
            }
            ++x;
            --y;
        }
        return false;
    }  
    
    
    void printGrid(Cell grid[][],int size) {

        for (int i = 1; i <= size; ++i) {
            for (int j = 1; j <= size; ++j) {
                System.out.print(grid[i][j].value + " ");
            }
            System.out.println();
        }

    }
    
    
    void printResultSet() {

        for (WinningSet resultSet : resultSets) {
            System.out.print("(" + resultSet.row + "," + resultSet.col + ") ");
        }
        System.out.println();
    }
}
