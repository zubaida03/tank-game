package com.verytank.game;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class saved_game {
    private HashMap<Integer, List<player>> saved = new HashMap<Integer, List<player>>();

    private static saved_game saved_game;

    public HashMap<Integer, List<player>> getSaved() {
        return saved;
    }

    private int count = 1;
    private saved_game(){
    }

    public static saved_game getInstance(){
        if (saved_game == null){
            saved_game = new saved_game();
        }
        return saved_game;
    }
    public void save(player p1, player p2) {
        List list = new ArrayList();
        list.add(p1);
        list.add(p2);
        saved.put(this.count, list);
        this.count++;
        printshit();
    }
    public void printshit() {
        for (int i = 1; i < this.count; i++) {
            System.out.println("saved_game: " + saved.get(i));
        }
    }
//    public static void main(String[]args){
//        saved_game saved_game = new saved_game();
//
//        saved_game.printshit();
//    }
    public void testing(){
        player p1 = new player("p1",new tank(100, 100, 40, 100, 90, 40, 90, "t1", new Texture("tan2_img.png")));
        player p2 = new player("p2",new tank(100, 100, 40, 100, 90, 40, 90, "t2", new Texture("tan2_img.png")));
        saved_game.save(p1, p2);

    }

}
