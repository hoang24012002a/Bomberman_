package com.mygdx.game.entities.DynamicEntity.enemy;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.entities.DynamicEntity.Character;
import com.mygdx.game.entities.DynamicEntity.enemy.AI.AI;
import com.mygdx.game.entities.StaticEntity.Bomb.Flame;

public abstract class Enemy extends Character {
    public static int numberEnemy = 0;
    protected int direction = 0;
    protected AI ai;

    public Enemy(float x, float y) {
        super(x, y);
        numberEnemy++;
    }

    protected abstract int calculateDir();

    @Override
    public boolean isAlive(Actor actor) {
        if (!alive) {
            return false;
        }
        if (actor instanceof Flame) {
            return false;
        }
        return true;
    }
}
