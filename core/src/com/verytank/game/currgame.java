package com.verytank.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.awt.*;

import static jdk.jfr.internal.consumer.EventLog.update;

public class currgame extends ApplicationAdapter implements Screen  {
    private GameScreen background;
    private new_game player1;
    private weapon weapon1;
    private final Very_Tank game;
    private tank player1_tank;
    private tank player2_tank;
    private Texture tank1;
    private Texture tank2;
    private Rectangle tank1Rect;
    private Rectangle tank2Rect;
    private Texture w_1;
    private Rectangle weapon1Rect;
    private Sprite sprite;
    private TextureAtlas textu;
    private Sprite bomb;
    private World world;
    private box2d model;
    private OrthographicCamera camera;
    private Box2DDebugRenderer debugRenderer;
    private Body player1Body;
    private Body player2Body;
    private Body weapon1Body;
    private Texture groundImage;

    private int a = 0;
    public currgame(Very_Tank game){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
        world = new World(new Vector2(0, -9.8f), true);
        background = new GameScreen(game);
        player1 = new new_game(game);
        debugRenderer = new Box2DDebugRenderer(true, true, true, true, true, true);
        groundImage=new Texture(Gdx.files.internal("ground.png"));
        tank1 = new Texture("tank1_img.png");
        tank2 = new Texture("tan2_img_inverted.png");
        w_1 = new Texture("spritesheet.png");
//        w_1 = new Texture("w1.jpeg");
//        sprite = new Sprite(w_1,180,460,100,100);
//        sprite.rotate(90);
        weapon1Rect = new Rectangle(180,460,100,100);
        tank1Rect = new Rectangle(100, 322, 300, 200);
        tank2Rect = new Rectangle(1000, 318, 300, 150);
        weapon1 = new weapon(100,100,100,100,weapon1Rect);
        player1_tank = new tank(100, 100, 100, 100, 100, 100, 100,tank1Rect, "player1");
        player2_tank = new tank(1000, 100, 100, 100, 100, 100, 100,tank2Rect,  "player2");
        player1Body = createplayerdynamic(100,322,player1Body);
        player2Body = createplayerdynamic(1000,318,player2Body);
        weapon1Body = createplayerdynamic(180,460,weapon1Body);
        player2Body.setGravityScale(0);
        player1Body.setGravityScale(0);
        weapon1Body.setGravityScale(0);
    }
    private Body createPlayerstatic(float x, float y, Body body){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(x, y);
        body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(300, 200);
        body.createFixture(shape, 0.0f);
        shape.dispose();
        return body;
    }
    private Body createplayerdynamic(int a,int b,Body body) {
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(a,b);
        def.fixedRotation = true;
//        body.setUserData(tank1);
        FixtureDef fd = new FixtureDef();
        fd.density = 1;
        fd.friction = 0.5f;
        fd.restitution = 0.3f;
        body = world.createBody(def);
        return body;
    }

    public void logicStep(float delta){
        world.step(delta , 3, 3);
    }

    @Override
    public void create () {

    }
    @Override
    public void show() {

    }
//    player1_tank = new tank();
//    player2_tank = new tank();

    @Override
    public void render(float delta) {
//        player1.show();
//        player1.render(delta);
        update(Gdx.graphics.getDeltaTime());
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        background.render(delta);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && player1Body.getPosition().x > 0)
            player1Body.setTransform(player1Body.getPosition().x - 5, player1Body.getPosition().y, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player1Body.getPosition().x < Gdx.graphics.getWidth() - 300)
            player1Body.setTransform(player1Body.getPosition().x + 5, player1Body.getPosition().y, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.A) && player2Body.getPosition().x > 0)
            player2Body.setTransform(player2Body.getPosition().x - 5, player2Body.getPosition().y, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.D) && player2Body.getPosition().x < Gdx.graphics.getWidth() - 300)
            player2Body.setTransform(player2Body.getPosition().x + 5, player2Body.getPosition().y, 0);
        debugRenderer.render(world, camera.combined);
        world.step(1/60f, 6, 2);
        game.batch.begin();
        game.batch.draw(tank1, player1Body.getPosition().x, player1Body.getPosition().y, 300, 200);
        game.batch.draw(tank2, player2Body.getPosition().x, player2Body.getPosition().y, 300, 150);
        game.batch.draw(w_1, weapon1Body.getPosition().x, weapon1Body.getPosition().y, 50, 50);
        game.batch.end();
    }

    private void update(float deltaTime) {
    }


    @Override
    public void resize(int width, int height) {
//        camera.setToOrtho(false, width/2, height/2);
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
        world.dispose();
        player1.dispose();
        background.dispose();
        debugRenderer.dispose();
    }
}

