package com.wispoz.pougame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.uwsoft.editor.renderer.actor.CompositeItem;

/**
 * Created by wispoz on 20.04.15.
 */
public class ActorInputListen extends ActorGestureListener {
    private CompositeItem game;
    public ActorInputListen(CompositeItem cell) {
      //  super(0.05f, 0.4f, 1.1f, 0.15f);
        game = cell;
    }

    @Override
    public void fling (InputEvent event, float velocityX, float velocityY, int button) {

        if(Math.abs(velocityX)>Math.abs(velocityY)){
            if(velocityX>0){
               // directionListener.onRight();
                System.out.println("SWIPE: RIGHT");
                CompositeItem scene = GameStage.getScene();
                CompositeItem moveTo = scene.getCompositeById("grid_button1");
                Float x = moveTo.getX();
                Float y = moveTo.getY();
                System.out.println("SWIPE: RIGHT");



                game.addAction(Actions.moveTo( x, y, 0.7f, Interpolation.bounceOut));
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

