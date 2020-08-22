/*
 * Created on 27-Jun-2017 by amehra1
 *
 * Copyright (c) 2017 Walmart Inc. All Rights Reserved.
 */
package com.flipkart.tetris;

import java.util.ArrayList;

public class CompMode implements GameType{
    ArrayList<WinningSet> resultSets;
    public CompMode(){
        resultSets = new ArrayList<WinningSet>();
    }

    public void play(ArrayList<Turn> turns, Cell[][] grid, int size) {

        for (Turn turn : turns) {
            if (!isValideCol(turn,grid,size)) {
                System.out.println("Error cannot put at col: " + turn.col);
                return;
            }
            int row = insertInGrid(turn,grid,size);// insert into grid
            if (validateWinning(turn, row,grid,size)) {// check if player won
                printGrid(grid,size);
                printResultSet();
                System.out.println("Player " + turn.player + " wins");
                return;
            }
            
            //computer turn
            if (!isAnyValidMoveLeft(grid,size))
                break;
            else {

                int computerCol = getValidMove(grid,size);
                Turn computerTurn = new Turn("B", computerCol);
                int computerRow = insertInGrid(computerTurn,grid,size);
                if (validateWinning(computerTurn, computerRow,grid,size)) {
                    printGrid(grid,size);
                    printResultSet();
                    System.out.println("Computer  wins");
                    return;
                }
            }
        }

        // computer gets multiple turn to win from A if all A turns are over
//        while (true) {
//
//            if (!isAnyValidMoveLeft(grid,size))
//                break;
//            int computerCol = getValidMove(grid,size);
//            Turn computerTurn = new Turn("B", computerCol);
//            int computerRow = insertInGrid(computerTurn,grid,size);
//            if (validateWinning(computerTurn, computerRow,grid,size)) {
//                printGrid(grid,size);
//                printResultSet();
//                System.out.println("Computer wins");
//                return;
//            }
//
//        }
        printGrid(grid, size);
        
        System.out.println("No one  won");

    }
    
    private boolean validateWinning(Turn turn, int row,Cell[][] grid,int size) {


        // check in that column move down
        int consecutiveOccur = 1;
        resultSets = new ArrayList<WinningSet>();
        resultSets.add(new WinningSet(row, turn.col));
        int i = row + 1;
        while (i <= size) {

            if (grid[i][turn.col].value.compareTo(CellType.valueOf(turn.player)) == 0) {
                resultSets.add(new WinningSet(i, turn.col));
                ++consecutiveOccur;

            } else
                break;

            if (consecutiveOccur == 4) {
                return true;
            }
            ++i;
        }

        // check in that row move rightt direction
        resultSets = new ArrayList<WinningSet>();
        resultSets.add(new WinningSet(row, turn.col));
        consecutiveOccur = 1;
        int j = turn.col + 1;
        while (j <= size) {

            if (grid[row][j].value.compareTo(CellType.valueOf(turn.player)) == 0) {
                resultSets = new ArrayList<WinningSet>();
                resultSets.add(new WinningSet(row, j));
                ++consecutiveOccur;
            } else {
                break;
            }
            if (consecutiveOccur == 4) {
                return true;
            }
            ++j;
        }

        // check in that riw and move left
        consecutiveOccur = 1;
        resultSets = new ArrayList<WinningSet>();
        resultSets.add(new WinningSet(row, turn.col));
        j = turn.col - 1;
        while (j > 0) {

            if (grid[row][j].value.compareTo(CellType.valueOf(turn.player)) == 0) {
                resultSets.add(new WinningSet(row, j));
                ++consecutiveOccur;
            } else {
                break;
            }
            if (consecutiveOccur == 4) {
                return true;
            }
            --j;
        }

        // check for diagnols
        // left up and right down diagnol
        consecutiveOccur = 1;
        resultSets = new ArrayList<WinningSet>();
        resultSets.add(new WinningSet(row, turn.col));
        // move left up
        int x = row - 1;
        int y = turn.col - 1;
        while (x > 0 && y > 0) {
            if (grid[x][y].value.compareTo(CellType.valueOf(turn.player)) == 0) {
                resultSets.add(new WinningSet(x, y));
                ++consecutiveOccur;
            } else {
                break;
            }
            if (consecutiveOccur == 4) {
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
                ++consecutiveOccur;
            } else {
                break;
            }
            if (consecutiveOccur == 4) {
                return true;
            }
            ++x;
            ++y;
        }

        // check top right and bottom left diagnol
        consecutiveOccur = 1;
        resultSets = new ArrayList<WinningSet>();
        resultSets.add(new WinningSet(row, turn.col));
        // move right up
        x = row - 1;
        y = turn.col + 1;
        while (x > 0 && y <=size) {
            if (grid[x][y].value.compareTo(CellType.valueOf(turn.player)) == 0) {
                resultSets.add(new WinningSet(x, y));
                ++consecutiveOccur;
            } else {
                break;
            }
            if (consecutiveOccur == 4) {
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
                ++consecutiveOccur;
            } else {
                break;
            }
            if (consecutiveOccur == 4) {
                return true;
            }
            ++x;
            --y;
        }
        return false;
    
    }

    private int insertInGrid(Turn turn,Cell[][] grid,int size) {
        // search for last empty cell
        int i = 1;
        for (i = 1; i <= size; ++i) {
            if (grid[i][turn.col].value.compareTo(CellType.E) != 0)
                break;

        }

        grid[i - 1][turn.col] = new Cell(CellType.valueOf(turn.player));
        return i - 1;

    }

    boolean isValideCol(Turn turn,Cell grid[][],int size) {
        
        if (grid[1][turn.col].value.compareTo(CellType.E) != 0)// if not empty
            return false;
        return true;
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
    
    private boolean isAnyValidMoveLeft(Cell[][] grid,int size) {
        // check top row for all columns
        for (int i = 1; i <= size; ++i) {
            if (grid[1][i].value.equals(CellType.E))
                return true;
        }
        return false;
    }
    
    private int getValidMove(Cell[][] grid,int size) {
        for (int i = 1; i <= size; ++i) {
            if (grid[1][i].value.equals(CellType.E))
                return i;
        }

        return -1;
    }
    
}
