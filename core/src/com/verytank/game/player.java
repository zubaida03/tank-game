package com.verytank.game;

public class player {
    private String name;
    private tank tank;

    public String getName() {
        return name;
    }

    public com.verytank.game.tank getTank() {
        return tank;
    }

    public player(String name, tank tank) {
        this.name = name;
        this.tank = tank;
    }
}

