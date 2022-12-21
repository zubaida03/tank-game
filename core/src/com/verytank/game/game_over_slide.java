package com.verytank.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class game_over_slide implements Screen {
    private int x =Gdx.graphics.getWidth()/2 ;
    private int y = 150 ;
    private int width = 0;
    private int width2 = 0;
    private int height = 800;
    private int x2 = Gdx.graphics.getWidth()/2;
    private int y2 = 150;
    private int height2 = 800;
    private final Very_Tank game;
    private tank winner;

    @Override
    public void show() {

    }
    public game_over_slide(final Very_Tank game,tank tank1){
        this.game = game;
        this.winner = tank1;

    }

    @Override
    public void render(float delta) {
        game.batch.enableBlending();
//        game.batch.begin();
//        width = 0;
//        width2 = 0;
        width-=7;
        width2+=7;
//
        if (width2> Gdx.graphics.getWidth()/2){
            width2-=7;
            game.setScreen(new game_over(game,winner));


//            game.setScreen(new actuallogin((game)));
        }
        if (800>Gdx.graphics.getWidth()/2){
            width+=7;

            game.setScreen(new game_over(game,winner));
        }
        game.batch.enableBlending();
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        game.shapeRenderer.setColor(new Color(0.1f,0.4f,0.6f,0.8f));
        game.shapeRenderer.rect(x,y,width,height);
        game.shapeRenderer.rect(x2,y2,width2,height2);
        game.shapeRenderer.end();
        Gdx.gl.glDisable(GL20.GL_BLEND);
//        game.batch.end();

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
