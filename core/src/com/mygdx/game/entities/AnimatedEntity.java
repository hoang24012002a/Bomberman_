package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
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

    public AnimatedEntity() {
        super();
    }

    public AnimatedEntity(double x, double y) {
        super(x, y);
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        elapsedTime += Gdx.graphics.getDeltaTime();
        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, true),(float) positionX, (float) positionY);
    }
}
