package com.mygdx.game.entities.StaticEntity.Bomb;

import com.mygdx.game.entities.AnimatedEntity;
import com.mygdx.game.gamesys.GameManager;


/**
 * class Bomb.
 */
public class Bomb extends AnimatedEntity {

    protected final float timeToExplode = 2000; // 2000ms
    protected int numberOfBomb = 1;

    public Bomb(float x, float y){
        super(x, y);
        textureAtlas = GameManager.bombFLick;
        animation = GameManager.bombFlicker;
    }

    public int getNumberOfBomb() {
        return numberOfBomb;
    }

}
