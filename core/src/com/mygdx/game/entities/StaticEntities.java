package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public abstract class StaticEntities extends Entity{
    protected boolean canBreakable;
    protected SpriteBatch batch;

    public StaticEntities(float positionX, float positionY, boolean canBreakable){
        super(positionX, positionY);
        this.canBreakable=canBreakable;
    }

    public StaticEntities(float positionX, float positionY){
        super(positionX, positionY);
    }

    public void setCanBreakale(boolean canBreakable){
        this.canBreakable=canBreakable;
    }

    public abstract void draw(Batch batch, float parentDelta);

    //public abstract void create();

    //public abstract void render();

    public abstract void dispose();

}
