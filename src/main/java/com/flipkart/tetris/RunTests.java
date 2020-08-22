/*
 * Created on 27-Jun-2017 by amehra1
 *
 * Copyright (c) 2017 Walmart Inc. All Rights Reserved.
 */
package com.flipkart.tetris;


public class RunTests {
    
    public static void main(String[] args) {

        TestCases test = new TestCases();

        test.testHumanHuman();
        System.out.println("+++++++++++Test++++++++++++");
        test.testComputerComputer();
        System.out.println("+++++++++++Test++++++++++++");

        test.noValidMoveHumanHuman();
        System.out.println("+++++++++++Test++++++++++++");

        test.noValidMoveHumanComputer();
        System.out.println("+++++++++++Test++++++++++++");

        test.tieHumanHuman();
        System.out.println("+++++++++++Test++++++++++++");
        
        test.testDiagnol();

    }

}
