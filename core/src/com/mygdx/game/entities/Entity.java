package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Entity extends Actor {
    protected float positionX = 0;
    protected float positionY = 0;
    protected Texture texture;

    protected void setPositionX(float x) {
        this.positionX = x;
    }

    protected void setPositionY(float y) {
        this.positionY = y;
    }

    public float getPositionX() {
        return positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public Entity(float x, float y) {
        setPositionX(x);
        setPositionY(y);
        this.setPosition(positionX, positionY);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        this.setPosition(positionX, positionY);
        batch.draw(texture, positionX, positionY);
    }

}