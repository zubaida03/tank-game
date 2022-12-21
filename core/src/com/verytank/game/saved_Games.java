package com.verytank.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;

public class saved_Games implements Screen {
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
    private Texture avatar_name;
    private Rectangle avatar_nameRect;
    private Texture saved;
    private Rectangle savedRect;
    private saved_game saved_game;
    private int i=0;

    public saved_Games(Very_Tank game) {

        this.game = game;
        background = new Texture("tank-stars-banner.jpg");
        backgroundBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        name = new Texture("name.png");
        nameRect = new Rectangle(800, 800, 200, 80);
        selectanks = new Texture("selectanks.png");
        selectanksRect = new Rectangle(800, 450, 200, 80);
        avatar_name = new Texture("avatar_name.png");
        avatar_nameRect = new Rectangle(200, 650, 160, 80);
        saved = new Texture("register.png");
        savedRect = new Rectangle(880, 800, 160, 80);
        saved_game = saved_game.getInstance();
        saved_game.printshit();
//        saved_game.testing();
//        saved_game.printshit();



    }

    @Override
    public void show() {


    }
    public void print(){
        saved_game.printshit();

    }

    @Override
    public void render(float delta) {
//        saved_game saved_game = new saved_game(game);
//        saved_game.getInstance();

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
        elapsedTime += Gdx.graphics.getDeltaTime();
        tankThree tank3 = new tankThree();
        tank3.getAnimation();
        tankTwo tank2 = new tankTwo();
        tank2.getAnimation();
        tankOne tank1 = new tankOne();
        tank1.getAnimation();
        game.batch.begin();

        for(i=1;i<saved_game.getInstance().getSaved().size();i++){
            player p1 = saved_game.getSaved().get(i).get(0);
            player p2 = saved_game.getSaved().get(i).get(1);
            game.batch.draw(p1.getTank().getTank(),100,Gdx.graphics.getHeight()-100*i,300,200);
            game.batch.draw(p2.getTank().getTank(),1000,Gdx.graphics.getHeight()-100*i,300,200);
            i++;
        }
//        game.batch.draw(name,nameRect.x,nameRect.y,nameRect.width,nameRect.height);
//        game.batch.draw(selectanks,selectanksRect.x,selectanksRect.y,selectanksRect.width,selectanksRect.height);
//        game.batch.draw((TextureRegion) tank3.getAnimation().getKeyFrame(elapsedTime, true), 400, 600);
//        game.batch.draw((TextureRegion) tank2.getAnimation().getKeyFrame(elapsedTime, true), 1200, 600);
//        game.batch.draw((TextureRegion) tank1.getAnimation().getKeyFrame(elapsedTime, true), 400, 400);
//        game.batch.draw((TextureRegion) tank1.getAnimation().getKeyFrame(elapsedTime, true), 1200, 200);
//        game.batch.draw((TextureRegion) tank3.getAnimation().getKeyFrame(elapsedTime, true), 1200, 400);
//        game.batch.draw((TextureRegion) tank2.getAnimation().getKeyFrame(elapsedTime, true), 400, 200);
//        game.batch.draw(avatar_name,avatar_nameRect.x,avatar_nameRect.y,avatar_nameRect.width,avatar_nameRect.height);
//        game.batch.draw(avatar_name,avatar_nameRect.x,avatar_nameRect.y-200,avatar_nameRect.width,avatar_nameRect.height);
//        game.batch.draw(avatar_name,avatar_nameRect.x,avatar_nameRect.y-400,avatar_nameRect.width,avatar_nameRect.height);
//        game.batch.draw(avatar_name,avatar_nameRect.x+1400,avatar_nameRect.y,avatar_nameRect.width,avatar_nameRect.height);
//        game.batch.draw(avatar_name,avatar_nameRect.x+1400,avatar_nameRect.y-200,avatar_nameRect.width,avatar_nameRect.height);
//        game.batch.draw(avatar_name,avatar_nameRect.x+1400,avatar_nameRect.y-400,avatar_nameRect.width,avatar_nameRect.height);
//        game.batch.draw(saved,savedRect.x,savedRect.y,savedRect.width,savedRect.height);


        game.batch.end();


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

    }
    public void main(String[] args) {
//        saved_game =  saved_game.;
        saved_game.printshit();
    }
}
