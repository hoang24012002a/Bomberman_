package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Entity extends Actor {
    protected double positionX = 0;
    protected double positionY = 0;
    protected TextureRegion texture;

    protected void setPositionX(double x) {
        this.positionX = x;
    }

    protected void setPositionY(double y) {
        this.positionY = y;
    }

    public Entity() {
        this.positionX = 0;
        this.positionY = 0;
    }

    public Entity(double x, double y) {
        setPositionX(x);
        setPositionY(y);
    }

    @Override
    public void draw(Batch batch, float alpha) {
        //Gdx.gl.glClearColor(1, 1, 1, 1);
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.draw(texture, (float) positionX, (float) positionY);
    }
}
