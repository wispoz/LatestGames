package com.wispoz.pougame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.uwsoft.editor.renderer.Overlap2DStage;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.actor.IBaseItem;
import com.uwsoft.editor.renderer.resources.ResourceManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sun.security.util.Debug;


/**
 * Created by wispoz on 17.04.15.
 */
public class GameStage extends Overlap2DStage {
    private ResourceManager resourceManager;
    private static CompositeItem scene;
    List<CompositeItem> gridsList=new ArrayList<CompositeItem>();
    List<CompositeItem> buttonsList=new ArrayList<CompositeItem>();
    public GameStage() {
        //super(new StretchViewport(rm.stageWidth, rm.currentResolution.height));
        Gdx.input.setInputProcessor(this);

        // This will create SceneLoader instance and configure all things like default resource manager, physics e.t.c
       //initSceneLoader(rm);
     //   sceneLoader.setResolution(rm.currentResolution.name);
        resourceManager = new ResourceManager();

        			// loading assets into memory


       resourceManager.initAllResources();
        // Creating Scene loader which can load an Overlap2D scene
        SceneLoader menuLoader = new SceneLoader(resourceManager);
        // loading MenuScene.dt from assets folder
        menuLoader.loadScene("MainScene");
        scene = menuLoader.sceneActor;
        // Adding root actor to stage
        addActor(menuLoader.sceneActor);

        gridsList.add(menuLoader.sceneActor.getCompositeById("grid_button1"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid_button2"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid_button3"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid_button4"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid_button5"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid_button6"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid_button7"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid_button8"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid_button9"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid_button10"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid_button11"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid_button12"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid_button13"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid_button14"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid_button15"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid_button16"));

        buttonsList.add(menuLoader.sceneActor.getCompositeById("button1"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("button2"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("button3"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("button4"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("button5"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("button6"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("button7"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("button8"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("button9"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("button10"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("button11"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("button12"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("button13"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("button14"));

        buttonsList.add(menuLoader.sceneActor.getCompositeById("button15"));
        for(CompositeItem item: buttonsList) {
                item.addScript(new GameItem());
        }
        Collections.shuffle(buttonsList);
        int index = 0;
        for(CompositeItem item: gridsList) {
            float x = item.getX();
            float y = item.getY();
            if(index != 15) {
                CompositeItem button = buttonsList.get(index);
                String id = item.getCustomVariables().getFloatVariable("id").toString();
                button.getCustomVariables().setVariable("bind",id);
                button.addAction(Actions.moveTo(x, y, 1.0f, Interpolation.bounceOut));
            }
            index++;
        }
        /*
        for(IBaseItem item: menuLoader.getRoot().getItems()) {
           if( item.isComposite()){
           //     Debug.println("TEST","TESTING");
            ((CompositeItem)item).addScript(new GameItem());
            }

        }
*/

    }

    public  static CompositeItem getScene() {
        return scene;
    }

    public void act(float delta) {
        super.act(delta);

    }

    public void restart() {

    }
}