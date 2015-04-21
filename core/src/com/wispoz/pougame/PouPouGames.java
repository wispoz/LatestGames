package com.wispoz.pougame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class PouPouGames extends ApplicationAdapter {
    Stage stage;

    public void create () {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);


        Table table = new Table();

       // table.setSize(200, 200);
      //  table.setPosition(190, 142);
        // table.align(Align.right | Align.bottom);
        int actorWidth = Gdx.graphics.getWidth() / 8;
        int actorHeight = Gdx.graphics.getHeight() /  8;
        Actor[] actors = new Actor[8 * 8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                Actor actor = actors[(i * 8) + j];
                table.add(actor).width(actorWidth).height(actorHeight);
            }
            table.row();
        }
        table.debug();
        stage.addActor(table);

    }

    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void resize (int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    public void dispose () {
        stage.dispose();
    }
}