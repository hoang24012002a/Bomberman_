package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.*;

/**
 * abtract class của các đối tượng có animation.
 */
public abstract class AnimatedEntity extends Entity {
    protected TextureAtlas textureAtlas;
    protected Animation animation;
    protected float elapsedTime = 0;

    public AnimatedEntity() {
        super();
    }

    public AnimatedEntity(float x, float y) {
        super(x, y);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        elapsedTime += Gdx.graphics.getDeltaTime();
        this.setPosition(positionX, positionY);
        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, true), positionX, positionY);
    }

}
