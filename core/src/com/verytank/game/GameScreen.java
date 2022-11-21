package com.verytank.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class GameScreen implements Screen {
    final Very_Tank game;
    SpriteBatch batch;
    Rectangle backgroundBounds;

    Texture backgroundImage;

    Texture groundImage;
    Rectangle groundBounds;
    public GameScreen(final Very_Tank game){
        batch= new SpriteBatch();
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("game_background.png"));
        backgroundBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        groundImage=new Texture(Gdx.files.internal("ground.png"));
        //groundBounds=new Rectangle(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }


    public void render(float delta){
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.enableBlending();
        game.batch.begin();
        game.batch.draw(backgroundImage,backgroundBounds.x,backgroundBounds.y,backgroundBounds.width,backgroundBounds.height);
        game.batch.draw(groundImage,-10,-40,Gdx.graphics.getWidth()+40,Gdx.graphics.getHeight()+40);

        //sprite.draw(game.batch);
        game.batch.end();
    }
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

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
