/*
 * Created on 27-Jun-2017 by amehra1
 *
 * Copyright (c) 2017 Walmart Inc. All Rights Reserved.
 */
package com.flipkart.tetris;

import java.util.ArrayList;

public class TestCases {

    private final static String humanGameMode = "HUMAN-HUMAN";
    private final static String computerGameMode = "HUMAN-COMPUTER";

    public void testHumanHuman() {

        Game game = new Game(5);
        ArrayList<DefectiveCell> blockedCells = new ArrayList<DefectiveCell>();
        blockedCells.add(new DefectiveCell(3, 3));
        blockedCells.add(new DefectiveCell(4, 5));
        ArrayList<Turn> turns = new ArrayList<Turn>();
        turns.add(new Turn("A", 5));
        turns.add(new Turn("B", 4));
        turns.add(new Turn("A", 3));
        turns.add(new Turn("B", 4));
        turns.add(new Turn("A", 2));
        turns.add(new Turn("B", 4));
        turns.add(new Turn("A", 2));
        turns.add(new Turn("B", 4));
        game.runGame(humanGameMode, blockedCells, turns);

    }

    public void testComputerComputer() {

        Game game = new Game(5);
        ArrayList<DefectiveCell> blockedCells = new ArrayList<DefectiveCell>();
        blockedCells.add(new DefectiveCell(3, 3));
        blockedCells.add(new DefectiveCell(4, 5));
        ArrayList<Turn> turns = new ArrayList<Turn>();
        turns.add(new Turn("A", 5));
        turns.add(new Turn("A", 3));
        turns.add(new Turn("A", 2));
        turns.add(new Turn("A", 1));
        game.runGame(computerGameMode, blockedCells, turns);
    }

    public void noValidMoveHumanHuman() {

        Game game = new Game(5);
        ArrayList<DefectiveCell> blockedCells = new ArrayList<DefectiveCell>();
        blockedCells.add(new DefectiveCell(1, 1));
        blockedCells.add(new DefectiveCell(1, 2));
        blockedCells.add(new DefectiveCell(1, 3));
        blockedCells.add(new DefectiveCell(1, 4));
        blockedCells.add(new DefectiveCell(1, 5));
        ArrayList<Turn> turns = new ArrayList<Turn>();
        turns.add(new Turn("A", 5));
        turns.add(new Turn("B", 4));
        turns.add(new Turn("A", 3));
        turns.add(new Turn("B", 4));
        turns.add(new Turn("A", 2));
        turns.add(new Turn("B", 4));
        turns.add(new Turn("A", 2));
        turns.add(new Turn("B", 4));
        game.runGame(humanGameMode, blockedCells, turns);

    }

    public void noValidMoveHumanComputer() {

        Game game = new Game(5);
        ArrayList<DefectiveCell> blockedCells = new ArrayList<DefectiveCell>();
        blockedCells.add(new DefectiveCell(1, 1));
        blockedCells.add(new DefectiveCell(1, 2));
        blockedCells.add(new DefectiveCell(1, 3));
        blockedCells.add(new DefectiveCell(1, 4));
        blockedCells.add(new DefectiveCell(1, 5));
        ArrayList<Turn> turns = new ArrayList<Turn>();
        turns.add(new Turn("A", 5));
        turns.add(new Turn("A", 3));
        turns.add(new Turn("A", 2));
        turns.add(new Turn("A", 2));
        game.runGame(computerGameMode, blockedCells, turns);

    }

    public void tieHumanHuman() {

        Game game = new Game(5);
        ArrayList<DefectiveCell> blockedCells = new ArrayList<DefectiveCell>();
        blockedCells.add(new DefectiveCell(3, 2));
        blockedCells.add(new DefectiveCell(4, 4));
        blockedCells.add(new DefectiveCell(2, 5));
        ArrayList<Turn> turns = new ArrayList<Turn>();
        turns.add(new Turn("A", 1));
        turns.add(new Turn("B", 3));
        turns.add(new Turn("A", 1));
        turns.add(new Turn("B", 3));
        turns.add(new Turn("A", 1));
        turns.add(new Turn("B", 1));
        turns.add(new Turn("A", 3));
        turns.add(new Turn("A", 3));
        turns.add(new Turn("A", 3));
        game.runGame(humanGameMode, blockedCells, turns);

    }

    public void testDiagnol() {

        Game game = new Game(5);
        ArrayList<DefectiveCell> blockedCells = new ArrayList<DefectiveCell>();
        blockedCells.add(new DefectiveCell(3, 2));
        blockedCells.add(new DefectiveCell(4, 3));
        blockedCells.add(new DefectiveCell(5, 4));
        ArrayList<Turn> turns = new ArrayList<Turn>();
        turns.add(new Turn("A", 2));
        turns.add(new Turn("A", 3));
        turns.add(new Turn("A", 4));
        turns.add(new Turn("A", 5));
        game.runGame(humanGameMode, blockedCells, turns);

    }

}
