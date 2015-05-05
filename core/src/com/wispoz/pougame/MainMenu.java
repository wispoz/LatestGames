package com.wispoz.pougame;

import com.badlogic.gdx.Gdx;
import com.uwsoft.editor.renderer.Overlap2DStage;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.actor.CompositeItem;
import com.uwsoft.editor.renderer.resources.ResourceManager;

/**
 * Created by wispoz on 05.05.15.
 */
public class MainMenu extends Overlap2DStage {
    private ResourceManager resourceManager;
    private static CompositeItem scene;
    private ResolutionManager rm;

    public MainMenu() {
        Gdx.input.setInputProcessor(this);
        rm = new ResolutionManager();
        rm.initGameResources();
        resourceManager = new ResourceManager();
        resourceManager.initAllResources();
        SceneLoader menuLoader = new SceneLoader(rm.currentResolution.name);
        menuLoader.loadScene("MainMenu");
        scene = menuLoader.sceneActor;
        // Adding root actor to stage
        addActor(menuLoader.sceneActor);
        CompositeItem playButton = menuLoader.sceneActor.getCompositeById("playButton");
        CompositeItem optionsButton = menuLoader.sceneActor.getCompositeById("optionsButton");
    }
    public void act(float delta) {
        super.act(delta);

    }
}
