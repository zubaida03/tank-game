package com.verytank.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.awt.*;

public class LoadScreen extends ScreenAdapter {
    Very_Tank game;
    private SpriteBatch batch;
//<<<<<<<<< Temporary merge branch 1
//=========
//
//>>>>>>>>> Temporary merge branch 2
    private Texture load_sign;
    private Rectangle load_sign_rect;
    private Texture load_img;
    private Rectangle load_img_rect;
    private Pixmap pixmap;

    public LoadScreen(Very_Tank game) {
        this.game = game;
//<<<<<<<<< Temporary merge branch 1

        batch = new SpriteBatch();
//        pixmap = new Pixmap(100,20, Pixmap.Format.RGBA8888);
//        pixmap.setColor(Color.WHITE);
//        pixmap.fill();
//        TextureRegionDrawable drawable = new TextureRegionDrawable(new Texture(pixmap));
//        ProgressBar.ProgressBarStyle style = new ProgressBar.ProgressBarStyle(drawable, drawable);
//        style.background = drawable;
        load_img = new Texture(Gdx.files.internal("loader.png"));
        load_img_rect = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        load_sign = new Texture(Gdx.files.internal("load_line.png"));
        //load_sign_rect = new Rectangle(710, 0, 500, 300);
        load_sign_rect = new Rectangle((int)(Gdx.graphics.getWidth()*0.3697), 0, (int)(Gdx.graphics.getWidth()*0.2604), (int)(Gdx.graphics.getHeight()*0.2777));

        //load_sign_rect = new Rectangle(710, 0, (int)(Gdx.graphics.getWidth()*0.2604), (int)(Gdx.graphics.getHeight()*0.2777));

        //System.out.println(Gdx.graphics.getWidth());
        //System.out.println(Gdx.graphics.getHeight());

//=========
        batch = new SpriteBatch();
        load_img = new Texture(Gdx.files.internal("loader.png"));
        load_img_rect = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        load_sign = new Texture(Gdx.files.internal("load_line.png"));
        load_sign_rect = new Rectangle(710, 0, 500, 300);
//>>>>>>>>> Temporary merge branch 2
    }
    @Override
    public void show(){

    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
//<<<<<<<<< Temporary merge branch 1
//        batch.begin();
//=========
//>>>>>>>>> Temporary merge branch 2
        game.batch.draw(load_img, load_img_rect.x, load_img_rect.y, load_img_rect.width, load_img_rect.height);
        game.batch.draw(load_sign, load_sign_rect.x, load_sign_rect.y, load_sign_rect.width, load_sign_rect.height);
        String text = "Loading...";
        game.font.setColor(Color.BLACK);
        game.font.getScaleY();
//<<<<<<<<< Temporary merge branch 1
//        game.font.draw(game.batch, text, 900, 150);
//        game.font.draw(game.batch, "Click the circle to win.", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .5f);
//        game.font.draw(game.batch, "Press space to play.", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .25f);
//        batch.end();
//=========
//>>>>>>>>> Temporary merge branch 2
        game.batch.end();


//        return 0;
    }
}

