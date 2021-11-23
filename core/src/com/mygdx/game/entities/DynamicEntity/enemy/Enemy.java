package com.mygdx.game.entities.DynamicEntity.enemy;

import com.mygdx.game.entities.DynamicEntity.Character;

public abstract class Enemy extends Character {
    protected int direction = 0;

    public Enemy(float x, float y) {
        super(x, y);
    }

    @Override
    protected void killed() {
        if (positionX == 150) {
            alive = false;
        }
    }

    protected abstract int calculateDir();
}
