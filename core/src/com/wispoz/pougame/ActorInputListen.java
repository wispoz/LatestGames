package com.wispoz.pougame;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import java.lang.String;
import java.util.ArrayList;

/**
 * Created by wispoz on 20.04.15.
 */
public class ActorInputListen extends ActorGestureListener {
    private static ArrayList lines;
    private CompositeItem game;
    private static int gridRanes[][] = new int[5][2];
    float moveSpeed = 0.5f;
    Interpolation moveAction = Interpolation.linear;
    public ActorInputListen(CompositeItem cell) {
        lines = Grid.makeGrid();
        gridRanes = Grid.getRanges();
        game = cell;
    }

    @Override
    public void fling (InputEvent event, float velocityX, float velocityY, int button) {
        Float binded = game.getCustomVariables().getFloatVariable("bind");
        if(Math.abs(velocityX)>Math.abs(velocityY)){
            if(velocityX>0){
                this.move("right",binded);
            }else{
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

    }

    public int getLine(int bind) {
        Integer line = (Integer) lines.get(bind);
        return line;
    }

}

