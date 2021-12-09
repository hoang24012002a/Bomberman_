package com.mygdx.game.map;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MyActor extends Actor {
  public TextureRegion text;

  public MyActor(TextureRegion text) {
    this.text = text;
  }

  public void draw(Batch batch, float alpha) {
    batch.draw(
        text,
        getX(),
        getY(),
        getOriginX(),
        getOriginY(),
        getWidth(),
        getHeight(),
        getScaleX(),
        getScaleY(),
        getRotation());
  }
}
