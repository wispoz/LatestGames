package com.wispoz.pougame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.script.IScript;

import sun.security.ssl.Debug;

/**
 * Created by wispoz on 19.04.15.
 */
public class GameItem implements IScript {

    private CompositeItem game;
    public  float velocity = 0;

    @Override
    public void dispose() {

    }
    @Override
    public void init(CompositeItem gameItem) {
        game = gameItem;
       game.addListener(new ActorInputListen(gameItem));



    }

    @Override
    public void act(float delta) {
        game.setY(game.getY() + delta * velocity);
    }
}
