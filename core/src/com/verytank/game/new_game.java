package com.verytank.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.*;

public class new_game implements Screen {
    private Texture tan1_img;
    private Texture tan2_img;
    private Texture tan3_img;
    private Rectangle tan1_rect;
    private Rectangle tan2_rect;
    private Rectangle tan3_rect;
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
    private Texture logo;
    private Rectangle logo_rect;
    private TextureRegion tank1_region;
    private TextureRegion tank2_region;
    private TextureRegion tank3_region;
    private TextureRegionDrawable tank1_drawable;
    private TextureRegionDrawable tank2_drawable;
    private TextureRegionDrawable tank3_drawable;
    private ImageButton tank1_button;
    private ImageButton tank3_button;
    private ImageButton tank2_button;
    private Stage stage;

    public new_game(Very_Tank game){
        this.game = game;
        background = new Texture("tank-stars-banner.jpg");
        backgroundBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        name = new Texture("name.png");
        nameRect = new Rectangle(800, 800, 200, 80);
        selectanks = new Texture("selectanks.png");
        selectanksRect = new Rectangle(800, 450, 200, 80);
        logo = new Texture("download-removebg-preview.png");
        logo_rect = new Rectangle(650, 600, 600, 600);
        tan1_img = new Texture("tank1_img.png");
        tan2_img = new Texture("tan2_img.png");
        tan3_img = new Texture("tan3_img.png");

        tank1_region = new TextureRegion(tan1_img);
        tank1_drawable = new TextureRegionDrawable(tank1_region);
        tank2_region = new TextureRegion(tan2_img);
        tank2_drawable = new TextureRegionDrawable(tank2_region);
        tank3_region = new TextureRegion(tan3_img);
        tank3_drawable = new TextureRegionDrawable(tank3_region);

    }

    @Override
    public void show() {
        tank1_button = new ImageButton(tank1_drawable);
        tank1_button.setPosition(400, 200);
        tank1_button.setSize(300,300);
        tank2_button = new ImageButton(tank2_drawable);
        tank2_button.setPosition(800, 170);
        tank2_button.setSize(300,300);
        tank3_button = new ImageButton(tank3_drawable);
        tank3_button.setPosition(1200, 200);
        tank3_button.setSize(300,300);
        stage = new Stage(new ScreenViewport());
        stage.addActor(tank1_button);
        stage.addActor(tank2_button);
        stage.addActor(tank3_button);
        tank1_button.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                tank1_button.setSize(400,400);
            }
            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                tank1_button.setSize(300,300);
            }
        });
        tank2_button.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                tank2_button.setSize(400,400);
            }
            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                tank2_button.setSize(300,300);
            }
        });
        tank3_button.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y,int pointer, Actor fromActor) {
                tank3_button.setSize(400,400);
                tank3_button.setPosition(1200, 200);
            }
            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                tank3_button.setSize(300,300);
                tank3_button.setPosition(1200, 200);
            }
        });
        Gdx.input.setInputProcessor(stage);
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
        game.batch.draw(name,nameRect.x+50,nameRect.y-130,nameRect.width,nameRect.height);
        game.batch.draw(selectanks,selectanksRect.x+50,selectanksRect.y-30,selectanksRect.width,selectanksRect.height);
        game.batch.draw(logo,logo_rect.x,logo_rect.y,logo_rect.width,logo_rect.height);
//        game.batch.draw(background,backgroundBounds.x,backgroundBounds.y,backgroundBounds.width,backgroundBounds.height);
//        game.batch.draw((TextureRegion) tank3.getAnimation().getKeyFrame(elapsedTime, true), 400, 200);
//        game.batch.draw((TextureRegion) tank2.getAnimation().getKeyFrame(elapsedTime, true), 1200, 200);
//        game.batch.draw((TextureRegion) tank1.getAnimation().getKeyFrame(elapsedTime, true), 800, 200);
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
