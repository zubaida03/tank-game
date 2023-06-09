package com.verytank.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;

public class pausemenu implements Screen {
    private Very_Tank game;
    private SpriteBatch batch;
    private Rectangle backgroundBounds;

    private Texture backgroundImage;

    private Texture groundImage;
    private Rectangle groundBounds;

    private Texture playerBadgeImage1;
    private Rectangle playerBadgeBounds1;

    private Texture playerBadgeImage2;
    private Rectangle playerBadgeBounds2;

    private Texture healthImage1;
    private Rectangle healthBounds1;

    private Texture healthImage2;
    private Rectangle healthBounds2;

    private Texture health2Image1;
    private Rectangle health2Bounds1;

    private Texture health2Image2;
    private Rectangle health2Bounds2;

    private Texture vsImage;
    private Rectangle vsBounds;

    private Texture pauseImage;
    private Rectangle pauseBounds;
    private tank tank1;
    private tank tank2;
    private int x =Gdx.graphics.getWidth()/2 ;
    private int y = 150 ;
    private int width = 0;
    private int height = 800;
    private int x2 = Gdx.graphics.getWidth()/2;
    private int y2 = 150;
    private int width2 = 0; ;
    private int height2 = 800;
    private Texture pausemenuImage;
    private Rectangle pausemenuBounds;
    private gameLoader gameNow;
    public pausemenu(Very_Tank game,tank tank1,tank tank2, gameLoader gameNow) {
        this.gameNow=gameNow;
        this.tank1 = tank1;
        this.tank2 = tank2;
        batch= new SpriteBatch();
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("game_background.png"));
        backgroundBounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        groundImage=new Texture(Gdx.files.internal("ground.png"));
        groundBounds=new Rectangle(-10,-40,Gdx.graphics.getWidth()+40,Gdx.graphics.getHeight()+40);

        playerBadgeImage1=new Texture(Gdx.files.internal("playerBadge.png"));
        playerBadgeBounds1 =new Rectangle(350+12, Gdx.graphics.getHeight()-130, 130,130);

        playerBadgeImage2=new Texture(Gdx.files.internal("playerBadge.png"));
        playerBadgeBounds2 =new Rectangle(Gdx.graphics.getWidth()-350-130+40, Gdx.graphics.getHeight()-130, 130,130);

        healthImage1=new Texture(Gdx.files.internal("health.png"));
        healthBounds1=new Rectangle(350+100+6, Gdx.graphics.getHeight()-95, 400,61);

        healthImage2=new Texture(Gdx.files.internal("health.png"));
        healthBounds2=new Rectangle(Gdx.graphics.getWidth()-350-100-400-30+50, Gdx.graphics.getHeight()-95, 400,61);

        health2Image1=new Texture(Gdx.files.internal("health2.png"));
        health2Bounds1=new Rectangle(350+100+6+5, Gdx.graphics.getHeight()-91, 390,53);

        health2Image2=new Texture(Gdx.files.internal("health2.png"));
        health2Bounds2=new Rectangle(Gdx.graphics.getWidth()-350-100-400-30+50+5, Gdx.graphics.getHeight()-91, 390,53);


        vsImage =new Texture("vs.png");
        vsBounds=new Rectangle(456+65+400+3,Gdx.graphics.getHeight()-125, 100,100 );

        //System.out.println(Gdx.graphics.getHeight());
        //System.out.println(Gdx.graphics.getWidth());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
//        Gdx.gl.glClearColor(1, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.enableBlending();
//        game.batch.begin();
//        game.batch.draw(backgroundImage,backgroundBounds.x,backgroundBounds.y,backgroundBounds.width,backgroundBounds.height);
//        game.batch.draw(groundImage,groundBounds.x,groundBounds.y,groundBounds.width,groundBounds.height);
//        game.batch.draw(playerBadgeImage1,playerBadgeBounds1.x,playerBadgeBounds1.y,playerBadgeBounds1.width,playerBadgeBounds1.height);
//        game.batch.draw(playerBadgeImage2,playerBadgeBounds2.x,playerBadgeBounds2.y,playerBadgeBounds2.width,playerBadgeBounds2.height);
//        game.batch.draw(healthImage1,healthBounds1.x,healthBounds1.y,healthBounds1.width,healthBounds1.height);
//        game.batch.draw(healthImage2,healthBounds2.x,healthBounds2.y,healthBounds2.width,healthBounds2.height);
//        game.batch.draw(health2Image1,health2Bounds1.x,health2Bounds1.y,health2Bounds1.width,health2Bounds1.height);
//        game.batch.draw(health2Image2,health2Bounds2.x,health2Bounds2.y,health2Bounds2.width,health2Bounds2.height);
//
//        game.batch.draw(vsImage,vsBounds.x,vsBounds.y,vsBounds.width,vsBounds.height);


        //sprite.draw(game.batch);
//        game.batch.end();
        width-=7;
        width2+=7;
//
        if (width2>Gdx.graphics.getWidth()/2){
            width2-=7;
            game.setScreen(new pausemenu_act(game,tank1,tank2,gameNow));


//            game.setScreen(new actuallogin((game)));
        }
        if (Math.abs(height)>Gdx.graphics.getWidth()/2){
            width+=7;

            game.setScreen(new pausemenu_act(game,tank1,tank2,gameNow));
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
}
