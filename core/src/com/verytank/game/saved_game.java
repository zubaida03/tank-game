package com.verytank.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class saved_game {
    private HashMap<Integer, List<player>> saved = new HashMap<Integer, List<player>>();
    private static saved_game saved_game;
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

}
