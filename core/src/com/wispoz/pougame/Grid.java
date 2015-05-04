package com.wispoz.pougame;

import java.util.ArrayList;

/**
 * Created by wispoz on 04.05.15.
 */
public class Grid {
    private static ArrayList lines;
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
}
