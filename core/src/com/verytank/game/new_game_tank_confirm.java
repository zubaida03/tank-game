package com.verytank.game;

import com.badlogic.gdx.Screen;

public class new_game_tank_confirm implements Screen {
    private Very_Tank game;
    private new_game selection;
    private new_game_tank_confirm details_receiver;
    private tank player1_tank;
    private tank player2_tank;
    private String player1_name;
    private String player2_name;
    private player p1;
    private player p2;
    private saved_game saved_game;
    private boolean playerwho = false;

    public void setPlayer1_tank(tank player1_tank) {
        this.player1_tank = player1_tank;
        player1_tank.printshit();
        createp1object(player1_tank, player1_name);
    }
    public void setPlayer2_tank(tank player2_tank) {
        this.player2_tank = player2_tank;
        player2_tank.printshit();
        createp2object(player2_tank, player2_name);
    }
    public void which_player(){
        this.playerwho = true;
    }

    public boolean isPlayerwho() {
        return playerwho;
    }

    public void setPlayer1_name(String player1_name) {
        this.player1_name = player1_name;
        System.out.println("player1_name: " + player1_name);
    }
    public void setPlayer2_name(String player2_name) {
        this.player2_name = player2_name;
        which_player();
        System.out.println("player2_name: " + player2_name);
    }
    public void createp1object(tank player1_tank,String player1_name) {
        p1 = new player(player1_name, player1_tank);
        saved_game = saved_game.getInstance();
    }
    public void createp2object(tank player2_tank,String player2_name) {
        p2 = new player(player2_name, player2_tank);
        saved_game = saved_game.getInstance();
        saved_game.save(p1, p2);

        saved_game.printshit();
    }



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

    public tank getPlayer1_tank() {
        return player1_tank;
    }
    public tank getPlayer2_tank() {
        return player2_tank;
    }
}
