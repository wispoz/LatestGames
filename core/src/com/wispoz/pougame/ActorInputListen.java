package com.wispoz.pougame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;

/**
 * Created by wispoz on 20.04.15.
 */
public class ActorInputListen extends ActorGestureListener {

    public ActorInputListen() {
      //  super(0.05f, 0.4f, 1.1f, 0.15f);
    }

    @Override
    public void fling (InputEvent event, float velocityX, float velocityY, int button) {

        System.out.println(" WEE SPWIPEEE swipe x:"+velocityX+"y:"+velocityY);
    }
}
