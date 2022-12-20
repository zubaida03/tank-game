package com.verytank.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.*;

public class actuallogin implements Screen {
    private Very_Tank game;
//    private Texture textu;
//    private Rectangle textuRect;
    private Texture background;

    private Rectangle backgroundBounds;
    private Texture tank;
    private Rectangle tankRect;
    private  Sprite sprite1;
    private Texture logo;
    private Rectangle logo_rect;
    private Texture login;
    private Texture sign;
    private Rectangle loginRect;
    private Rectangle signRect;
    private Stage stage;
    private TextureRegion savedgame;
    private TextureRegion newgame;
    private TextureRegionDrawable newgamedrawable;
    private TextureRegionDrawable saveddrawble;
    private ImageButton savebutton;
    private ImageButton newbutton;
    public actuallogin(Very_Tank game) {
        this.game = game;
        background = new Texture("tank-stars-banner.jpg");
        backgroundBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        tank = new Texture("t2.png");
        sprite1 = new Sprite(tank);
        sprite1.setAlpha(0.8f);
        tankRect = new Rectangle((int)(Gdx.graphics.getWidth()*0.3125), 200, 600, 600);
        logo = new Texture("download-removebg-preview.png");
        logo_rect = new Rectangle((int)(Gdx.graphics.getWidth()*0.3385), 600, 600, 600);
        login = new Texture("register.png");
        loginRect = new Rectangle((int)(Gdx.graphics.getWidth()*0.4166), Gdx.graphics.getHeight()-500, 300, 100);
        sign = new Texture("signin.png");
        signRect = new Rectangle((int)(Gdx.graphics.getWidth()*0.4166), Gdx.graphics.getHeight()-800, 300, 100);
        savedgame = new TextureRegion(login);
        saveddrawble = new TextureRegionDrawable(savedgame);
        newgame = new TextureRegion(sign);
        newgamedrawable = new TextureRegionDrawable(newgame);


//        textu = new Texture("texture.jpg");
//        textuRect = new Rectangle(0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

    }

    @Override
    public void show() {
        newbutton = new ImageButton(newgamedrawable);
        savebutton = new ImageButton(saveddrawble);
        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(savebutton); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stage);
        savebutton.setPosition(800, Gdx.graphics.getHeight()-800);
        savebutton.setSize(300, 100);
        savebutton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new saved_Games(game));
            }
        });
        stage.addActor(newbutton);
        newbutton.setPosition(800, Gdx.graphics.getHeight()-500);
        newbutton.setSize(300, 100);
        newbutton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new new_game_tank_confirm(game));
            }
        });

    }

    @Override
    public void render(float delta) {

        sprite1.setBounds(tankRect.x, tankRect.y, tankRect.width, tankRect.height);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//
        game.batch.enableBlending();
        game.batch.begin();
        game.batch.draw(background,backgroundBounds.x,backgroundBounds.y,backgroundBounds.width,backgroundBounds.height);
        game.batch.end();
//        game.batch.draw(sprite1, tankRect.x, tankRect.y, tankRect.width, tankRect.height);

//        sprite1.draw(game.batch);
//
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
        game.batch.begin();
        game.batch.draw(logo,logo_rect.x,logo_rect.y,logo_rect.width,logo_rect.height);
//        game.batch.draw(login,loginRect.x,loginRect.y,loginRect.width,loginRect.height);
//        game.batch.draw(sign,signRect.x,signRect.y,signRect.width,signRect.height);
        game.batch.end();
        stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
        stage.draw();

//        return 0;
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
        game.dispose();
//        textu.dispose();
//        textuRect.dispose();
        background.dispose();
        tank.dispose();
        sprite1.getTexture().dispose();
        logo.dispose();
        login.dispose();
        sign.dispose();
        stage.dispose();
        savedgame.getTexture().dispose();
        newgame.getTexture().dispose();
        newgamedrawable.getRegion().getTexture().dispose();
        saveddrawble.getRegion().getTexture().dispose();
        savebutton.remove();
        newbutton.remove();


    }
}

