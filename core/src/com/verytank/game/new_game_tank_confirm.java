package com.verytank.game;

import com.badlogic.gdx.Screen;

public class new_game_tank_confirm implements Screen {
    private Very_Tank game;
    private new_game selection;
    private String player1_name;
    private String player2_name;

    public new_game_tank_confirm(Very_Tank game) {
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.setScreen(new new_game(game));
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
