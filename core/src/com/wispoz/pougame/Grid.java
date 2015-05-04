package com.wispoz.pougame;

import java.util.ArrayList;

/**
 * Created by wispoz on 04.05.15.
 */
public class Grid {
    private static ArrayList lines;
    private static ArrayList gridList;

    private static int gridRanes[][] = new int[5][2];
    public Grid(){

    }
    public static ArrayList makeGrid() {
        lines = new ArrayList();
        lines.add(0,1);
        lines.add(1,1);
        lines.add(2,1);
        lines.add(3,1);
        lines.add(4,1);
        lines.add(5,2);
        lines.add(6,2);
        lines.add(7,2);
        lines.add(8,2);
        lines.add(9,3);
        lines.add(10,3);
        lines.add(11,3);
        lines.add(12,3);
        lines.add(13,4);
        lines.add(14,4);
        lines.add(15,4);
        lines.add(16,4);
        return lines;
    }
    public static int[][] getRanges (){
        gridRanes[0][0] = 1;// not use
        gridRanes[0][1] = 1;// not use
            gridRanes[1][0] = 1;
            gridRanes[1][1] = 4;
            gridRanes[2][0] = 5;
            gridRanes[2][1] = 8;
            gridRanes[3][0] = 9;
            gridRanes[3][1] = 12;
            gridRanes[4][0] = 13;
            gridRanes[4][1] = 16;
        return gridRanes;
    }
}
