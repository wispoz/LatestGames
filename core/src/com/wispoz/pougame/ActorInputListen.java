package com.wispoz.pougame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import java.lang.String;

/**
 * Created by wispoz on 20.04.15.
 */
public class ActorInputListen extends ActorGestureListener {
    private CompositeItem game;
    public ActorInputListen(CompositeItem cell) {
      //  super(0.05f, 0.4f, 1.1f, 0.15f);
        game = cell;
    }
/*


6 7
10 11
 */
    @Override
    public void fling (InputEvent event, float velocityX, float velocityY, int button) {

        if(Math.abs(velocityX)>Math.abs(velocityY)){
            if(velocityX>0){
                CompositeItem scene = GameStage.getScene();
                CompositeItem moveTo = scene.getCompositeById("grid_button16");
                Float x = moveTo.getX();
                Float y = moveTo.getY();
                Float binded = game.getCustomVariables().getFloatVariable("bind");

                String bindedGrid = binded.toString();
                if(bindedGrid.equals("15.0")) {
                    game.getCustomVariables().setVariable("bind","16.0");
                    moveTo.getCustomVariables().setVariable("free","1");
                    game.addAction(Actions.moveTo( x, y, 0.7f, Interpolation.swingOut));
                }



            }else{
              //  directionListener.onLeft();
                System.out.println("SWIPE: LEFT");
                CompositeItem scene = GameStage.getScene();
                CompositeItem moveTo = scene.getCompositeById("grid_button15");
                Float x = moveTo.getX();
                Float y = moveTo.getY();
                String bindedGrid = game.getCustomVariables().getFloatVariable("bind").toString();
             //   game.addAction(Actions.moveTo( x, y, 0.7f, Interpolation.bounceOut));
                System.out.println("SWIPE: UP" + bindedGrid);
               if(bindedGrid.equals("16.0")) {
                  game.getCustomVariables().setVariable("bind","15.0");
                  moveTo.getCustomVariables().setVariable("free","1");
                  game.addAction(Actions.moveTo( x, y, 0.7f, Interpolation.bounceOut));
                }
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

