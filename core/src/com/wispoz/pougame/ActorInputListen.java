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

        if(Math.abs(velocityX)>Math.abs(velocityY)){
            if(velocityX>0){
               // directionListener.onRight();
                System.out.println("SWIPE: RIGHT");
            }else{
              //  directionListener.onLeft();
                System.out.println("SWIPE: LEFT");
            }
        }else{
            if(velocityY>0){
            //    directionListener.onDown();
            System.out.println("SWIPE: UP");

            }else{
            //    directionListener.onUp();
                System.out.println("SWIPE: DWON");
            }
        }
     }
}

