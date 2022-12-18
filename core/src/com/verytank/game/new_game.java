package com.verytank.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import  com.badlogic.gdx.scenes.scene2d.ui.TextField;

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
    private float elapsedTime;
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
    private TextField TextField;
    private Skin mSkin;
    private TextureAtlas atlas;
    private TextureRegion confirm;
    private TextureRegionDrawable confirm_drawable;
    private ImageButton confirm_button;
    private Texture backButton;
    private Rectangle backButtonRect;
    private Texture nextButton;
    private Rectangle nextButtonRect;
    private TextureRegion next_region;
    private TextureRegionDrawable next_drawable;
    private ImageButton next_button;
    private Texture tick;
    private TextureRegion button_region;
    private TextureRegionDrawable button_drawable;
    private TextureRegion tick_img;
    private TextureRegionDrawable tick_drawable;
    private ImageButton tick_button;
    public ImageButton buttonmaker(String address, TextureRegion region, TextureRegionDrawable drawable, ImageButton button, float x, float y, float width, float height){
        region = new TextureRegion(new Texture(address));
        drawable = new TextureRegionDrawable(region);
        button = new ImageButton(drawable);
        button.setPosition(x, y);
        button.setSize(width, height);
        stage.addActor(button);
        return button;
    }
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
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        mSkin = new Skin(Gdx.files.internal("uiskin.json"));
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("uiskin.atlas"));
        mSkin.addRegions(atlas);
        tank1_button=buttonmaker("tank1_img.png",tank1_region, tank1_drawable, tank1_button, 400, 100, 300, 300);
        tank2_button=buttonmaker("tan2_img.png",tank2_region, tank2_drawable, tank2_button, 800, 70, 300, 300);
        tank3_button=buttonmaker("tan3_img.png",tank3_region, tank3_drawable, tank3_button, 1200, 100, 300, 300);
        tick_button=buttonmaker("tick.png",tick_img, tick_drawable, tick_button, 1060, 590, 40, 40);
        ImageButton back_button = buttonmaker("back_button.png", button_region, button_drawable, tick_button, 80, 800, 100, 100);
        next_button=buttonmaker("next_button.png",next_region, next_drawable, next_button,Gdx.graphics.getWidth()-200, 800, 100, 100);
        tank1_button.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                tank1_button.setSize(400,400);
            }
            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                tank1_button.setSize(300,300);
            }
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new tank1_details(game));
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
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new tank2_details(game));
            }
        });
        tank3_button.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y,int pointer, Actor fromActor) {
                tank3_button.setSize(400,400);
//                tank3_button.setPosition(1200, 200);
            }
            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                tank3_button.setSize(300,300);
//                tank3_button.setPosition(1200, 200);
            }
             @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new tank3_details(game));
            }
        });
        TextField = new TextField("", mSkin);
        TextField.setMessageText("test");
        TextField.setSize(200, 40);
        TextField.setColor(0.2f, 0.2f, 0.7f, 0.9f);
        TextField.setPosition(Gdx.graphics.getWidth()/2-TextField.getWidth()/2 -10, Gdx.graphics.getHeight()/2+50);
        stage.addActor(TextField);
        tick_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String name = TextField.getText();
                System.out.println(name);
                TextField.setText(name);
                TextField.setDisabled(true);
            }
        });
//        String name = TextField.getText();

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
//        game.batch.draw(backButton, backButtonRect.x, backButtonRect.y, backButtonRect.width, backButtonRect.height);
//        game.batch.draw(nextButton, nextButtonRect.x, nextButtonRect.y, nextButtonRect.width, nextButtonRect.height);
        game.batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
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
        name.dispose();
        tan1_img.dispose();
        tan2_img.dispose();
        tan3_img.dispose();
        selectanks.dispose();
        logo.dispose();
        background.dispose();
        stage.dispose();
    }
}

