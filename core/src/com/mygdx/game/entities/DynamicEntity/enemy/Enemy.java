package com.mygdx.game.entities.DynamicEntity.enemy;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.entities.DynamicEntity.Character;
import com.mygdx.game.entities.StaticEntity.Bomb.Flame;

public abstract class Enemy extends Character {
    protected int direction = 0;

    public Enemy(float x, float y) {
        super(x, y);
    }

    protected abstract int calculateDir();

    @Override
    public boolean isAlive() {
        Actor actor = stageScreen.getAt(positionX, positionY);
        Actor actor1 = stageScreen.getAt(positionX, positionY);
        return !(actor instanceof Flame) && !(actor1 instanceof Flame);
    }
}
