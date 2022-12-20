package com.verytank.game;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class tank {
    private String name;
    private int speed;
    private int maxHealth;
    private int maxspeed;
    private int currHealth;
    private int currFuel;
    private float currX;
    private float currY;
    private Rectangle tank;
    private Texture texture;

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
    public int getMaxspeed() {
        return maxspeed;
    }
    public void setMaxspeed(int maxFuel) {
        this.maxspeed = maxFuel;
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
    public float getCurrX() {
        return currX;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setCurrX(float currX) {
        this.currX = currX;
    }
    public float getCurrY() {
        return currY;
    }
    public void setCurrY(float currY) {
        this.currY = currY;
    }
    public Texture getTank() {
        return texture;
    }
    public void setTank(Texture tank) {
        this.texture = tank;
    }
    public tank(float currX, float currY, int currHealth, int currFuel, int speed, int maxHealth, int maxspeed,String name,Texture texture) {
        setCurrY(currY);
        setCurrX(currX);
        setCurrHealth(currHealth);
        setCurrFuel(currFuel);
        setSpeed(speed);
        setMaxHealth(maxHealth);
        setMaxspeed(maxspeed);
        setName(name);
        setTank(texture);
    }

    public void printshit() {
        System.out.println("name: " + name);
        System.out.println("speed: " + speed);
        System.out.println("maxHealth: " + maxHealth);
        System.out.println("maxspeed: " + maxspeed);
        System.out.println("currHealth: " + currHealth);
        System.out.println("currFuel: " + currFuel);
        System.out.println("currX: " + currX);
        System.out.println("currY: " + currY);
    }

}