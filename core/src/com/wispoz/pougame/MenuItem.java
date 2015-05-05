package com.wispoz.pougame;

import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.script.IScript;

/**
 * Created by wispoz on 05.05.15.
 */
public class MenuItem implements IScript {

    private CompositeItem game;
    public  float velocity = 0;

    @Override
    public void dispose() {

    }
    @Override
    public void init(CompositeItem gameItem) {
        game = gameItem;
        game.addListener(new MenuActionListener(gameItem));



    }

    @Override
    public void act(float delta) {
        game.setY(game.getY() + delta * velocity);
    }
}

