package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

    public Entity() {
        this.positionX = 0;
        this.positionY = 0;
    }

    public Entity(float x, float y) {
        setPositionX(x);
        setPositionY(y);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.draw(texture, (float) positionX, (float) positionY);
    }

    public abstract void render();

}
