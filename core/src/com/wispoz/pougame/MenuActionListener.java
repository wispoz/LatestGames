package com.wispoz.pougame;

import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.uwsoft.editor.renderer.actor.CompositeItem;

/**
 * Created by wispoz on 05.05.15.
 */
public class MenuActionListener extends ActorGestureListener {
    private CompositeItem game;
    public MenuActionListener(CompositeItem cell) {
        game = cell;
    }
}
