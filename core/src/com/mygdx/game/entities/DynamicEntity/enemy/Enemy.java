package com.mygdx.game.entities.DynamicEntity.enemy;

import com.mygdx.game.entities.DynamicEntity.Character;

public abstract class Enemy extends Character {
    public Enemy() {
        super();
    }

    public Enemy(float x, float y) {
        super(x, y);
    }

    @Override
    protected void killed() {

    }

    protected abstract int calculateDir();
}
