package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * abtract class của các đối tượng có animation.
 */
public abstract class AnimatedEntity extends Entity {
    protected TextureAtlas textureAtlas;
    protected Animation animation;
    protected float elapsedTime = 0;

    public AnimatedEntity(float x, float y) {
        super(x, y);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        elapsedTime += Gdx.graphics.getDeltaTime();
        this.setPosition(positionX, positionY);
        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, true), positionX, positionY);
    }
}
