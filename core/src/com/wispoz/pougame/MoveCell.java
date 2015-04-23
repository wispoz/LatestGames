package com.wispoz.pougame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.script.IScript;

/**
 * Created by wispoz on 23.04.15.
 */
public class MoveCell implements IScript {
    private CompositeItem game;
    public  float velocity = 0;

    @Override
    public void init(CompositeItem item) {
        game = item;
        game.addListener(new ClickListener() {
            public boolean touchDown(InputEvent event, float x, float y, int
                    pointer, int button) {
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer,int button) {
                // screen tap was done
                game.moveBy(0, 100);
        }
    });
    }

    @Override
    public void dispose() {

    }

    @Override
    public void act(float delta) {

    }
}
