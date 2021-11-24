package com.mygdx.game.entities;

public abstract class StaticEntities extends Entity{
    protected boolean canBreakable;

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

}