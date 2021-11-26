package com.mygdx.game.entities.StaticEntity.Bomb;

import com.mygdx.game.entities.AnimatedEntity;
import com.mygdx.game.gamesys.GameManager;


/**
 * class Bomb.
 */
public class Bomb extends AnimatedEntity {

    protected final int timeToExplode = 3000; // 2000ms
    protected int numberOfBomb = 1;

    public Bomb(float x, float y){
        super(x, y);
        textureAtlas = GameManager.bombFlick.getKey();
        animation = GameManager.bombFlick.getValue();
    }

    public int getNumberOfBomb() {
        return numberOfBomb;
    }


    @Override
    public void act(float delta) {
            final Bomb _this = this;
            textureAtlas = GameManager.bombFlick.getKey();
            animation = GameManager.bombFlick.getValue();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(timeToExplode);
                        getStage().getActors().removeValue(_this, true);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            return;
    }

}
