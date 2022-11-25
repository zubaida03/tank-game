package com.verytank.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import jdk.incubator.vector.VectorOperators;

import java.awt.*;

public class LoginScreen implements Screen {
    Very_Tank game;
//    private TextInputListener newtext;
//    private TextButton button;
//    private Skin mSkin;
//    private Stage mStage;
//    private Texture blue;
//    private Rectangle blueRect;
//    private Sprite sprite;
    private Texture background;

    private Rectangle backgroundBounds;
//    private Texture tank;
//    private Rectangle tankRect;
//    private Texture login;
//    private Texture register;
//    private Rectangle loginRect;
//    private Rectangle registerRect;

//    private  Sprite sprite1;

//    private ShapeRenderer shapeRenderer;
    private int x =Gdx.graphics.getWidth()/2 ;
    private int y = 150 ;
    private int width = 0;
    private int height = 800;
    private int x2 = Gdx.graphics.getWidth()/2;
    private int y2 = 150; ;
    private int width2 = 0; ;
    private int height2 = 800;
    public LoginScreen(Very_Tank game) {
        this.game = game;
//        login = new Texture("login.png");
//        loginRect = new Rectangle(Gdx.graphics.getWidth()-600, Gdx.graphics.getHeight()-400, 400, 150);
//        register = new Texture("register.png");
//        registerRect = new Rectangle(Gdx.graphics.getWidth()-600, Gdx.graphics.getHeight()-800, 400, 150);
        background = new Texture("tank-stars-banner.jpg");
        backgroundBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        tank = new Texture("t2.png");
//        sprite1 = new Sprite(tank);
//        sprite1.setAlpha(0.8f);
//        tankRect = new Rectangle(600, 200, 600, 600);
//        sprite1.setBounds(tankRect.x, tankRect.y, tankRect.width, tankRect.height);


    }



    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        width-=7;
        width2+=7;
//
        if (width2>Gdx.graphics.getWidth()/2){
            width2-=7;
            game.setScreen(new actuallogin((game)));
        }
        if (Math.abs(height)>Gdx.graphics.getWidth()/2){
            width+=7;
            game.setScreen(new actuallogin((game)));
        }

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        game.batch.enableBlending();
        game.batch.begin();
        game.batch.draw(background,backgroundBounds.x,backgroundBounds.y,backgroundBounds.width,backgroundBounds.height);

//        sprite1.draw(game.batch);
//        game.batch.draw(login,loginRect.x,loginRect.y,loginRect.width,loginRect.height);
//        game.batch.draw(register,registerRect.x,registerRect.y,registerRect.width,registerRect.height);
        game.batch.end();
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        game.shapeRenderer.setColor(new Color(0.1f,0.4f,0.6f,0.8f));
        game.shapeRenderer.rect(x,y,width,height);
        game.shapeRenderer.rect(x2,y2,width2,height2);
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
//add logo to actual login screen


//
