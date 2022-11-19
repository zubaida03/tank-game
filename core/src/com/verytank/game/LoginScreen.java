package com.verytank.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import jdk.incubator.vector.VectorOperators;

import java.awt.*;

public class LoginScreen implements Screen {
    Very_Tank game;
    private TextInputListener newtext;
    private TextButton button;
    private Skin mSkin;
    private Stage mStage;
    private Texture blue;
    private Rectangle blueRect;
    private Texture background;
    private Sprite sprite;
    private Rectangle backgroundBounds;
    private Texture login;
    private Texture register;
    private Rectangle loginRect;
    private Rectangle registerRect;
    public LoginScreen(Very_Tank game) {
        this.game = game;
        background = new Texture("bg.png");
        backgroundBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        blue = new Texture("Color-blue.jpg");
        blueRect = new Rectangle(Gdx.graphics.getWidth()-700, 0, 800, Gdx.graphics.getHeight());
        sprite = new Sprite(blue);
        sprite.setBounds(blueRect.x, blueRect.y, blueRect.width, blueRect.height);
        sprite.setColor(0,0,0.3f,0.6f);
        login = new Texture("login.png");
        loginRect = new Rectangle(Gdx.graphics.getWidth()-600, Gdx.graphics.getHeight()-400, 400, 150);
        register = new Texture("register.png");
        registerRect = new Rectangle(Gdx.graphics.getWidth()-600, Gdx.graphics.getHeight()-800, 400, 150);


    }



    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.enableBlending();
        game.batch.begin();
        game.batch.draw(background,backgroundBounds.x,backgroundBounds.y,backgroundBounds.width,backgroundBounds.height);

        sprite.draw(game.batch);
        game.batch.draw(login,loginRect.x,loginRect.y,loginRect.width,loginRect.height);
        game.batch.draw(register,registerRect.x,registerRect.y,registerRect.width,registerRect.height);
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
