package com.wispoz.pougame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.uwsoft.editor.renderer.Overlap2DStage;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.actor.IBaseItem;
import com.uwsoft.editor.renderer.resources.ResourceManager;

import sun.security.util.Debug;


/**
 * Created by wispoz on 17.04.15.
 */
public class GameStage extends Overlap2DStage {
    private ResourceManager resourceManager;
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

        // Adding root actor to stage
        addActor(menuLoader.sceneActor);
        for(IBaseItem item: menuLoader.getRoot().getItems()) {
           if( item.isComposite()){
           //     Debug.println("TEST","TESTING");
            ((CompositeItem)item).addScript(new GameItem());
            }


        }

    }



    public void act(float delta) {
        super.act(delta);

    }

    public void restart() {

    }
}