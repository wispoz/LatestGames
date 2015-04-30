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
    private ResolutionManager rm;
    public GameStage() {
        //super(new StretchViewport(rm.stageWidth, rm.currentResolution.height));
        Gdx.input.setInputProcessor(this);
       // rm = new ResolutionManager();
      //  rm.initGameResources();

        // This will create SceneLoader instance and configure all things like default resource manager, physics e.t.c
       //initSceneLoader(rm);
     //   sceneLoader.setResolution(rm.currentResolution.name);
        resourceManager = new ResourceManager();
       resourceManager.setWorkingResolution("480x800");
        			// loading assets into memory


       resourceManager.initAllResources();
        // Creating Scene loader which can load an Overlap2D scene
        SceneLoader menuLoader = new SceneLoader(resourceManager);
        // loading MenuScene.dt from assets folder
        menuLoader.loadScene("MainScene");
        scene = menuLoader.sceneActor;
        // Adding root actor to stage
        addActor(menuLoader.sceneActor);

        gridsList.add(menuLoader.sceneActor.getCompositeById("grid1"));

        gridsList.add(menuLoader.sceneActor.getCompositeById("grid2"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid3"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid4"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid5"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid6"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid7"));

        gridsList.add(menuLoader.sceneActor.getCompositeById("grid8"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid9"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid10"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid11"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid12"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid13"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid14"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid15"));
        gridsList.add(menuLoader.sceneActor.getCompositeById("grid16"));

        buttonsList.add(menuLoader.sceneActor.getCompositeById("grid_button1"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("grid_button2"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("grid_button3"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("grid_button4"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("grid_button5"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("grid_button6"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("grid_button7"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("grid_button8"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("grid_button9"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("grid_button10"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("grid_button11"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("grid_button12"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("grid_button13"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("grid_button14"));
        buttonsList.add(menuLoader.sceneActor.getCompositeById("grid_button15"));
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
                button.addAction(Actions.moveTo(x, y, 1.0f, Interpolation.exp10));
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