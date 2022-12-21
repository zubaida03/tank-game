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
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.joints.FrictionJointDef;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.*;

import static jdk.jfr.internal.consumer.EventLog.update;

public class currgame extends ApplicationAdapter implements Screen {
    private GameScreen background;
    private double angle=0;
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
    private float VIRTUAL_HEIGHT = 10f;
    private float scaling= 0.01f;
    private Texture turn_g;
    private Texture turn_r;
    private Body weaponbody;
    private float speed =1;
    Vector2 trajPosVec ;
    private int turn = 0;

    public currgame(Very_Tank game) {
        this.player1_tank = new tank(100, 100, 40, 100, 90, 40, 90, "t2",new Texture("tan2_img.png"));
        this.player2_tank = new tank(1000, 100, 40, 100, 90, 40, 90,"t2" ,new Texture("tan2_img_inverted.png"));
        this.game = game;
        camera = new OrthographicCamera();
        ExtendViewport viewport = new ExtendViewport(50, 50, camera);
        world = new World(new Vector2(0, -981f*scaling), true);
        background = new GameScreen(game);
        player1 = new new_game(game);
        debugRenderer = new Box2DDebugRenderer(true, true, true, true, true, true);
        groundImage = new Texture(Gdx.files.internal("ground.png"));
        tank1 = new Texture("tank1_img.png");
        tank2 = new Texture("tan2_img_inverted.png");
        w_1 = new Texture("spritesheet.png");
        turn_g = new Texture("turn_g.png");
        turn_r = new Texture("turn_r.png");
        Sprite sprite=new Sprite(w_1);
        sprite.setScale(1/100f);

//        w_1 = new Texture("w1.jpeg");
//        sprite = new Sprite(w_1,180,460,100,100);
//        sprite.rotate(90);
        weapon1Rect = new Rectangle(180, 460, 100, 100);
        tank1Rect = new Rectangle(100, 322, 300, 200);
        tank2Rect = new Rectangle(1000, 318, 300, 200);
        weapon1 = new weapon(100, 100, 100, 100, weapon1Rect,w_1);
//        player1_tank = new tank(100, 100, 100, 100, 100, 100, 100, tank1Rect, "player1");
//        player2_tank = new tank(1000, 100, 100, 100, 100, 100, 100, tank2Rect, "player2");
        player1Body = createplayerdynamic(100, 318, player1Body);
        player2Body = createplayerdynamic(1000, 318, player2Body);

        weapon1Body = createPlayerkinematic(180, 460, weapon1Body);
        groundBody = createPlayerStatic(0, 0, groundBody, (int) (Gdx.graphics.getWidth() + 0.027 * (Gdx.graphics.getWidth())), (int) (Gdx.graphics.getHeight() - 0.634 * (Gdx.graphics.getHeight()) - 120));

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


        if(Gdx.input.isKeyPressed(Input.Keys.P))
            //testWeapon = shoot(player1_tank, ((player1Body.getPosition().x)+250*scaling), ((player1Body.getPosition().y)+200*scaling), weapon1,10,60);
        //testWeapon = shoot(player1_tank, 0, 0, weapon1,10,60);

//        drawTrajectory(0,0,100,100,45);
//        drawTrajectory(0,0,100,100,90);
        for (int i=0; i<90;i++){
            angle=i;
            //drawTrajectory(0,0,1,1,angle);

        }
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(500, 500);
        final FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        if (testWeapon != null) {
            testWeapon.createFixture(fixtureDef);
        }
    //        fixture_Creator(weaponbody);
//        world.setContactListener(new ContactListener() {
//            @Override
//            public void beginContact(Contact contact) {
//                System.out.println(fixtureDef.density);
//                // Check to see if the collision is between the second sprite and the bottom of the screen
//                // If so apply a random amount of upward force to both objects... just because
//                if((contact.getFixtureA().getBody().getUserData() == testWeapon &&
//                        contact.getFixtureB().getBody().getUserData() == player2Body)
//                        ||
//                        (contact.getFixtureA().getBody().getUserData() == testWeapon &&
//                                contact.getFixtureB().getBody().getUserData() == player2Body)) {
////                    player1Body.setLinearVelocity(-30*scaling, 0);
//                    player2Body.setLinearVelocity(100*scaling, 0);
////                    player1Body.applyForceToCenter( MathUtils.random(20,50),0,true);
////                    player2Body.applyForceToCenter(MathUtils.random(20,50),0, true);
//                }
//            }
//
//            @Override
//            public void endContact(Contact contact) {
//            }
//
//            @Override
//            public void preSolve(Contact contact, Manifold oldManifold) {
//            }
//
//            @Override
//            public void postSolve(Contact contact, ContactImpulse impulse) {
//            }
//        });
    }
//    public static boolean overlaps(Rectangle r1,Rectangle r2){
//        if
//    }

    public boolean collision_checker(Body body,Body body2){
        Rectangle t_rect = new Rectangle((int) body.getPosition().x+1,(int)body.getPosition().y, (2),1);
        Rectangle w_rect = new Rectangle((int)body2.getPosition().x,(int)body2.getPosition().y,1,1);
        if (t_rect.intersects(w_rect)){
            System.out.println(t_rect.getBounds());
            //System.out.println(t_rect.getLocation());
            System.out.println(t_rect.y);
            System.out.println(w_rect.getBounds());
            return true;
        }
//        if (Math.abs(t_rect.x-w_rect.x)<t_rect.width/2+w_rect.width/2 || Math.abs(t_rect.y-w_rect.y)<t_rect.height/2 + w_rect.height/2){
//            return true;
//        }
        return false;

//        if (body..overlaps(w_rect)){
//            System.out.println("collision");
//        }
    }

    private Body createPlayerStatic(float x, float y, Body body, int width, int height) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(x*scaling, y*scaling);
        body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width, height);
        body.createFixture(shape, 0.0f);
        shape.dispose();
        return body;
    }

    private Body createPlayerkinematic(float x, float y, Body body) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(x*scaling, y*scaling);
        body = world.createBody(bodyDef);
//        PolygonShape shape = new PolygonShape();
//        shape.setAsBox(10, 10);
//        body.createFixture(shape, 0.0f);
//        shape.dispose();
        return body;
    }

    private Body createplayerdynamic(int a, int b, Body body) {
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(a*scaling, b*scaling);
        def.fixedRotation = true;
//        body.setUserData(tank1);\
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(50*scaling,50*scaling );
        FixtureDef fd = new FixtureDef();
        fd.density = 26f;
        fd.shape = shape;
//        fd.friction = 0.5f;
//        fd.restitution = 0.3f;
        body = world.createBody(def);
        body.createFixture(fd);
        return body;
    }

    public void logicStep(float delta) {
        world.step(delta, 3, 3);
    }


    Vector2 getTrajectoryPoint(Vector2 startingPosition, Vector2 startingVelocity, float n) {
        //velocity and gravity are given per second but we want time step values here
        float t = 1 / 60.0f; // seconds per time step (at 60fps) //new Vector2(0,-9.8f)
        Vector2 stepVelocity = startingVelocity.scl(t, t); // m/s
        Vector2 stepGravity = new Vector2(0,-980f).scl(t * t, t * t); // m/s/s

        return startingPosition.add(stepVelocity.scl(n).add(stepGravity.scl(0.5f * (n * n + n))));
    }
    public void fixture_Creator(Body body){
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(10, 10);
        body.createFixture(shape, 0.0f);
        shape.dispose();
    }
//    weaponbod
    public Body shoot(tank tank,float weaponX,float weaponY, weapon weapon, float speed, float angle) {
        //float weaponX = tank.getCurrX();
        //float weaponY = tank.getCurrY();
        System.out.println("x"+weaponX);
        System.out.println("y"+weaponY);
        weapon.setXcurr(weaponX);
        weapon.setYcurr(weaponY);
        BodyDef weaponDef = new BodyDef();
        weaponDef.type = BodyDef.BodyType.DynamicBody;
        weaponDef.position.set(weaponX, weaponY);

        Body weaponBody = world.createBody(weaponDef);
//        weaponBody.setGravityScale(9.8f);
        Vector2 xycomp = getSpeed(angle);
        weaponBody.setTransform(weaponBody.getPosition().x, weaponBody.getPosition().y, angle);
        weaponBody.applyLinearImpulse(xycomp.x*speed,xycomp.y*speed,weaponBody.getWorldCenter().x, weaponBody.getWorldCenter().y,true);
//        fixture.setUserData(weapon);
//        fixture.setFilterData(new Filter());
//        weaponFixture.friction = 0.5f;
//        for (int i=0; i<1920; i++){
//            Vector2 traj=getTrajectoryPoint(new Vector2(0,0), new Vector2(100*xycomp.x,100*xycomp.y),i);
//            weaponBody.setLinearVelocity(25f,100f);
//            //game.batch.draw(w_1,traj.x, traj.y,player1_tank.getCurrX(),player1_tank.getCurrY(),50,50);
//        }
//        weaponBody.applyForceToCenter(0f,0f,true)

        //Vector2 startingVelocity =new Vector2(1000,1000);
        //startingVelocity.rotateDeg((float) angle - 45);
        //weaponBody.setLinearVelocity(startingVelocity);
        //weaponBody.applyLinearImpulse(500f,500f, weaponBody.getPosition().x,weaponBody.getPosition().y,true);
//        weaponBody.setAwake(true);
//        weaponShape.dispose();
        return weaponBody;
        //weaponBody=createPlayerkinematic(weaponX,weaponY,weaponBody);

        //BodyDef weaponDef=new BodyDef();


}

    @Override
    public void create() {

    }

    @Override
    public void show() {

    }
    public void missile_fired(int x){
        this.turn = x;
    }

    public void drawTrajectory(float x, float y, float ux, float uy,double angle){
        for (int i = 0; i < 2000; i++) {
            Vector2 xycomp = getSpeed(angle);
            Vector2 traj = getTrajectoryPoint(new Vector2(x, y), new Vector2(ux * xycomp.x, uy * xycomp.y), i);
            game.batch.begin();
            game.batch.draw(w_1, traj.x, traj.y, (int)player1_tank.getCurrX(), (int)player1_tank.getCurrY(), 20, 50);
            game.batch.end();
        }
    }
    //    player1_tank = new tank();
//    player2_tank = new tank();
    public Vector2 getSpeed(double angle) {
        float xComp = (float) Math.cos(angle * (3.14 / 180));
        float yComp = (float) Math.sin(angle * (3.14 / 180));
//        xComp=(float)xComp;
//        yComp=(float)yComp;
        return new Vector2(xComp, yComp);


    }

    @Override
    public void render(float delta) {
        stepWorld();
//        player1.show();
//        player1.render(delta);
//        collision(player2Body,testWeapon);


        update(Gdx.graphics.getDeltaTime());
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        background.render(delta);
        if (turn==0) {
            game.batch.begin();
            game.batch.draw(turn_g, 200, Gdx.graphics.getHeight()-100, 40, 40);
            game.batch.draw(turn_r, Gdx.graphics.getWidth()-200, Gdx.graphics.getHeight()-70, 40, 40);
            game.batch.end();
//
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && tank1Rect.x > 0)
                player1Body.setTransform(player1Body.getPosition().x - 0.05f, player1Body.getPosition().y, 0);
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && tank1Rect.x < Gdx.graphics.getWidth() - 300)
                player1Body.setTransform(player1Body.getPosition().x + 0.05f, player1Body.getPosition().y, 0);
            if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
                missile_fired(1);
            }
        }
        else {
            game.batch.begin();
            game.batch.draw(turn_g, Gdx.graphics.getWidth()-200, Gdx.graphics.getHeight()-70, 40, 40);
            game.batch.draw(turn_r, 200, Gdx.graphics.getHeight()-100, 40, 40);
            game.batch.end();
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && tank2Rect.x > 0)
                player2Body.setTransform(player2Body.getPosition().x - 0.05f, player2Body.getPosition().y, 0);
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && tank2Rect.x < Gdx.graphics.getWidth() - 300)
                player2Body.setTransform(player2Body.getPosition().x + 0.05f, player2Body.getPosition().y, 0);
            if (Gdx.input.isKeyJustPressed(Input.Keys.P)){
                missile_fired(0);
            }
        }
//        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && player1Body.getPosition().x > 0)
//            player1Body.setTransform(player1Body.getPosition().x - 5, player1Body.getPosition().y, 0);
//        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player1Body.getPosition().x < Gdx.graphics.getWidth() - 300)
//            player1Body.setTransform(player1Body.getPosition().x + 5, player1Body.getPosition().y, 0);
//        if (Gdx.input.isKeyPressed(Input.Keys.A) && player2Body.getPosition().x > 0)
//            player2Body.setTransform(player2Body.getPosition().x - 5, player2Body.getPosition().y, 0);
//        if (Gdx.input.isKeyPressed(Input.Keys.D) && player2Body.getPosition().x < Gdx.graphics.getWidth() - 300)
//            player2Body.setTransform(player2Body.getPosition().x + 5, player2Body.getPosition().y, 0);
        debugRenderer.render(world, camera.combined);
        //world.step(1 / 60f, 6, 2);

//        for (int i=0; i<90;i++){
//            drawTrajectory(0,0,100,100,i);
//        }
        game.batch.begin();

        trajPosVec=new Vector2(((player1Body.getPosition().x/scaling)+250), ((player1Body.getPosition().y/scaling))+200);

        if(!Gdx.input.isKeyPressed(Input.Keys.P))
        {
            if(Gdx.input.isKeyPressed(Input.Keys.UP)){
                angle=angle+1;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
                angle=angle-1;
            }

            if (Gdx.input.isKeyPressed(Input.Keys.W)){
                speed=speed+0.25f;
                if (speed>20){
                    speed=20;
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)){
                speed=speed-0.25f;
                if (speed<=0){
                    speed=1;
                }
            }

            Vector2 xycomp = getSpeed(angle);
            if (turn==0) {
                for (int i = 0; i < 2000; i++) {

                    //Vector2 traj = getTrajectoryPoint(new Vector2(player1Body.getPosition().x, player1Body.getPosition().y), new Vector2((1.25f / scaling) * xycomp.x, (1.25f / scaling) * xycomp.y), i);
                    Vector2 traj = getTrajectoryPoint(trajPosVec, new Vector2((speed / scaling) * xycomp.x, (speed / scaling) * xycomp.y), i);
                    trajPosVec=new Vector2(((player1Body.getPosition().x/scaling)+250), ((player1Body.getPosition().y/scaling))+200);
                    game.batch.draw(w_1, traj.x, traj.y, (int) player1_tank.getCurrX(), (int) player1_tank.getCurrY(), 20, 50);
                }
            }
            else{
                for (int i = 0; i < 2000; i++) {

                    //Vector2 traj = getTrajectoryPoint(new Vector2(player1Body.getPosition().x, player1Body.getPosition().y), new Vector2((1.25f / scaling) * xycomp.x, (1.25f / scaling) * xycomp.y), i);
                    Vector2 traj = getTrajectoryPoint(trajPosVec, new Vector2((speed / scaling) * xycomp.x, (speed / scaling) * xycomp.y), i);
                    trajPosVec=new Vector2(((player2Body.getPosition().x/scaling)+250), ((player2Body.getPosition().y/scaling))+200);
                    game.batch.draw(w_1, traj.x, traj.y, (int) player1_tank.getCurrX(), (int) player1_tank.getCurrY(), 20, 50);
                }
            }
        }





        game.batch.draw(player1_tank.getTank(), player1Body.getPosition().x/scaling, player1Body.getPosition().y/scaling, 300, 200);
        game.batch.draw(player2_tank.getTank(), player2Body.getPosition().x/scaling, player2Body.getPosition().y/scaling, 300, 200);
        game.batch.draw(w_1, player1Body.getPosition().x/scaling, player1Body.getPosition().y/scaling, 10, 10);
//        testWeapon.getPosition().x=player1Body.getPosition().x;
//        testWeapon.getPosition().y=player1Body.getPosition().y;
        if(Gdx.input.isKeyPressed(Input.Keys.P)) {
            if (turn==1)
                testWeapon = shoot(player1_tank, ((player1Body.getPosition().x)+250*scaling), ((player1Body.getPosition().y)+200*scaling), weapon1,speed,(float)angle);
            else
                testWeapon = shoot(player2_tank, ((player2Body.getPosition().x)+250*scaling), ((player2Body.getPosition().y)+200*scaling), weapon1,speed,(float)angle);

            //game.batch.draw(w_1, testWeapon.getPosition().x / scaling, testWeapon.getPosition().y / scaling, 0, 0, 50, 50, 1, 1, testWeapon.getAngle(), 0, 0, (int) (w_1.getTextureData().getWidth()), (int) (w_1.getTextureData().getHeight()), false, false);
        }
        if(testWeapon==null){

        }
        else{
            game.batch.draw(w_1, testWeapon.getPosition().x / scaling, testWeapon.getPosition().y / scaling, 0, 0, 50, 50, 1, 1, testWeapon.getAngle(), 0, 0, (int) (w_1.getTextureData().getWidth()), (int) (w_1.getTextureData().getHeight()), false, false);
            if(collision_checker(player2Body, testWeapon)){
                System.out.println("Collision");
                player2Body.setLinearVelocity(50*scaling, 0);
            }

        }

            //System.out.println("weapon: "+testWeapon.getPosition());
//        System.out.println("Player2: "+player2Body.getPosition());
//        System.out.println("Ground: "+groundBody.getPosition());

        game.batch.end();
    }

    private void update(float deltaTime) {
    }

    static final float STEP_TIME = 1f / 60f;
    static final int VELOCITY_ITERATIONS = 6;
    static final int POSITION_ITERATIONS = 2;

    float accumulator = 0;

    private void stepWorld() {
        float delta = Gdx.graphics.getDeltaTime();

        accumulator += Math.min(delta, 0.25f);

        if (accumulator >= STEP_TIME) {
            accumulator -= STEP_TIME;

            world.step(STEP_TIME, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
        }
    }
    @Override
    public void resize(int width, int height) {
//        camera.setToOrtho(false, width/2, height/2);
        camera.viewportHeight = (20 / width) * height;
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


    public Vector2 metersToPixels(float xM, float yM){
        return new Vector2(xM/scaling, yM/scaling);
    }

    public Vector2 pixelsToMeters(float xP, float yP){
        return new Vector2(xP*scaling, yP*scaling);
    }
}