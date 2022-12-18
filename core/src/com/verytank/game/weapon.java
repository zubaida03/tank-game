package com.verytank.game;

import java.awt.*;

public class weapon {
    private int maxpower;
    private int maxlaunchspeed;
    private float xcurr;
    private float ycurr;
    private Rectangle weapon1Rect;

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
    public weapon(int maxpower, int maxlaunchspeed, float xcurr, float ycurr, Rectangle weapon1Rect){
        setMaxlaunchspeed(maxlaunchspeed);
        setMaxpower(maxpower);
        setXcurr(xcurr);
        setYcurr(ycurr);
    }
}
