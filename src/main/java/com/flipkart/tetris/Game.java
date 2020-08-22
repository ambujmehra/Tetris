/*
 * Created on 27-Jun-2017 by amehra1
 *
 * Copyright (c) 2017 Walmart Inc. All Rights Reserved.
 */
package com.flipkart.tetris;

import java.util.ArrayList;

public class Game {

    private int size;
    private GameType game;
    private Board board;

    public Game(int size) {
        this.size = size;
        board = new Board.Builder().setSize(size).setGrid().setwinningSet().build();

    }

    public void runGame(String gameType, ArrayList<DefectiveCell> blockedCells,
            ArrayList<Turn> turns) {

        Cell[][] grid = board.getGrid();
        for (DefectiveCell cells : blockedCells) {
            grid[cells.row][cells.col] = new Cell(CellType.D);
        }
        if (gameType.equals("HUMAN-HUMAN")) {
            game = new HumanMode();
            game.play(turns, board.getGrid(), size);
        } else if (gameType.equals("HUMAN-COMPUTER")) {
            game = new CompMode();
            game.play(turns, board.getGrid(), size);
        }

    }

}
