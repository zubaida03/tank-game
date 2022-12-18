package com.verytank.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class currgame implements Screen {
    private GameScreen background;
    private final Very_Tank game;
    private tank player1_tank;
    private tank player2_tank;
    private Texture tank1;
    private Texture tank2;
    private Rectangle tank1Rect;
    private Rectangle tank2Rect;
    public currgame(Very_Tank game){
        this.game = game;
        background = new GameScreen(game);
        tank1 = new Texture("tank1_img.png");
        tank2 = new Texture("tan2_img_inverted.png");
        tank1Rect = new Rectangle(100, 322, 300, 200);
        tank2Rect = new Rectangle(1000, 318, 300, 150);
        player1_tank = new tank(100, 100, 100, 100, 100, 100, 100,tank1Rect, "player1");
        player2_tank = new tank(1000, 100, 100, 100, 100, 100, 100,tank2Rect,  "player2");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        background.render(delta);
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && tank1Rect.x>0) tank1Rect.x -= 200*Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)&& tank1Rect.x<Gdx.graphics.getWidth()-300) tank1Rect.x += 200*Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.A) && tank2Rect.x>0) tank2Rect.x -= 200*Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.D)&& tank2Rect.x<Gdx.graphics.getWidth()-300) tank2Rect.x += 200*Gdx.graphics.getDeltaTime();

        game.batch.begin();
        game.batch.draw(tank1,tank1Rect.x,tank1Rect.y,tank1Rect.width,tank1Rect.height);
        game.batch.draw(tank2,tank2Rect.x,tank2Rect.y,tank2Rect.width,tank2Rect.height);
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
