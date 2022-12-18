package com.verytank.game;

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

