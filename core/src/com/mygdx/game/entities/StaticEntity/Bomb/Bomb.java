package com.mygdx.game.entities.StaticEntity.Bomb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.entities.AnimatedEntity;
import com.mygdx.game.gamesys.GameManager;


/**
 * class Bomb.
 */
public class Bomb extends AnimatedEntity {

    protected final float timeToExplode = 2000; // 2000ms
    protected int numberOfBomb = 1;
    // Frame that must be rendered at each time
    private TextureRegion currentFrame;


    public Bomb(float x, float y){
        super(x, y);
        textureAtlas = GameManager.bombFLick;
        animation = GameManager.bombFlicker;
    }

    public int getNumberOfBomb() {
        return numberOfBomb;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void render(){
        // Elapsed time
        elapsedTime += Gdx.graphics.getDeltaTime();

        // Getting the frame we must draw at this moment
        currentFrame = (TextureRegion) GameManager.flameVerTopLast.getKeyFrame(elapsedTime);
        // Drawing on the screen
        batch.begin();
        batch.draw(currentFrame, positionX + 100, positionY+100);
        batch.end();
    }

    @Override
    public void dispose(){
        textureAtlas.dispose();
        texture.dispose();
    }
}
