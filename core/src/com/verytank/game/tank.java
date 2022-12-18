package com.verytank.game;//package com.verytank.game;
//
//import com.badlogic.gdx.*;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.math.Rectangle;
//
//public class tank implements Screen{
//    private final Very_Tank game;
//    private SpriteBatch batch;
//    private Texture tank1;
//    private Rectangle tank1Rect;
//    private Texture tank2;
//    private Rectangle tank2Rect;
//    private String name;
//    private int speed;
//    private int maxHealth;
//    private int maxFuel;
//    private int currHealth;
//    private int currFuel;
//    private int currX;
//    private int currY;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//    public int getSpeed() {
//        return speed;
//    }
//    public void setSpeed(int speed) {
//        this.speed = speed;
//    }
//    public int getMaxHealth() {
//        return maxHealth;
//    }
//    public void setMaxHealth(int maxHealth) {
//        this.maxHealth = maxHealth;
//    }
//    public int getMaxFuel() {
//        return maxFuel;
//    }
//    public void setMaxFuel(int maxFuel) {
//        this.maxFuel = maxFuel;
//    }
//    public int getCurrHealth() {
//        return currHealth;
//    }
//    public void setCurrHealth(int currHealth) {
//        this.currHealth = currHealth;
//    }
//    public int getCurrFuel() {
//        return currFuel;
//    }
//    public void setCurrFuel(int currFuel) {
//        this.currFuel = currFuel;
//    }
//    public int getCurrX() {
//        return currX;
//    }
//    public void setCurrX(int currX) {
//        this.currX = currX;
//    }
//    public int getCurrY() {
//        return currY;
//    }
//    public void setCurrY(int currY) {
//        this.currY = currY;
//    }
//
//    public tank(Very_Tank game) {
//        batch = new SpriteBatch();
//        this.game = game;
//        tank1 = new Texture("tank1.png");
//        tank1Rect = new Rectangle();
//        tank1Rect.x = 400;
//        tank1Rect.y = 200;
//        tank1Rect.width = 300;
//        tank1Rect.height = 150;
//    }
//
//    @Override
//    public void show() {
//        Gdx.input.setInputProcessor(new InputAdapter(){
//        });
//
//    }
//
//    @Override
//    public void render(float delta) {
//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && tank1Rect.x>0) tank1Rect.x -= 200*Gdx.graphics.getDeltaTime();
//        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)&& tank1Rect.x<Gdx.graphics.getWidth()-300) tank1Rect.x += 200*Gdx.graphics.getDeltaTime();
//        batch.begin();
//        batch.draw(tank1, tank1Rect.x, tank1Rect.y, tank1Rect.width, tank1Rect.height);
//        batch.end();
//
//    }
//
//    @Override
//    public void resize(int width, int height) {
//
//    }
//
//    @Override
//    public void pause() {
//
//    }
//
//    @Override
//    public void resume() {
//
//    }
//
//    @Override
//    public void hide() {
//        Gdx.input.setInputProcessor(null);
//    }
//
//    @Override
//    public void dispose() {
//
//    }
//}

import java.awt.*;

public class tank {
    private String name;
    private int speed;
    private int maxHealth;
    private int maxFuel;
    private int currHealth;
    private int currFuel;
    private int currX;
    private int currY;
    private Rectangle tank;

    public String getName() {
        return name;
    }
    public void setRect(Rectangle tank) {
        this.tank = tank;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    public int getMaxFuel() {
        return maxFuel;
    }
    public void setMaxFuel(int maxFuel) {
        this.maxFuel = maxFuel;
    }
    public int getCurrHealth() {
        return currHealth;
    }
    public void setCurrHealth(int currHealth) {
        this.currHealth = currHealth;
    }
    public int getCurrFuel() {
        return currFuel;
    }
    public void setCurrFuel(int currFuel) {
        this.currFuel = currFuel;
    }
    public int getCurrX() {
        return currX;
    }
    public void setCurrX(int currX) {
        this.currX = currX;
    }
    public int getCurrY() {
        return currY;
    }
    public void setCurrY(int currY) {
        this.currY = currY;
    }
    public tank(int currX, int currY, int currHealth, int currFuel, int speed, int maxHealth, int maxFuel,Rectangle tank, String name) {
        setCurrY(currY);
        setCurrX(currX);
        setCurrHealth(currHealth);
        setCurrFuel(currFuel);
        setSpeed(speed);
        setMaxHealth(maxHealth);
        setMaxFuel(maxFuel);
        setName(name);
    }

}

