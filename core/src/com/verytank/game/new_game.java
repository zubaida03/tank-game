package com.verytank.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;

public class new_game implements Screen {
    private Very_Tank game;
    private tankOne tank1;
    private tankTwo tank2;
    private tankThree tank3;
    private Texture background;
    private Rectangle backgroundBounds;
    private Sprite sprite1;
    float elapsedTime;
    private Texture name;
    private Rectangle nameRect;
    private Texture selectanks;
    private Rectangle selectanksRect;


    public new_game(Very_Tank game){
        this.game=game;
        this.game = game;
        background = new Texture("tank-stars-banner.jpg");
        backgroundBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        name = new Texture("name.png");
        nameRect = new Rectangle(800, 800, 200, 80);
        selectanks = new Texture("selectanks.png");
        selectanksRect = new Rectangle(800, 450, 200, 80);

//        tank = new Texture("t2.png");


    }

    @Override
    public void show() {



    }

    @Override
    public void render(float delta) {
//        background creation
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.enableBlending();
        game.batch.begin();
        game.batch.draw(background,backgroundBounds.x,backgroundBounds.y,backgroundBounds.width,backgroundBounds.height);
        game.batch.end();
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        game.shapeRenderer.setColor(new Color(0.1f,0.4f,0.6f,0.9f));
        game.shapeRenderer.rect(0,150,Gdx.graphics.getWidth(), 800);
        game.shapeRenderer.end();
        Gdx.gl.glDisable(GL20.GL_BLEND);
//        background done

//        tanks
        elapsedTime += Gdx.graphics.getDeltaTime();
        tankThree tank3 = new tankThree();
        tank3.getAnimation();
        tankTwo tank2 = new tankTwo();
        tank2.getAnimation();
        tankOne tank1 = new tankOne();
        tank1.getAnimation();
        game.batch.begin();
        game.batch.draw(name,nameRect.x,nameRect.y,nameRect.width,nameRect.height);
        game.batch.draw(selectanks,selectanksRect.x,selectanksRect.y,selectanksRect.width,selectanksRect.height);
        game.batch.draw((TextureRegion) tank3.getAnimation().getKeyFrame(elapsedTime, true), 400, 200);
        game.batch.draw((TextureRegion) tank2.getAnimation().getKeyFrame(elapsedTime, true), 1200, 200);
        game.batch.draw((TextureRegion) tank1.getAnimation().getKeyFrame(elapsedTime, true), 800, 200);
        game.batch.end();


    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
