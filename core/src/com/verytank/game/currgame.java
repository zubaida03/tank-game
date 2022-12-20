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
import com.badlogic.gdx.physics.box2d.joints.FrictionJointDef;

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
    private Body groundBody;

    private int a = 0;
    private Body testWeapon;
    private float VIRTUAL_HEIGHT=10f;
    public currgame(Very_Tank game){
        this.game = game;
//        camera = new OrthographicCamera(1920/100, 1080/100);

// fix camera to the center of the screen
//        camera.position.set(1920/100/2f, 1080/100/2f, 0);

//        camera.update();
        //        camera.setToOrtho(false, 100, 44);

        //camera = new OrthographicCamera(10, 0.4f);
        camera = new OrthographicCamera(20, 8);
        camera.position.set(20f/2f,8f/2f,0);
        camera.update();

        world = new World(new Vector2(0, -9.81f), true);
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
        player1Body = createplayerdynamic(100,335,player1Body);
        player2Body = createplayerdynamic(1000,332,player2Body);
        weapon1Body = createPlayerkinematic(180,460,weapon1Body);
        groundBody = createPlayerStatic(-10,-40,groundBody,(int)(Gdx.graphics.getWidth()+0.027*(Gdx.graphics.getWidth())),(int)(Gdx.graphics.getHeight()-0.634f*(Gdx.graphics.getHeight())-120f));
        player2Body.setGravityScale(0);
        player1Body.setGravityScale(0);
        weapon1Body.setGravityScale(0);
//        weapon1Body.setLinearVelocity(5f,5f);
//        player1Body.applyLinearImpulse(100.0f, 0.0f, player1_tank.getCurrX(), , true);
//        player2Body.applyLinearImpulse(-100.0f, 0.0f, 0.0f, 0.0f, true);
//        player1Body.setLinearVelocity(500f,0f);
//        player2Body.setLinearVelocity(-500f,0f);
//        friction joint
        FrictionJointDef jointDef = new FrictionJointDef();
        FrictionJointDef player2fric = new FrictionJointDef();
        player2fric.maxForce = 10f;
        jointDef.maxForce = 10f;
        jointDef.initialize(player1Body, groundBody, player1Body.getWorldCenter());
        player2fric.initialize(player2Body, groundBody, player2Body.getWorldCenter());
        world.createJoint(jointDef);
        world.createJoint(player2fric);



        testWeapon=shoot(player1_tank,weapon1,60);

    }
    private Body createPlayerStatic(float x, float y, Body body,int width,int height) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(x, y);
        body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width, height);
        body.createFixture(shape, 0.0f);
        shape.dispose();
        return body;
    }
    private Body createPlayerkinematic(float x, float y, Body body){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(x, y);
        body = world.createBody(bodyDef);
//        PolygonShape shape = new PolygonShape();
//        shape.setAsBox(10, 10);
//        body.createFixture(shape, 0.0f);
//        shape.dispose();
        return body;
    }
    private Body createplayerdynamic(int a,int b,Body body) {
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(a,b);
        def.fixedRotation = true;
//        body.setUserData(tank1);
//        FixtureDef fd = new FixtureDef();
//        fd.density = 1;
//        fd.friction = 0.5f;
//        fd.restitution = 0.3f;
        body = world.createBody(def);
        return body;
    }

    public void logicStep(float delta){
        world.step(delta , 3, 3);
    }



    Vector2 getTrajectoryPoint( Vector2 startingPosition, Vector2 startingVelocity, float n )
    {
        //velocity and gravity are given per second but we want time step values here
        float t = 1 / 60.0f; // seconds per time step (at 60fps)
        Vector2 stepVelocity = startingVelocity.scl(t,t); // m/s
        Vector2 stepGravity = world.getGravity().scl(t*t,t*t); // m/s/s

        return startingPosition.add(stepVelocity.scl(n).add(stepGravity.scl(0.5f*(n*n+n))));
    }
    public Body shoot(tank tank, weapon weapon, float angle){
        float weaponX=tank.getCurrX();
        float weaponY= tank.getCurrY();
        weapon.setXcurr(weaponX);
        weapon.setYcurr(weaponY);
        BodyDef weaponDef=new BodyDef();
        weaponDef.bullet = true;
        weaponDef.type=BodyDef.BodyType.DynamicBody;
        weaponDef.position.set(weaponX,weaponY);
        Body weaponBody=world.createBody(weaponDef);
        weaponBody.setTransform(weaponBody.getPosition().x,weaponBody.getPosition().y,angle);
        PolygonShape weaponShape=new PolygonShape();
        weaponShape.setAsBox(w_1.getWidth()*(1/100), w_1.getHeight()*(1/100));
//        weaponBody.setGravityScale(9.8f);
        FixtureDef weaponFixture=new FixtureDef();

        //private float fixtureHeight = texture.getHeight() * ratio;
        weaponFixture.shape=weaponShape;
        weaponFixture.density=26f;
        weaponFixture.friction=0.5f;

        Vector2 xycomp=getSpeed(angle);
//        for (int i=0; i<1920; i++){
//            Vector2 traj=getTrajectoryPoint(new Vector2(0,0), new Vector2(100*xycomp.x,100*xycomp.y),i);
//            weaponBody.setLinearVelocity(25f,100f);
//            //game.batch.draw(w_1,traj.x, traj.y,player1_tank.getCurrX(),player1_tank.getCurrY(),50,50);
//        }
//        weaponBody.applyForceToCenter(0f,0f,true)

        //Vector2 startingVelocity =new Vector2(1000,1000);
        //startingVelocity.rotateDeg((float) angle - 45);
        //weaponBody.setLinearVelocity(startingVelocity);
        weaponBody.setLinearVelocity(15*xycomp.x,15*xycomp.y);
        weaponBody.setAwake(true);



        return weaponBody;
        //weaponBody=createPlayerkinematic(weaponX,weaponY,weaponBody);

        //BodyDef weaponDef=new BodyDef();


    }
    @Override
    public void create () {

    }
    @Override
    public void show() {

    }
//    player1_tank = new tank();
//    player2_tank = new tank();
    public Vector2 getSpeed(double angle){
        float xComp=(float)Math.cos(angle*(3.14/180));
        float yComp=(float)Math.sin(angle*(3.14/180));
//        xComp=(float)xComp;
//        yComp=(float)yComp;
        return new Vector2(xComp,yComp);


    }
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



        double angle=75;
        Vector2 xycomp=getSpeed(angle);
        for (int i=0; i<1920; i++){
            Vector2 traj=getTrajectoryPoint(new Vector2(0,0), new Vector2(20*xycomp.x,20*xycomp.y),i);
            game.batch.draw(w_1,traj.x, traj.y,player1_tank.getCurrX(),player1_tank.getCurrY(),50,50);
        }
        game.batch.draw(tank1, player1Body.getPosition().x, player1Body.getPosition().y, 300, 200);
        game.batch.draw(tank2, player2Body.getPosition().x, player2Body.getPosition().y, 300, 150);
        game.batch.draw(w_1, player1Body.getPosition().x, player1Body.getPosition().y, 1f,1f);
//        testWeapon.getPosition().x=player1Body.getPosition().x;
//        testWeapon.getPosition().y=player1Body.getPosition().y;
        game.batch.draw(w_1,testWeapon.getPosition().x, testWeapon.getPosition().y, 0,0, 1f,1f, 50f,50f,testWeapon.getAngle(),0,0,w_1.getTextureData().getWidth(), w_1.getTextureData().getHeight(),false,false );
        game.batch.end();
    }

    private void update(float deltaTime) {
    }


    @Override
    public void resize(int width, int height) {
//        camera.setToOrtho(false, width/2, height/2);
       camera.viewportHeight=(20/width)*height;
       camera.update();
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

