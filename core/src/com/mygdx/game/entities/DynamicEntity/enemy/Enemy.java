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
    public boolean isAlive() {
        if (!alive) {
            return false;
        }
        Actor actor = stageScreen.getAt(getX() - 1, getY() + 16);
        Actor actor1 = stageScreen.getAt(getX() + 16, getY() + 33);
        Actor actor2 = stageScreen.getAt(getX() + 33, getY() + 16);
        Actor actor3 = stageScreen.getAt(getX() + 16, getY() - 1);
        if (actor instanceof Flame || actor1 instanceof Flame || actor2 instanceof Flame || actor3 instanceof Flame) {
            alive = false;
            return false;
        }
        return true;
    }
}
