package com.verytank.game;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class weapon {
    private int maxpower;
    private int maxlaunchspeed;
    private float xcurr;
    private float ycurr;
    private Rectangle weapon1Rect;
    private Texture texture;

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public int getMaxpower() {
        return maxpower;
    }

    public void setMaxpower(int maxpower) {
        this.maxpower = maxpower;
    }

    public int getMaxlaunchspeed() {
        return maxlaunchspeed;
    }

    public void setMaxlaunchspeed(int maxlaunchspeed) {
        this.maxlaunchspeed = maxlaunchspeed;
    }

    public float getXcurr() {
        return xcurr;
    }

    public void setXcurr(float xcurr) {
        this.xcurr = xcurr;
    }

    public float getYcurr() {
        return ycurr;
    }

    public void setYcurr(float ycurr) {
        this.ycurr = ycurr;
    }
    public void setWeapon(Rectangle weapon){
        this.weapon1Rect = weapon;
    }

    public Rectangle getWeapon1Rect() {
        return weapon1Rect;
    }

    public void setWeapon1Rect(Rectangle weapon1Rect) {
        this.weapon1Rect = weapon1Rect;
    }

    public weapon(int maxpower, int maxlaunchspeed, float xcurr, float ycurr, Rectangle weapon1Rect, Texture texture){
        setMaxlaunchspeed(maxlaunchspeed);
        setMaxpower(maxpower);
        setXcurr(xcurr);
        setYcurr(ycurr);
        setTexture(texture);

    }
}