package com.verytank.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.awt.*;

public class tank3_details implements Screen {
//    private Texture textu;
//    private Rectangle textuRect;
    private Texture background;
    private Rectangle backgroundBounds;
    private Texture tank;
    private Rectangle tankRect;
    private Sprite sprite1;
    private Very_Tank game;
    //    background
//    tank animation
    private float elapsedTime;
    private tankOne tank1;
    //    tank animation
//    tank details
    private Texture details;
    private Rectangle detailsRect;
    private TextureRegion confirm;
    private TextureRegionDrawable confirm_drawable;
    private ImageButton confirm_button;
    private Stage stage;
    public tank3_details (Very_Tank game) {
        this.game = game;
        background = new Texture("tank-stars-banner.jpg");
        backgroundBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        tank = new Texture("t2.png");
        sprite1 = new Sprite(tank);
        sprite1.setAlpha(0.8f);
        tankRect = new Rectangle(600, 200, 600, 600);
        details = new Texture("tank3_details.png");
        detailsRect = new Rectangle(900, 200, 900, 700);
        confirm = new TextureRegion(new Texture("confirm.png"));
        confirm_drawable = new TextureRegionDrawable(confirm);
    }

    @Override
    public void show() {
        stage = new Stage();
        confirm_button = new ImageButton(confirm_drawable);
        confirm_button.setSize(200, 100);
        confirm_button.setPosition(300, 300);
        stage.addActor(confirm_button);
        Gdx.input.setInputProcessor(stage);
        confirm_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new new_game(game));
            }
        });

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
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        game.shapeRenderer.setColor(new Color(0.1f,0.4f,0.6f,0.8f));
        game.shapeRenderer.rect(0,150,Gdx.graphics.getWidth(), 800);
//        game.shapeRenderer.setColor(new Color(0.2f,0.2f,0.5f,0.9f));
//        game.shapeRenderer.rect(800,200,1000, 700);
        game.shapeRenderer.end();
        Gdx.gl.glDisable(GL20.GL_BLEND);
//          tank animation
        game.batch.begin();
        elapsedTime += Gdx.graphics.getDeltaTime();
        tankOne tank1 = new tankOne();
        tank1.getAnimation();
        game.batch.draw((TextureRegion) tank1.getAnimation().getKeyFrame(elapsedTime, true), 200, 400,450,400);
        game.batch.draw(details, detailsRect.x, detailsRect.y, detailsRect.width, detailsRect.height);
        game.batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
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
