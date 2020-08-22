/*
 * Created on 27-Jun-2017 by amehra1
 *
 * Copyright (c) 2017 Walmart Inc. All Rights Reserved.
 */
package com.flipkart.tetris;

import java.util.ArrayList;

public interface GameType {
    
    public void play(ArrayList<Turn> turns, Cell grid[][],int size);

}
