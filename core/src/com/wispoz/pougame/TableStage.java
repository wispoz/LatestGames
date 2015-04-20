package com.wispoz.pougame;

import com.badlogic.gdx.scenes.scene2d.ui.Table;


/**
 * Created by wispoz on 20.04.15.
 */
public class TableStage extends GameStage {

    public TableStage() {
        Table table = new Table();
        table.debug();      // Turn on all debug lines (table, cell, and widget).
        table.debugTable(); // Turn on only table lines.
        table.row();
        table.setFillParent(true);
        addActor(table);
    }
}
