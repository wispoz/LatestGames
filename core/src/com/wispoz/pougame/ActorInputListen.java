package com.wispoz.pougame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.uwsoft.editor.renderer.actor.CompositeItem;

import org.lwjgl.Sys;

import java.lang.String;

/**
 * Created by wispoz on 20.04.15.
 */
public class ActorInputListen extends ActorGestureListener {
    private CompositeItem game;
    float moveSpeed = 0.09f;
    Interpolation moveAction = Interpolation.swingOut;
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
                System.out.println("SWIPE: RIGHT");
                Float binded = game.getCustomVariables().getFloatVariable("bind");
                this.move("right",binded);

            }else{
              //  directionListener.onLeft();
                System.out.println("SWIPE: LEFT");
                Float binded = game.getCustomVariables().getFloatVariable("bind");
                this.move("left", binded);
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

    public void move(String direction, float bind) {



        if(direction.equals("right")) {

            if(bind == 4 && bind == 8 && bind == 12 && bind == 16 ) {

            }else{
                float nextBind = bind + 1;
                CompositeItem scene = GameStage.getScene();
               String binded = Float.toString(nextBind);
                String replacedBind = binded.replace(".0", "");
                String oldBindId = Float.toString(bind).replace(".0","");
                CompositeItem moveTo = scene.getCompositeById("grid" + replacedBind);
                CompositeItem moveFrom = scene.getCompositeById("grid" + oldBindId);
                Float isFree = moveTo.getCustomVariables().getFloatVariable("free");
                if(isFree.toString().equals("1.0")) {

                }else {
                    Float x = moveTo.getX();
                    Float y = moveTo.getY();
                    game.addAction(Actions.moveTo(x, y, moveSpeed, moveAction));
                    game.getCustomVariables().setVariable("bind", Float.toString(nextBind));
                    moveFrom.getCustomVariables().setVariable("free","0");
                    System.out.println("SWIPE: RIGHT");
                }
            }
        }
        if(direction.equals("left")){
            float nextBind = bind - 1;
            CompositeItem scene = GameStage.getScene();
            String binded = Float.toString(nextBind);
            String replacedBind = binded.replace(".0", "");
            String oldBindId = Float.toString(bind).replace(".0","");
            CompositeItem moveTo = scene.getCompositeById("grid" + replacedBind);
            CompositeItem moveFrom = scene.getCompositeById("grid" + oldBindId);
            Float isFree = moveTo.getCustomVariables().getFloatVariable("free");
            if(isFree.toString().equals("1.0")) {

            }else {
                Float x = moveTo.getX();
                Float y = moveTo.getY();
                game.addAction(Actions.moveTo(x, y, moveSpeed, moveAction));
                game.getCustomVariables().setVariable("bind", Float.toString(nextBind));
                moveFrom.getCustomVariables().setVariable("free","0");
                System.out.println("SWIPE: RIGHT");
            }
        }
/*
        CompositeItem scene = GameStage.getScene();
        CompositeItem moveTo = scene.getCompositeById("grid16");
        Float x = moveTo.getX();
        Float y = moveTo.getY();
        Float binded = game.getCustomVariables().getFloatVariable("bind");

        String bindedGrid = binded.toString();
        if(bindedGrid.equals("15.0")) {
            game.getCustomVariables().setVariable("bind","16.0");
            moveTo.getCustomVariables().setVariable("free","1");
            game.addAction(Actions.moveTo( x, y, 0.7f, Interpolation.exp10));
        }
        */
    }
}

