package com.verytank.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import org.w3c.dom.css.Rect;

import java.awt.*;

public class testing implements Screen {
    private GameScreen background;
    private final Very_Tank game;
    private tank player1_tank;
    private tank player2_tank;
    private Texture tank1;
    private Texture tank2;
    private Rectangle tank1Rect;
    private Rectangle tank2Rect;
    private Sprite weapon1;
    private Rectangle weapon1Rect;
    private Texture pause_button;
    private Stage stage;
    private TextureRegion pause;
    private TextureRegionDrawable pausedrawable;
    private ImageButton pausebutton;
    private Texture turn_g;
    private Texture turn_r;
    private int turn = 0;

    public ImageButton buttonmaker(String address, TextureRegion region, TextureRegionDrawable drawable, ImageButton button, float x, float y, float width, float height,Stage stage){
        region = new TextureRegion(new Texture(address));
        drawable = new TextureRegionDrawable(region);
        button = new ImageButton(drawable);
        button.setPosition(x, y);
        button.setSize(width, height);
        stage.addActor(button);
        return button;
    }
    public testing(Very_Tank game){
        this.game = game;
        background = new GameScreen(game);
        weapon1 = new Sprite(new Texture("spritesheet.png"));
//        weapon1.rotate(90);
        weapon1.setSize(50,50);
        weapon1.setPosition(400,400);
//        weapon1Rect = new Rectangle(500,500,50,50);
        tank1 = new Texture("tank1_img.png");
        tank2 = new Texture("tan2_img_inverted.png");
        turn_g = new Texture("turn_g.png");
        turn_r = new Texture("turn_r.png");
        stage = new Stage();
        pausebutton = buttonmaker("pausebutton.png", pause, pausedrawable, pausebutton, 70, Gdx.graphics.getHeight()-150, 70, 70,stage);
        tank1Rect = new Rectangle(100, 334, 300, 200);
        tank2Rect = new Rectangle(1000, 328, 300, 200);
        stage.addActor(pausebutton);
        Gdx.input.setInputProcessor(stage);
//        player1_tank = new tank(100, 100, 100, 100, 100, 100, 100, "player1");
//        player2_tank = new tank(1000, 100, 100, 100, 100, 100, 100,  "player2");
    }

    @Override
    public void show() {

    }
    public void missile_fired(int x){
        this.turn = x;
    }
    @Override
    public void render(float delta) {
        background.render(delta);

        if (turn==0) {
            game.batch.begin();
            game.batch.draw(turn_g, 200, Gdx.graphics.getHeight()-100, 40, 40);
            game.batch.draw(turn_r, Gdx.graphics.getWidth()-200, Gdx.graphics.getHeight()-70, 40, 40);
            game.batch.end();
//
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && tank1Rect.x > 0)
                tank1Rect.x -= 200 * Gdx.graphics.getDeltaTime();
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && tank1Rect.x < Gdx.graphics.getWidth() - 300)
                tank1Rect.x += 200 * Gdx.graphics.getDeltaTime();
            if (Gdx.input.isKeyJustPressed(Input.Keys.P)){
                missile_fired(1);
            }
        }
        else {
            game.batch.begin();
            game.batch.draw(turn_g, Gdx.graphics.getWidth()-200, Gdx.graphics.getHeight()-70, 40, 40);
            game.batch.draw(turn_r, 200, Gdx.graphics.getHeight()-100, 40, 40);
            game.batch.end();
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && tank2Rect.x > 0)
                tank2Rect.x -= 200 * Gdx.graphics.getDeltaTime();
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && tank2Rect.x < Gdx.graphics.getWidth() - 300)
                tank2Rect.x += 200 * Gdx.graphics.getDeltaTime();
            if (Gdx.input.isKeyJustPressed(Input.Keys.P)){
                missile_fired(0);
            }
        }
        game.batch.begin();
        game.batch.draw(tank1,tank1Rect.x,tank1Rect.y,tank1Rect.width,tank1Rect.height);
        game.batch.draw(tank2,tank2Rect.x,tank2Rect.y,tank2Rect.width,tank2Rect.height);
//        weapon1.draw(game.batch);
        missilelaunch();
        game.batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void missilelaunch(){
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            System.out.println("space");
            double speed = 60.0;
            double angle = 45;
            double deltatime = 0.0001;
            double endtime = 10.0;
            double time = 0.0;
            double ay = -9.8;
            double ax = 0.0;
            float x = weapon1.getX();
            float y = weapon1.getY();
            float x1 = (float) (x + speed * Math.cos(angle) * deltatime);
            float y1 = (float) (y + speed * Math.sin(angle) * deltatime);
            while (time<endtime){
                time+=deltatime;
                weapon1.setX((float) (weapon1.getX()+x1*deltatime));
                weapon1.setY((float) (weapon1.getY()+y1*deltatime));

//                y+=y1*deltatime;
                x1+=ax*deltatime;
                y1+=ay*deltatime;
            }
        }
//        weapon1.rotate(90);
//        weapon1.setPosition(weapon1.getX(),weapon1.getY()+100*Gdx.graphics.getDeltaTime());
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
