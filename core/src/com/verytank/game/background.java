package com.verytank.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;

public class background implements Screen {
    private Very_Tank game;
    private Texture textu;
    private Rectangle textuRect;
    private Texture background;

    private Rectangle backgroundBounds;
    private Texture tank;
    private Rectangle tankRect;
    private Sprite sprite1;

    public background(Very_Tank game) {
        this.game = game;
        background = new Texture("tank-stars-banner.jpg");
        backgroundBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        tank = new Texture("t2.png");
        sprite1 = new Sprite(tank);
        sprite1.setAlpha(0.8f);
        tankRect = new Rectangle(600, 200, 600, 600);
    }

    @Override
    public void show() {


    }

    @Override
    public void render(float delta) {
        sprite1.setBounds(tankRect.x, tankRect.y, tankRect.width, tankRect.height);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        game.batch.enableBlending();
        game.batch.begin();
        game.batch.draw(background,backgroundBounds.x,backgroundBounds.y,backgroundBounds.width,backgroundBounds.height);
        game.batch.end();
//       game.batch.draw(sprite1, tankRect.x, tankRect.y, tankRect.width, tankRect.height);
//        sprite1.draw(game.batch);

        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        game.shapeRenderer.setColor(new Color(0.8f,0.8f,0.8f,0.5f));
//        game.shapeRenderer.rect(0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.shapeRenderer.setColor(new Color(0.1f,0.4f,0.6f,0.8f));
        game.shapeRenderer.rect(0,150,Gdx.graphics.getWidth(), 800);
//        game.shapeRenderer.rect(x2,y2,width2,height2);
        game.shapeRenderer.end();
        Gdx.gl.glDisable(GL20.GL_BLEND);

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
