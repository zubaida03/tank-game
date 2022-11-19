package com.verytank.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.awt.*;

public class LoadScreen extends ScreenAdapter {
    Very_Tank game;
    private SpriteBatch batch;

    private Texture load_sign;
    private Rectangle load_sign_rect;
    private Texture load_img;
    private Rectangle load_img_rect;
    private Pixmap pixmap;

    public LoadScreen(Very_Tank game) {
        this.game = game;
        batch = new SpriteBatch();
        load_img = new Texture(Gdx.files.internal("loader.png"));
        load_img_rect = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        load_sign = new Texture(Gdx.files.internal("load_line.png"));
        load_sign_rect = new Rectangle(710, 0, 500, 300);
    }
    @Override
    public void show(){

    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(load_img, load_img_rect.x, load_img_rect.y, load_img_rect.width, load_img_rect.height);
        game.batch.draw(load_sign, load_sign_rect.x, load_sign_rect.y, load_sign_rect.width, load_sign_rect.height);
        String text = "Loading...";
        game.font.setColor(Color.BLACK);
        game.font.getScaleY();
        game.batch.end();


    }
}

