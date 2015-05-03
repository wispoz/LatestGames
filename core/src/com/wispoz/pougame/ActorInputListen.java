package com.wispoz.pougame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Array;
import com.uwsoft.editor.renderer.actor.CompositeItem;

import org.lwjgl.Sys;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wispoz on 20.04.15.
 */
public class ActorInputListen extends ActorGestureListener {
    private static ArrayList lines;
    private CompositeItem game;
    float moveSpeed = 0.5f;
    Interpolation moveAction = Interpolation.linear;
    public ActorInputListen(CompositeItem cell) {
      //  super(0.05f, 0.4f, 1.1f, 0.15f);

        lines = new ArrayList();
        lines.add(0,1);
        lines.add(1,1);
        lines.add(2,1);
        lines.add(3,1);
        lines.add(4,1);
        lines.add(5,2);
        lines.add(6,2);
        lines.add(7,2);
        lines.add(8,2);
        lines.add(9,3);
        lines.add(10,3);
        lines.add(11,3);
        lines.add(12,3);
        lines.add(13,4);
        lines.add(14,4);
        lines.add(15,4);
        lines.add(16,4);

        game = cell;
    }
/*


6 7
10 11
 */
    @Override
    public void fling (InputEvent event, float velocityX, float velocityY, int button) {
        Float binded = game.getCustomVariables().getFloatVariable("bind");
            this.getLine(3);
        if(Math.abs(velocityX)>Math.abs(velocityY)){
            if(velocityX>0){

                this.move("right",binded);

            }else{
              //  directionListener.onLeft();

                this.move("left", binded);
            }
        }else{
            if(velocityY>0){
                this.move("up", binded);

            }else{

                this.move("down", binded);
            }
        }
     }

    public void move(String direction, float bind) {



        if(direction.equals("right")) {

            if(bind == 4 && bind == 8 && bind == 12 && bind == 16 ) {

            }else{
                float nextBind = bind + 1;
                CompositeItem scene = GameStage.getScene();
                String replacedBind = Float.toString(nextBind).replace(".0", "");
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
                    moveTo.getCustomVariables().setVariable("free","1");
                    System.out.println("SWIPE: RIGHT");
                }
            }
        }
        if(direction.equals("left")){
            float nextBind = bind - 1;
            CompositeItem scene = GameStage.getScene();
            String replacedBind = Float.toString(nextBind).replace(".0", "");
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
                moveTo.getCustomVariables().setVariable("free", "1");
            }
        }
        if(direction.equals("up")) {
            float nextBind = bind - 4;
            if(bind == 1 && bind == 2 && bind == 3 && bind == 4 ) {

            }else {
                CompositeItem scene = GameStage.getScene();
                String replacedBind = Float.toString(nextBind).replace(".0", "");
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
                    moveTo.getCustomVariables().setVariable("free", "1");
                }

            }

        }
        if(direction.equals("down")) {
            float nextBind = bind + 4;
            if(bind == 13 && bind == 14 && bind == 15 && bind == 16 ) {

            }else {
                CompositeItem scene = GameStage.getScene();
                String replacedBind = Float.toString(nextBind).replace(".0", "");
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
                    moveTo.getCustomVariables().setVariable("free", "1");
                }

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

    public int getLine(int bind) {
        Integer line = (Integer) lines.get(bind);
        return line;
    }

}

