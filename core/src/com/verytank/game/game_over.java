package com.verytank.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.*;
import java.io.PrintWriter;

public class game_over implements Screen {
    BitmapFont font = new BitmapFont();
    private final Very_Tank game;
    private tank winner;
    private Texture gameoverImage;
    private Texture winnerImage;
    private Rectangle gameoverBounds;
    private Rectangle winnerBounds;
    private Stage stage;
    private TextureRegion newGameRegion;
    private TextureRegionDrawable newGameDrawable;
    private ImageButton newGameButton;
    private TextureRegion exitRegion;
    private TextureRegionDrawable exitDrawable;
    private ImageButton exitButton;
    private TextureRegion saveRegion;
    private TextureRegionDrawable saveDrawable;
    private ImageButton saveButton;

    public game_over(final Very_Tank game,tank tank1){
        this.game = game;
        this.winner=tank1;
        gameoverImage = new Texture(Gdx.files.internal("game_over.png"));
        gameoverBounds = new Rectangle(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

    }
    public ImageButton buttonmaker(String address, TextureRegion region, TextureRegionDrawable drawable, ImageButton button, float x, float y, float width, float height) {
        region = new TextureRegion(new Texture(address));
        drawable = new TextureRegionDrawable(region);
        button = new ImageButton(drawable);
        button.setPosition(x, y);
        button.setSize(width, height);
        stage.addActor(button);
        return button;
    }
    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        newGameButton = buttonmaker("signin.png", newGameRegion, newGameDrawable, newGameButton, 100, 200, 200, 100);
        exitButton = buttonmaker("exit.png", exitRegion, exitDrawable, exitButton, 850, 200, 200, 100);
        saveButton = buttonmaker("register.png", saveRegion, saveDrawable, saveButton, 1500, 200, 200, 100);
        stage.addActor(newGameButton);
        stage.addActor(exitButton);
        stage.addActor(saveButton);
        Gdx.input.setInputProcessor(stage);

        newGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new new_game_tank_confirm(game));
                dispose();
            }
        });
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
                dispose();
            }
        });
        saveButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new saved_Games(game));
                dispose();
            }
        });

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        game.shapeRenderer.setColor(new Color(0.8f,0.8f,0.8f,0.5f));
//        game.shapeRenderer.rect(0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.shapeRenderer.setColor(new Color(0.1f,0.4f,0.6f,0.8f));
        game.shapeRenderer.rect(0,150,Gdx.graphics.getWidth(), 800);
        game.shapeRenderer.end();
        game.batch.begin();
        game.batch.draw(gameoverImage,gameoverBounds.x-200,gameoverBounds.y+200,400,200);
        font.getData().scaleX=2;
        font.getData().scaleY=2;
        font.setColor(Color.BLACK);
        font.draw(game.batch, "Winner is: "+winner.getName(), gameoverBounds.x-100, gameoverBounds.y+100 );
        game.batch.draw(winner.getTank(),gameoverBounds.x-180,gameoverBounds.y-160,300,200);
        game.batch.end();
        stage.act();
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
