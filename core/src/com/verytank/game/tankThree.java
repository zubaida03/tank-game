package com.verytank.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class tankThree implements tankAnimation{
    Texture ani;
    TextureRegion[] aniFrame;
    private Animation animation;


    public Animation getAnimation(){
        ani=new Texture("tank3.png");
        TextureRegion[][] tmpFrame= TextureRegion.split(ani, 305, 204);
        aniFrame=new TextureRegion[4];
        int index=0;

        for (int i=0; i<2; i++){
            for (int j=0; j<2; j++){
                aniFrame[index++]=tmpFrame[j][i];
            }
        }
        //System.out.println(aniFrame);
        animation=new Animation<TextureRegion>(1f/4f,aniFrame);
        return animation;
    }
}
