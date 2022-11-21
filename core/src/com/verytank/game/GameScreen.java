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

    Texture playerBadgeImage1;
    Rectangle playerBadgeBounds1;

    Texture playerBadgeImage2;
    Rectangle playerBadgeBounds2;

    Texture healthImage1;
    Rectangle healthBounds1;

    Texture healthImage2;
    Rectangle healthBounds2;

    Texture health2Image1;
    Rectangle health2Bounds1;

    Texture health2Image2;
    Rectangle health2Bounds2;

    Texture vsImage;
    Rectangle vsBounds;


    public GameScreen(final Very_Tank game){
        batch= new SpriteBatch();
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("game_background.png"));
        backgroundBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        groundImage=new Texture(Gdx.files.internal("ground.png"));
        groundBounds=new Rectangle(-10,-40,Gdx.graphics.getWidth()+40,Gdx.graphics.getHeight()+40);

        playerBadgeImage1=new Texture(Gdx.files.internal("playerBadge.png"));
        playerBadgeBounds1 =new Rectangle(350, Gdx.graphics.getHeight()-130, 130,130);

        playerBadgeImage2=new Texture(Gdx.files.internal("playerBadge.png"));
        playerBadgeBounds2 =new Rectangle(Gdx.graphics.getWidth()-350-130, Gdx.graphics.getHeight()-130, 130,130);

        healthImage1=new Texture(Gdx.files.internal("health.png"));
        healthBounds1=new Rectangle(350+100, Gdx.graphics.getHeight()-95, 400,61);

        healthImage2=new Texture(Gdx.files.internal("health.png"));
        healthBounds2=new Rectangle(Gdx.graphics.getWidth()-350-100-400-30+50, Gdx.graphics.getHeight()-95, 400,61);
    }


    public void render(float delta){
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.enableBlending();
        game.batch.begin();
        game.batch.draw(backgroundImage,backgroundBounds.x,backgroundBounds.y,backgroundBounds.width,backgroundBounds.height);
        game.batch.draw(groundImage,groundBounds.x,groundBounds.y,groundBounds.width,groundBounds.height);
        game.batch.draw(playerBadgeImage1,playerBadgeBounds1.x,playerBadgeBounds1.y,playerBadgeBounds1.width,playerBadgeBounds1.height);
        game.batch.draw(playerBadgeImage2,playerBadgeBounds2.x,playerBadgeBounds2.y,playerBadgeBounds2.width,playerBadgeBounds2.height);
        game.batch.draw(healthImage1,healthBounds1.x,healthBounds1.y,healthBounds1.width,healthBounds1.height);
        game.batch.draw(healthImage2,healthBounds2.x,healthBounds2.y,healthBounds2.width,healthBounds2.height);


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
