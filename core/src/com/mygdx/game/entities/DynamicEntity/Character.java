package com.mygdx.game.entities.DynamicEntity;

import com.mygdx.game.entities.AnimatedEntity;

public abstract class Character extends AnimatedEntity {
    protected float speed;
    protected boolean alive = true;

    protected Character() {
        super();
        speed = 1;
    }

    protected Character(float x, float y) {
        super(x, y);
        speed = 1;
    }

    public boolean isAlive() {
        return alive;
    }

    protected boolean canMoveRight() {
        return true;
    }

    protected boolean canMoveLeft() {
        return true;
    }

    protected boolean canMoveTop() {
        return true;
    }

    protected boolean canMoveBottom() {
        return true;
    }

    protected abstract void killed();

    protected abstract void moveRight();

    protected abstract void moveLeft();

    protected abstract void moveTop();

    protected abstract void moveBottom();
}
