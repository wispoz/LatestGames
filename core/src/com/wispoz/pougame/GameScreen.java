package com.wispoz.pougame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

/**
 * Created by wispoz on 21.04.15.
 */
public class GameScreen extends Stage {

    public GameScreen () {
        Table rootTable = new Table().debug();
        rootTable.setFillParent(true);

        Table table = new Table();
        //table.setFillParent(true);

        int actorWidth = Gdx.graphics.getWidth() / 4;
        int actorHeight = Gdx.graphics.getHeight() /  4;
        Actor[] actors = new Actor[4 * 4];
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                Actor actor = actors[(i * 4) + j];
                table.add(actor).width(actorWidth).height(actorHeight);
            }
            table.row();
        }
        table.debug();
        table.debugTable();
        rootTable.add(table);
        addActor(rootTable);
    }

    public void act(float delta) {
        super.act(delta);

    }
}