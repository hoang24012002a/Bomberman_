package com.mygdx.game.entities;

public abstract class StaticEntities extends Entity {
  protected boolean canBreakable;
  protected boolean canPass;

  public StaticEntities(float positionX, float positionY, boolean canBreakable) {
    super(positionX, positionY);
    this.canBreakable = canBreakable;
  }

  public StaticEntities(float positionX, float positionY) {
    super(positionX, positionY);
    this.canBreakable = false;
    this.canPass = false;
  }

  public void setCanBreakale(boolean canBreakable) {
    this.canBreakable = canBreakable;
  }

  public boolean isCanBreakable() {
    return canBreakable;
  }

  public boolean isCanPass() {
    return canPass;
  }

  public void setCanPass(boolean canPass) {
    this.canPass = canPass;
  }
}
